package com.samsudar.todayinputter;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.samsudar.todayinputter.logic.DateFormatter;

public class InputTodayIME extends InputMethodService {
  private DateFormatter formatter;

  @Override
  public void onCreate() {
    super.onCreate();
    formatter = new DateFormatter();
  }

  @Override
  public void onStartInput(EditorInfo info, boolean restarting) {
    // 1 to position at the end of the entered text
    getCurrentInputConnection().commitText(formatter.getFriendlyDate(), 1);
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
