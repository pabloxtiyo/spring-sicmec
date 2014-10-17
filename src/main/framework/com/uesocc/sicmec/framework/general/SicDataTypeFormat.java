/**
 * 
 */
package com.uesocc.sicmec.framework.general;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * @author xtiyo
 *
 */
public class SicDataTypeFormat 
{

		private final static Logger logger = Logger.getLogger(SicDataTypeFormat.class);

		public static String toStringValue(String object) {
			if (isNotNull(object)) {
				if (isNotEmpty(object)) {
					return object.toString().trim();
				}
			}
			return null;
		}

		public static Integer toIntValue(String object) {
			if (isNotNull(object)) {
				try {
					if (isNotEmpty(object)) {
						return new Integer(object.toString().trim());
					}
				} catch (NumberFormatException e) {
					logger.error(e);
					return null;
				}
			}
			return null;
		}

		/**
		 * The default value is 0
		 */
		public static Integer toIntValueWithDefault(String object) {
			Integer intValue = toIntValue(object);
			if (intValue != null) {
				return intValue;
			}
			return 0;
		}
		
		
		
		public static java.util.Date toDateValue(String object) throws ParseException{
			SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
			if (isNotNull(object)) 
			{
				
			return formatoDeFecha.parse(object);
			
			}
			return null;
		}
		
		public static java.util.Date toDateTimeValue(String object) throws ParseException{
			SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if (isNotNull(object)) 
			{
				
				return formato.parse(object);
			
			}
			
			return null;
		}

		public static Time toTimeValue(String object) {
			if (isNotNull(object)) {
				java.util.Date parsedDate = Date.valueOf(object);
				return new Time(parsedDate.getTime());
			}
			return null;
		}

		public static Boolean toBooleanValue(String object) {
			if (isNotNull(object)) {
				return new Boolean(object.toString());
			}
			return false;
		}

		public static BigDecimal toBigDecimalValue(String object) {
			if (isNotNull(object)) {
				return new BigDecimal(object.toString());
			}
			return null;
		}

		private static boolean isNotNull(String object) {
			return (object != null);
		}

		private static boolean isNotEmpty(String object) {
			return !object.toString().trim().equals("");
		}

		public static BigInteger toBigInter(String object) {
			if (isNotNull(object)) {
				if(!object.equals("")){
					return new BigInteger(object);	
				}
				else
				{
					return null;
				}
				
				
			}
			return null;
		}
	}
