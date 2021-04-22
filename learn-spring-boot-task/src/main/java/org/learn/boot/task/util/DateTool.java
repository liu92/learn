package org.learn.boot.task.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期类型工具类
 * 
 * @ClassName: DateTool.java
 * @Description: 日期类型工具类
 * @author 
 * @version 
 * @Date 
 */
public class DateTool {

	/**
	 * 日期格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期格式：yyyyMMddHHmmss
	 */
	public static final String DATE_PATTERN_STRING = "yyyyMMddHHmmss";
	/**
	 * 日期格式：【yyyy】年【MM】月【dd】
	 */
	public static final String DATE_PATTERN_DAY_CHINNESS = "【yyyy】年【MM】月【dd】";
	/**
	 * 日期格式：yyyy年MM月dd日
	 */
	public static final String DATE_PATTERN_DAY_CHINNESS_DEFAULT = "yyyy年MM月dd日";
	/**
	 * 日期格式：yyyy-MM-dd
	 */
	public static final String DATE_PATTERN_DAY = "yyyy-MM-dd";
	/**
	 * 日期格式：yyyyMMdd
	 */
	public static final String DATE_PATTERN_NUMBER_DAY = "yyyyMMdd";

	/**
	 * 日期格式：yyyyMMdd
	 */
	public static final String DATE_PATTERN_DAY_NUM = "yyyyMMdd";

	/**
	 * 日期格式：yyyy/MM/dd
	 */
	public static final String DATE_PATTERN_FINISH_STRING = "yyyy/MM/dd";

	/**
	 * 日期格式：yyyy-MM
	 */
	public static final String DATE_PATTERN_MONTH = "yyyy-MM";

	/**
	 * 日期格式：yyyy
	 */
	public static final String DATE_PATTERN_YEAR = "yyyy";


	/**
	 * 日期格式：dd
	 */
	public static final String DATE_PATTERN_JUEST_DAY = "dd";


	/**
	 * 每天的最后时间点： " 23:59:59"
	 */
	public static final String DAY_LAST_TIME = " 23:59:59";
	/**
	 * 每天的最早时间点：" 00:00:00"
	 */
	public static final String DAY_FIRST_TIME = " 00:00:00";

	public static String[] weeks = { "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 日期格式，指定格式
	 * 
	 * @Title: dateToString
	 * @Description: 日期格式，指定格式
	 * @param: @param date 日期
	 * @param: @param pattern 格式
	 * @param: @return 日期格式之后的字符串
	 * @return: String
	 * @throws
	 * @author 
	 * @Date
	 */
	public static String dateToString(Date date, String pattern) {
		if(null == date){
			date = getCurrentDate();
		}
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(date);
	}

	/**
	 * 格式化时间格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @date 
	 * @author 
	 */
	public static Date formatDate(Date date, String pattern) {
		String dateStr = dateToString(new Date(), pattern);
		return stringToDate(dateStr, pattern);
	}

	public static Date formatDate(String date, String pattern) {
		return stringToDate(date, pattern);
	}

	/**
	 * 将字符串转化为日期,需指定字符串日期格式
	 * 
	 * @Title: stringToDate
	 * @Description: 将字符串转化为日期,需指定字符串日期格式
	 * @param: @param str 日期字符串
	 * @param: @param pattern 日期格式
	 * @param: @return 转换之后的日期对象
	 * @return: Date
	 * @throws
	 * @author
	 * @Date
	 */
	public static Date stringToDate(String str, String pattern) {
		Date dateTime = null;
		try {
			SimpleDateFormat formater = new SimpleDateFormat(pattern);
			dateTime = formater.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateTime;
	}



	/**
	 * 给定一个日期和天数，得到这个日期+天数的日期
	 * 
	 * @Title: getNextDay
	 * @Description: 给定一个日期和天数，得到这个日期+天数的日期
	 * @param: @param startDate 给定日期
	 * @param: @param num 天数
	 * @param: @return 计算之后的日期
	 * @return: Date
	 * @throws
	 * @author 
	 * @Date 
	 */
	public static Date getNextDay(Date startDate, int num) {
		return DateUtils.addDays(startDate, num);
	}

	/**
	 * 给定一个日期和月数，得到这个日期+月数的日期
	 * 
	 * @Title: getNextMonth
	 * @Description: 给定一个日期和月数，得到这个日期+月数的日期
	 * @param: @param startDate 给定的日期
	 * @param: @param num 月数
	 * @param: @return 计算之后的日期
	 * @return: Date
	 * @throws
	 * @author 
	 * @Date 
	 */
	public static Date getNextMonth(Date startDate, int num) {

		return DateUtils.addMonths(startDate, num);
	}


	/**
	 * 给定一个日期和月数，得到这个日期+年份的日期
	 *
	 * @Title: getNextMonth
	 * @Description: 给定一个日期和月数，得到这个日期+年份的日期
	 * @param: @param startDate 给定的日期
	 * @param: @param num 月数
	 * @param: @return 计算之后的日期
	 * @return: Date
	 * @throws
	 * @author
	 * @Date
	 */
	public static Date getNextYear(Date startDate, int num) {
		return DateUtils.addYears(startDate, num);
	}

	/**
	 * 取得一个date对象对应的日期的0点0分0秒时刻的Date对象。
	 * 
	 * @Title: getMinDateOfDay
	 * @Description: 取得一个date对象对应的日期的0点0分0秒时刻的Date对象。
	 * @param: @param date 给定的日期
	 * @param: @return 操作后的日期
	 * @return: Date
	 * @throws
	 * @author 
	 * @Date 
	 */
	public static Date getMinDateOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		instanceDate(calendar, Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE), Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND), Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND), Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		return calendar.getTime();
	}

	/**
	 * 取得一个date对象对应的日期的23点59分59秒时刻的Date对象。
	 * 
	 * @Title: getMaxDateOfDay
	 * @Description: 取得一个date对象对应的日期的23点59分59秒时刻的Date对象。
	 * @param: @param date 给定的日期
	 * @param: @return 处理之后的日期
	 * @return: Date
	 * @throws
	 * @author 
	 * @Date
	 */
	public static Date getMaxDateOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		instanceDate(calendar, Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY), Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE), Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND), Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 * 取得指定日期的开始始时间
	 * 
	 * @param date
	 * @return
	 * @date
	 * @author
	 */
	public static Date getStartDateTime(Date date) {
		String str = dateToString(date, DATE_PATTERN_DAY);
		str += DAY_FIRST_TIME;
		return stringToDate(str, DATE_PATTERN_DEFAULT);
	}

	/**
	 * 取得指定日期的结束时间
	 * 
	 * @param date
	 * @return
	 * @date
	 * @author
	 */
	public static Date getEndDateTime(Date date) {
		String str = dateToString(date, DATE_PATTERN_DAY);
		str += DAY_LAST_TIME;
		return stringToDate(str, DATE_PATTERN_DEFAULT);
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 * @date
	 * @author
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取指定日期的当月天数
	 * 
	 * @param date
	 *            指定日期
	 * @return 天数
	 * @date
	 * @author
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取指定日期的月份
	 * 
	 * @param date
	 *            指定日期
	 * @return 天数
	 * @date
	 * @author
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取指定日期的年份
	 * 
	 * @param date
	 *            指定日期
	 * @return 天数
	 * @date
	 * @author
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取某一年的第一天
	 * @param year
	 * @return
	 */
	public static Date getStartDateOfFirstDay(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		return getStartDateTime(calendar.getTime());
	}




	/**
	 * 获取某年最后一天日期 23:59:59
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearLast(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return getEndDateTime(currYearLast);
	}


	/**
	 * 计算两个时间之间相隔几天（两个都会转换成 00：00：00的时间）
	 * 
	 * @Title: getBetweenDay
	 * @Description:
	 * @param startDate
	 * @param endDate
	 * @return
	 * @return: int
	 * @throws
	 * @author 
	 * @Date
	 */
	public static int getBetweenDay(Date startDate, Date endDate) {

		if (startDate == null || endDate == null) {
			return 0;
		}

		// 进行时间转换
		startDate = getStartDateTime(startDate);
		endDate = getStartDateTime(endDate);

		long dayNumber = -1L;
		long DAY = 24L * 60L * 60L * 1000L;

		dayNumber = (endDate.getTime() - startDate.getTime()) / DAY;
		return (int) dayNumber;
	}


	/**
	 * 计算两个时间之间相隔多少周（两个都会转换成 00：00：00的时间）
	 * 这里是根据传入的参数 来计算有多少天
	 * @Title: getBetweenWeek
	 * @Description:
	 * @param startDate
	 * @param endDate
	 * @return
	 * @return: int
	 * @throws
	 * @author
	 * @Date
	 */
	public static int getBetweenWeek(Date startDate, Date endDate, int weekDay) {

		if (startDate == null || endDate == null) {
			throw new RuntimeException("时间格式不正确");
		}

		// 进行时间转换
		startDate = getStartDateTime(startDate);
		endDate = getStartDateTime(endDate);

		long dayNumber = -1L;
		long DAY = (24L * 60L * 60L * 1000L);

		//两个日期之间有多少天
		dayNumber = (endDate.getTime() - startDate.getTime()) / DAY;
		double days=Double.parseDouble(String.valueOf(dayNumber));
//		int weekDay = day;
		if((days/weekDay)>0 && (days/weekDay)<=1){
			//不满一周的按一周算
			return 1;
		}else if(days/weekDay>1){
			int day= (int) days;
			if(day%weekDay>0){
				return day/weekDay+1;
			}else{
				return day/weekDay;
			}
		}else if((days/weekDay)==0){
			return 0;
		}else{
			//负数返还null
			return -1;
		}
	}



	/**
	 * 获取两个时间相差月份
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Throwable
	 * @date
	 * @author
	 */
	public static long getBetweenMonth(Date startDate, Date endDate) throws Throwable {
		if (startDate == null || endDate == null) {
			throw new Throwable("时间格式不正确");
		}
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar2.setTime(endDate);
		return Math.abs(getByField(calendar, calendar2, Calendar.YEAR) * 12 + getByField(calendar, calendar2, Calendar.MONTH));

	}

	private static long getByField(Calendar beginCalendar, Calendar endCalendar, int calendarField) {
		return endCalendar.get(calendarField) - beginCalendar.get(calendarField);
	}

	/**
	 * 获取时间是星期几
	 * 
	 * @param date
	 * @return
	 * @date
	 * @author
	 */
	public static String getWeekByDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weeks[w];
	}

	public static Date getAfterTime(Date date, int days, int hours, int mins) {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		if (date == null) {
			assert false;
			calendar.setTime(date);
		} else {
			calendar.setTime(new Date());
		}
		calendar.add(Calendar.DAY_OF_YEAR, days);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		calendar.add(Calendar.MINUTE, mins);
		return calendar.getTime();
	}

	public static Date getStartSec(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date == null) {
			return null;
		}
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getEndSec(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date == null) {
			return null;
		}
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 当月最后一天
	 * 
	 * @param date
	 * @return
	 * @date
	 * @author
	 */
	public static String getEndDayOfMonth(Date date) {

		if (date == null) {
			// return null;
			// 当前时间
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		String day_first = df.format(getEndDateTime(calendar.getTime()));
		StringBuffer str = new StringBuffer().append(day_first);
		return str.toString();
	}



	/**
	 * 当月第一天
	 * 
	 * @param date
	 * @return
	 * @date
	 * @author
	 */
	public static String getStartDayOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String dayFirst = df.format(getStartDateTime(gcLast.getTime()));
		StringBuffer str = new StringBuffer().append(dayFirst);
		return str.toString();
	}

	/**
	 * 根据年月日创建时间
	 * 
	 * @Description: 根据年月日创建时间
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 * @return Date
	 * @throws
	 * @author 
	 * @date
	 */
	public static Date getDate(int year, int month, int day) {
		return stringToDate(year + "-" + month + "-" + day, DATE_PATTERN_DAY);
	}



	/**
	 * 日期计算
	 * @param srcDate
	 * @param duration
	 * @return
	 */
	public static Date datePlus(Date srcDate, int duration) {
		Calendar instance = Calendar.getInstance();
		if (srcDate == null) {
			return null;
		}
		instance.setTime(srcDate);
		instance.add(Calendar.DATE, duration);
		return instance.getTime();
	}


	/**
	 * 日期计算
	 * @param srcDate
	 * @param duration
	 * @return
	 */
	public static Date datePlusDay(Date srcDate, int duration) {
		Calendar instance = Calendar.getInstance();
		if (srcDate == null) {
			return null;
		}
		instance.setTime(getStartDateTime(srcDate));
		instance.add(Calendar.DATE, duration);
		return instance.getTime();
	}


	/**
	 *  这个方法会减去一天
	 * 取得一个date对象对应的日期的23点59分59秒时刻的Date对象。
	 * @param srcDate
	 * @param duration
	 * @return
	 */
	public static Date dateSubtractDay(Date srcDate, int duration) {
		Calendar instance = Calendar.getInstance();
		if (srcDate == null) {
			return null;
		}
		int subtractOneDay = duration -1;
		instance.setTime(srcDate);
		instance.add(Calendar.DATE, subtractOneDay);
		instanceDate(instance,
				Calendar.HOUR_OF_DAY, instance.getActualMaximum(Calendar.HOUR_OF_DAY),
				Calendar.MINUTE, instance.getActualMaximum(Calendar.MINUTE),
				Calendar.SECOND, instance.getActualMaximum(Calendar.SECOND),
				Calendar.MILLISECOND, instance.getActualMaximum(Calendar.MILLISECOND));
		return instance.getTime();
	}



	private static void instanceDate(Calendar instance, int hourOfDay, int actualMaximum, int minute,
									 int actualMaximum2, int second, int actualMaximum3,
									 int millisecond, int actualMaximum4) {
		instance.set(hourOfDay, actualMaximum);
		instance.set(minute, actualMaximum2);
		instance.set(second, actualMaximum3);
		instance.set(millisecond, actualMaximum4);
	}


	/**
	 * 返回日期格式：yyyy/MM/dd
	 * @param planFinishTime
	 * @return
	 */
	public static String getFinishString(Date planFinishTime) {
		return dateToString(planFinishTime, DATE_PATTERN_FINISH_STRING);
	}


	/**
	 * 根据 yyyy/MM/dd格式 转换成Date类型
	 * @param strTime
	 * @return
	 */
	public static Date getStrToDate(String strTime) {
		return stringToDate(strTime, DateTool.DATE_PATTERN_DEFAULT);
	}




	public static void main(String[] args)  {
//
		Date d = stringToDate("2019-12-31 12:00:11", DATE_PATTERN_DAY);



		System.out.println("===============d "+d );

		Date c = stringToDate("2020-07-31 23:59:59", DATE_PATTERN_DEFAULT);

		int betweenWeek = getBetweenWeek(d, c, 7);
		System.out.println("两个日期之间有多少周=======" + betweenWeek);

		Date datePlus = datePlus(d, 270);

		Date nextDay = dateSubtractDay(datePlus, -1);
		System.out.println("相加====datePlus==========="+dateToString(datePlus, DATE_PATTERN_DEFAULT));
		System.out.println("nextDay===================" + dateToString(nextDay, DATE_PATTERN_DEFAULT));
		Date maxDateOfDay = getMaxDateOfDay(nextDay);
		System.out.println("maxDateOfDay===================" + dateToString(maxDateOfDay, DATE_PATTERN_DEFAULT));

		Date ff = DateTool.getCurrentDate();
		String finishString = getFinishString(ff);
		System.out.println("finishString===" + finishString);
		System.out.println(getEndDayOfMonth(new Date()));

		String s = StringUtil.storeFileName("场线信息-20200702141.xlsx");
		System.out.println("s=================="+"/sanb/noneffective/uploadFile/"+s);



		String tes = "2020-07-01 12:00:11";
		System.out.println("--------tes"+tes.length());
	}
}
