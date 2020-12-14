package com.example.responsiveui

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", "onCreate: ${getScreenSizeHeight()}")
        Log.d("TAG", "onCreate: ${getScreenSizeWidth()}")
    }

    private fun getScreenSizeWidth(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }

    private fun getScreenSizeHeight(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    override fun onResume() {
        super.onResume()
        KeyboardEventListener(this) { isOpen ->
            if (isOpen)
                Log.d("TAG", "onResume: keyboard is opened")
            else
                Log.d("TAG", "onResume: keyboard is closed")
        }
    }
}