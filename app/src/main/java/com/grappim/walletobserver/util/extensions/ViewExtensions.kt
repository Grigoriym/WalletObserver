package com.grappim.walletobserver.util.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar

fun View.showKeyboard() {
  val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  this.requestFocus()
  imm.showSoftInput(this, 0)
}

fun View.hideKeyboard(): Boolean {
  return try {
    val inputMethodManager =
      context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
  } catch (ignored: RuntimeException) {
    false
  }
}

fun View.gone(): View {
  if (visibility != View.GONE) {
    visibility = View.GONE
  }
  return this
}

fun View.hide(): View {
  if (visibility != View.INVISIBLE) {
    visibility = View.INVISIBLE
  }
  return this
}

fun View.show(): View {
  if (visibility != View.VISIBLE) {
    visibility = View.VISIBLE
  }
  return this
}

inline fun View.showIf(condition: () -> Boolean): View {
  visibility = if (visibility != View.VISIBLE && condition()) {
    View.VISIBLE
  } else {
    View.GONE
  }
  return this
}

fun View.showSnackbar(text: String, timeLength: Int = Snackbar.LENGTH_LONG) {
  Snackbar.make(this, text, timeLength).show()
}