package com.example.fusion.fusion_test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.gtbluesky.fusion.navigator.FusionNavigator
import io.flutter.embedding.android.FlutterActivity

class MainActivity : FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)

        val test_tv = findViewById<TextView>(R.id.test_tv)

        test_tv.setOnClickListener {
            FusionNavigator.open("/test", mapOf("title" to "Android Flutter Page"))
            Log.d(" setOnClickListener ", " test_tv ");
        }

    }
}
