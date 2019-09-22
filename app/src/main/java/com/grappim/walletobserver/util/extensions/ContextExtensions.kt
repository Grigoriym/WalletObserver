package com.grappim.walletobserver.util.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

inline fun <reified T : Activity> Context?.startActivity() =
  this?.startActivity(Intent(this, T::class.java))

inline fun <reified T : Any> Context.launchActivity(
  options: Bundle? = null,
  noinline init: Intent.() -> Unit = {}
) {
  val intent = newIntent<T>(this)
  intent.init()
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
    startActivity(intent, options)
  } else {
    startActivity(intent)
  }
}

inline val Context.connectivityManager: ConnectivityManager?
  get() =
    getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

fun Context.inflateLayout(
  @LayoutRes layoutId: Int, parent: ViewGroup? = null,
  attachToRoot: Boolean = false
): View =
  LayoutInflater
    .from(this)
    .inflate(layoutId, parent, attachToRoot)

val Context.networkInfo: NetworkInfo?
  get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo