package org.kornogcomputing.bossanova.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Date;


/**
 * some tools for application
 * 
 * @author herve
 * 
 */
public final class BNUtils {


	/**
	 * constructor
	 */
	private BNUtils() {
	}

	/**
	 * 
	 * @param date
	 *            Date
	 * @return string formatted (ex: 1 mars 2011 15:20)
	 */
	public static String formatCourt(final Date date) {
		synchronized (BNStatic.LOCALDATEFORMATCOURT) {
			if (date != null) {
				return BNStatic.LOCALDATEFORMATCOURT.format(date);
			}
			return "";
		}
	}

	/**
	 * 
	 * @param date
	 *            date
	 * @return string formatted
	 */
	public static  String formatLong(final Date date) {
		synchronized (BNStatic.LOCALDATEFORMAT) {
			if (date != null) {
				return  BNStatic.LOCALDATEFORMAT.format(date);
			}
			return "";
		}
	}


	/**
	 * change null value to 0
	 * 
	 * @param val
	 *            BigDecimal
	 * @return val if not null, 0 else
	 */
	public static BigDecimal nullToZero(final BigDecimal val) {
		if (val == null) {
			return BigDecimal.ZERO;
		} else {
			return val;
		}
	}

	/**
	 * change null value to 0
	 * 
	 * @param val
	 *            Long
	 * @return val if not null, 0 else
	 */
	public static Long nullToZero(final Long val) {
		if (val == null) {
			return Long.valueOf(0);
		} else {
			return val;
		}
	}
	/**
	 * change null value to 1
	 * 
	 * @param val
	 *            integer value
	 * @return val if not null, 1 else
	 */
	public static int nullToOne(Integer val) {
		if (val == null) {
			return 1;
		}
		return val;
	}

	/**
	 * change null value to empty string
	 * @param val string value
	 * @return val if not null, empty string else
	 */
	public static String nullToEmpty(final String val) {
		if (val != null) {
			return val.trim();
		}
		return "";
	}
	/**
	 * change null value to empty string
	 * @param val object value
	 * @return val if not null, empty string else
	 */
	public static String nullToEmpty(final Object val) {
		if (val != null) {
			return val.toString();
		}
		return "";
	}
	/**
	 * change null value to empty string
	 * @param val big decimal value
	 * @return val if not null, empty string else
	 */
	public static String nullToEmpty(final BigDecimal val) {
		if (val != null) {
			return val.toString();
		}
		return "";
	}
	/**
	 * change null value to true
	 * @param val bool value
	 * @return val if not null, true elsewhere
	 */
	public static boolean nullToTrue(final Boolean val) {
		if (val != null) {
			return val;
		}
		return true;
	}
	/**
	 * change null value to object tab
	 * @param param array of object or null
	 * @return the object array itself or new object[0] if null
	 */
	private static Object[] nullToEmptyTab(Object[] param) {
		if (param == null) {
			return new Object[0];
		}
		return param;
	}
	

	/**
	 * get available list of getter and setter of class in parameter
	 * @param aClass the class to analyse
	 */
	public static void printGettersSetters(Class<?> aClass) {
		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			if (isGetter(method)) {
				System.out.println("getter: " + method);
			}
			if (isSetter(method)) {
				System.out.println("setter: " + method);
			}
		}
	}
	
	/**
	 * get the getter method for the couple class/field in parameter
	 * @param aClass the class
	 * @param field the class parameter which get getter method
	 * @return the getter method, null if not found
	 */
	public static Method getGetter(Class<?> aClass, String field) {
		Method[] methods = aClass.getMethods();
		for (Method method : methods) {
			
			if ((("get" + field).equalsIgnoreCase(method.getName()) 
					&& !method.getReturnType().equals(void.class)) 
				|| (("is" + field).equalsIgnoreCase(method.getName())
				&& method.getReturnType().equals(boolean.class))) {
				return method;
			}
		}
		return null;
	}
	
	/**
	 * get the setter method for the couple class/field in parameter
	 * @param aClass the class
	 * @param field the class parameter which get setter method
	 * @return the setter method, null if not found
	 */
	public static Method getSetter(Class<?> aClass, String field) {
		Method[] methods = aClass.getMethods();
		for (Method method : methods) {
			
			if ((("set" + field).equalsIgnoreCase(method.getName()) 
					&& method.getReturnType().equals(void.class))) {
				return method;
			}
		}
		return null;
	}
	
	/**
	 * analyse the method in parameter to know if its a getter method
	 * @param method the method to analyse
	 * @return true if the method is a getter
	 */
	public static boolean isGetter(Method method) {
		if (Modifier.isPublic(method.getModifiers())
				&& method.getParameterTypes().length == 0) {
			if (method.getName().matches("^get[A-Z].*") 
					&& !method.getReturnType().equals(void.class)) {
				return true;
			}
			if (method.getName().matches("^is[A-Z].*") 
					&& method.getReturnType().equals(boolean.class)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * analyse the method in parameter to know if its a setter method
	 * @param method the method to analyse
	 * @return true if the method is a setter
	 */
	public static boolean isSetter(Method method) {
		return Modifier.isPublic(method.getModifiers()) 
				&& method.getReturnType().equals(void.class) 
				&& method.getParameterTypes().length == 1 
				&& method.getName().matches("^set[A-Z].*");
	}

	
	/**
	 * execute the method representing by the function string in parameter
	 * the function is composed by the class name, the method name and the parameters
	 * format is "ClassName.MethodName(param1, param2 ...)"
	 * @param function the function to use
	 * @return the object returned by the method execution
	 */
	public static Object getFunctionVal(String function) {
		// first, decompose function to get class name and method
		String methodAndParam = function.substring(function.lastIndexOf(".") + 1, function.length());
		String className = function.substring(0, function.lastIndexOf(methodAndParam) - 1);
		String methodName = methodAndParam.substring(0, methodAndParam.indexOf("("));
	
		Object[] params;
		
		if (methodAndParam.indexOf("(") + 1 == methodAndParam.indexOf(")")) {
			params = new Object[0];
		} else {
			params = methodAndParam.substring(methodAndParam.indexOf("(") + 1, methodAndParam.indexOf(")")).split(",");
		}
		
		try {
			Method[] methods = Class.forName(className).getMethods();
			for (Method method : methods) {
				if (methodName.equalsIgnoreCase(method.getName())) {					
					Object obj = method.invoke(null, nullToEmptyTab(params));					
					return obj;
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "inconnu";
		
	}

	
	
	
}
