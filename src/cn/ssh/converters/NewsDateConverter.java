package cn.ssh.converters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.util.ArrayUtils;

@SuppressWarnings("rawtypes")
public class NewsDateConverter extends StrutsTypeConverter {

	/** 
     * 日期格式 
     */  
    private String format = "yyyy-MM-dd";
    
    
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (ArrayUtils.isEmpty(values) ||StringUtils.isEmpty(values[0])) {     
            return null;     
        }  
         
        Date date = null;  
        try {  
            date = new SimpleDateFormat(format).parse(values[0]);       
        } catch (Exception e) {       
            date = null;       
        }  
        return date;
	}

	
	public String convertToString(Map context, Object o) {  
        if (o instanceof Date) {    
            return new SimpleDateFormat(format).format((Date) o);    
        }  
        return StringUtils.EMPTY;     
	}
	
}
