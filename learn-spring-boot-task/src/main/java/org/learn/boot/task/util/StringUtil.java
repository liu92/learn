package org.learn.boot.task.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * 字符串工具类
 * 
 * @date
 * @author
 */
public final class StringUtil {

	private StringUtil() {
	}



	/**
	 * 中文字符校验
	 * <p>
	 * 使用GBK编码
	 * </p>
	 * 
	 * @param str
	 * @return
	 * @date
	 * @author
	 */
	public static boolean checkChinese(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		// 用GBK编码
		str = new String(str.getBytes());
		String regex = "^[\u4e00-\u9fa5]+$";
		return str.matches(regex);
	}

	/**
	 * 自定义正则校验字符串
	 * 
	 * @param str
	 *            待校验的字符串
	 * @param regex
	 *            正则表达式
	 * @return
	 * @date
	 * @author
	 */
	public static boolean checkByPattern(String str, String regex) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		return str.matches(regex);
	}

	/**
	 * UUID 生成
	 * 
	 * @return
	 * @date
	 * @author
	 */
	public static String UUIDGenerate() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * gzip 数据压缩
	 * 
	 * @param msg
	 * @return
	 * @throws IOException
	 * @date
	 * @author
	 */
	public static byte[] gzip(String msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				gzip.close();
			}
			IOUtils.closeQuietly(out);
		}
		return out.toByteArray();
	}

	/**
	 * gzip 数据压缩
	 * 
	 * @param msg
	 * @return
	 * @throws IOException
	 * @date
	 * @author
	 */
	public static byte[] gzip(byte[] msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				gzip.close();
			}
			IOUtils.closeQuietly(out);
		}
		return out.toByteArray();
	}

	/**
	 * gzip 数据解压缩
	 * 
	 * @param msg
	 * @return
	 * @throws IOException
	 * @date
	 * @author
	 */
	public static byte[] unZip(String msg) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(msg.getBytes());
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[4096];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		gunzip.close();

		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);

		return out.toByteArray();
	}

	/**
	 * gzip 解压
	 * 
	 * @param msg
	 *            数据
	 * @return
	 * @throws IOException
	 * @date
	 * @author
	 */
	public static String unZip(byte[] msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(msg);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[4096];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		gunzip.close();

		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);

		return new String(out.toByteArray(), "utf-8");
	}

	/**
	 * 解压数据，返回解压过后的字节数组
	 * 
	 * @param msg
	 * @return
	 * @throws IOException
	 * @date
	 * @author
	 */
	public static byte[] unZip2(byte[] msg) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(msg);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[4096];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		gunzip.close();
		IOUtils.closeQuietly(in);
		IOUtils.closeQuietly(out);
		return out.toByteArray();
	}

	/**
	 * 字符串是否为空
	 * <p>
	 * "" or null result true
	 * </p>
	 * 
	 * @param val
	 * @return boolean
	 * @date
	 * @author
	 */
	public static boolean isBlank(String val) {
		return StringUtils.isBlank(val);
	}

	/**
	 * 截取字符之后的字符串
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String substringAfterLast(String str, String separator) {
		return StringUtils.substringAfterLast(str, separator);
	}


	/**
	 * 重置保存文件避免文件冲突
	 *
	 * @param fileName
	 * @return
	 */
	public static String storeFileName(String fileName) {
		return StringUtil.UUIDGenerate() + "."
				+ StringUtil.substringAfterLast(fileName, ".");
	}


	/**
	 * 生成一个标识
	 * @param lendTime
	 * @param tierCode
	 * @param order
	 * @return
	 */
	public static String getLoanNumber(String prefix,Date lendTime, String tierCode, int order) {
		String str = String.format("%04d", order);
		String number = prefix+"_"+DateTool.dateToString(lendTime, DateTool.DATE_PATTERN_STRING) + tierCode + str;
		return number;
	}


	public static void main(String[] args) {
		String loanNumber = getLoanNumber("YZ", DateTool.getCurrentDate(), "01", 1);
		System.out.println("loanNumber=========="+UUIDGenerate()+loanNumber);
	}

}
