package sfedu.physics.dmitriy.githubapiresttestproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetWorkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}