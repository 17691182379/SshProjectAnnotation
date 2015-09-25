package cn.ssh.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = 1L;
	public static final String LISTACTION = "listAction";
	public static final String ACTION2ACTION = "action2action";
	public static final String ADDUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public String listAction = LISTACTION;
	public String action2action = ACTION2ACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	
	private Class<T> classt;
	private T t;
	
	
	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.classt = (Class<T>) type.getActualTypeArguments()[0];
			this.t = (T) this.classt.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public T getModel() {
		return this.t;
	}
	
}
