package com.milad.salimtogglebuttonexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.milad.salimtogglebuttonexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding.lifecycleOwner = this
        setContentView(activityMainBinding.root)
        initUiListener()
    }

    private fun initUiListener(){
        activityMainBinding.salimToggleButton.clickListener {
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
        }
    }
}