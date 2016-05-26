package com.samsudar.momentary.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Format dates as we see fit.
 */
public class DateFormatter {
  private static final String DELIM_HOLDER = "-";
  private static final String DATE_FORMAT = "yyyy" +
      DELIM_HOLDER +
      "MM" +
      DELIM_HOLDER +
      "dd";

  public String getFriendlyDate(String delimiter) {
    String replacedFormat = DATE_FORMAT.replace(DELIM_HOLDER, delimiter);
    SimpleDateFormat format = new SimpleDateFormat(replacedFormat);
    Calendar gregorianCalendar = GregorianCalendar.getInstance();
    String result = format.format(gregorianCalendar.getTime());
    return result;
  }
}
