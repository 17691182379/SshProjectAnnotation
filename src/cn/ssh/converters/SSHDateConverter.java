package cn.ssh.converters;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 有问题
 */
@SuppressWarnings("rawtypes")
public class SSHDateConverter extends StrutsTypeConverter {
	
	private DateFormat dateFormat;
	
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(toClass == Date.class){
			try {
				return dateFormat.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public String convertToString(Map context, Object o) {
		if(o instanceof Date){
			return dateFormat.format((Date)o);
		}
		return null;
	}
	
}
