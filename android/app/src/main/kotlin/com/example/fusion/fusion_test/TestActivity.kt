package com.example.fusion.fusion_test

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gtbluesky.fusion.container.FusionActivity
import com.gtbluesky.fusion.handler.FusionMessengerHandler
import com.gtbluesky.fusion.navigator.FusionNavigator
import com.gtbluesky.fusion.notification.FusionNotificationListener
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_layout)

    }

}