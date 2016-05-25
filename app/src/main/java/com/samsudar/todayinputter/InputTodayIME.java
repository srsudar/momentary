package com.samsudar.todayinputter;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.EditorInfo;

public class InputTodayIME extends InputMethodService {
  public InputTodayIME() {
  }

  @Override
  public void onCreate() {
    super.onCreate();
    // 1 to position at the end of the entered text
//    getCurrentInputConnection().commitText("test!", 1);
  }

  @Override
  public void onStartInput(EditorInfo info, boolean restarting) {
    getCurrentInputConnection().commitText("test!", 1);
  }

  @Override
  public View onCreateInputView() {
    // We don't have a view.
    return null;
  }
}
