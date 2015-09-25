package cn.ssh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ssh.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private SessionFactory sessionFactory;
	private Class<T> classt;
	
	/**
	 * 1、在父类中要执行一段代码，这个代码的执行时间为子类创建对象的时候，这段代码已经执行完了，根据这个需求，有两种方案供选择
	 *      *  利用static语句块
	 *      *  利用父类的构造函数
	 * 2、分析：
	 *      因为得到ParameterizedType需要用到this关键字，而this关键字不能出现在static语句块中
	 *    所以只能选择父类的构造器
	 */
	public BaseDaoImpl() {
		/**
		 * ParameterizedType就是泛型
		 */
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classt = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println(type.getRawType());
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void saveEntry(T t) {
		this.getSession().save(t);
	}

	@Override
	public void deleteEntry(Integer id) {
		/*
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		 */
		T t = this.getEntry(id);
		this.getSession().delete(t);		
	}

	@Override
	public void updateEntry(T t) {
		this.getSession().update(t);
	}

	@Override
	public T getEntry(Integer id) {
		return (T) this.getSession().get(this.classt, id);
	}

	@Override
	public Collection<T> getAllEntry() {
		String hql = "from " + this.classt.getName() + " t order by t.id";
		return this.getSession().createQuery(hql).list();
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
