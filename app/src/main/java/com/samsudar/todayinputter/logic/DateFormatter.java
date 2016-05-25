package com.samsudar.todayinputter.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Format dates as we see fit.
 */
public class DateFormatter {
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  public String getFriendlyDate() {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
    Calendar gregorianCalendar = GregorianCalendar.getInstance();
    String result = format.format(gregorianCalendar.getTime());
    return result;
  }
}
