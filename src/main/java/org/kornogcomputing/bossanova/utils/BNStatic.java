package org.kornogcomputing.bossanova.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Locale;


/**
 * some static for application
 * 
 * @author herve
 * 
 */
public final class BNStatic {

	/**
	 * localDateFormat
	 */
	public static final DateFormat LOCALDATEFORMAT = DateFormat
			.getDateInstance(DateFormat.LONG, Locale.getDefault());
	/**
	 * localDateFormatCourt
	 */
	public static final DateFormat LOCALDATEFORMATCOURT = DateFormat
			.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT,
					Locale.getDefault());
	/**
	 * localDateFormat
	 */
	public static DateFormat localDateFormatDateTime = DateFormat
			.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT,
					Locale.getDefault());
	/**
	 * local Date Formats
	 */
	public static final DateFormat[] LOCALDATEFORMATS = {LOCALDATEFORMAT };
	/**
	 * local date time format
	 */
	public static final DateFormat[] LOCALDATETIMEFORMAT = {localDateFormatDateTime };
	/**
	 * static for table dimension values get changed by IktusManagerFrame
	 */
	public static int fullTabWidth = 880;
	/** */
	public static int longTabWidth = 780;
	/** */
	public static int longTabHeigth = 300;
	/** */
	public static int fullTabHeight = 350;
	/** */
	public static int smallTabWidth = 600;
	/** */
	public static int smallTabHeight = 160;
	/** */
	public static int tinyTabHeight = 100;
	/** */
	public static int tinyTabWidth = 300;
	/** */
	public static int maxTabHeight = 280;
	/**
	 * small component dimension
	 */
	public static Dimension smallCompDimension = new Dimension(40, 22);
	/**
	 * big component dimension
	 */
	public static Dimension bigCompDimension = new Dimension(310, 22);
	/**
	 * 
	 */
	public static final Color SPECIALBLUE = new Color(44, 73, 135);
	/**
	 * dimension for jcombobox
	 * 
	 */
	public static Dimension comboDimension = new Dimension(167, 22);
	/**
	 *  path for messages resource
	 */
	public static String resourcePath = "messages";

	
	
}
