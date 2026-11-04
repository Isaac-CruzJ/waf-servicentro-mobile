package com.waf.servicentromobile.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object AppUtils {
    fun getCurrentDateFormatted(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Date())
    }
}