package com.samsudar.momentary;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.samsudar.momentary.logic.DateFormatter;

public class TodayKeyInputService extends InputMethodService {
  private DateFormatter formatter;
  private String delimiterKey;
  private String defaultDelimiter;

  @Override
  public void onCreate() {
    super.onCreate();
    formatter = new DateFormatter();
    delimiterKey = this.getString(com.samsudar.momentary.R.string.pref_key_delimiter);
    defaultDelimiter = this.getString(com.samsudar.momentary.R.string.pref_default_delimiter);
  }

  @Override
  public void onStartInput(EditorInfo info, boolean restarting) {
    // 1 to position at the end of the entered text
    String delimiter = PreferenceManager.getDefaultSharedPreferences(this)
        .getString(delimiterKey, defaultDelimiter);

    getCurrentInputConnection().commitText(
        formatter.getFriendlyDate(delimiter), 1);
    returnToLastInputMethod();
  }

  protected void returnToLastInputMethod() {
    InputMethodManager imm = (InputMethodManager)
        this.getSystemService(Context.INPUT_METHOD_SERVICE);
    final IBinder token = this.getWindow().getWindow().getAttributes().token;
    imm.switchToLastInputMethod(token);
  }

  @Override
  public View onCreateInputView() {
    // We don't have a view.
    return null;
  }
}
