package cn.ssh.dao;

import java.util.Collection;

public interface BaseDao<T> {
	
	/**
	 * 添加数据
	 * @param t 接收一个实例对象
	 */
	public void saveEntry(T t);
	
	/**
	 * 删除一条数据
	 * @param id 接收要删除的id值
	 */
	public void deleteEntry(Integer id);
	
	/**
	 * 更新数据
	 * @param t 接收一个实例对象
	 */
	public void updateEntry(T t);
	
	/**
	 * 查询一条数据
	 * @param id 接收要查询的id
	 * @return 返回一条实例对象数据
	 */
	public T getEntry(Integer id);
	
	/**
	 * 查询所有数据
	 * @return 查询到的所有数据
	 */
	public Collection<T> getAllEntry();
	
	
}
