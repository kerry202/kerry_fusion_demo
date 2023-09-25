package com.example.fusion.fusion_test

import android.util.Log
import com.gtbluesky.fusion.container.FusionActivity
import com.gtbluesky.fusion.handler.FusionMessengerHandler
import com.gtbluesky.fusion.notification.FusionNotificationListener
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

class CustomActivity : FusionActivity(), FusionMessengerHandler, FusionNotificationListener {

    private var channel: MethodChannel? = null
    override fun configureFlutterChannel(binaryMessenger: BinaryMessenger) {
        Log.d(this.toString(), "configureFlutterChannel")
        channel = MethodChannel(binaryMessenger, "custom_channel")
        channel?.setMethodCallHandler { call, result ->

        }
    }

    override fun releaseFlutterChannel() {
        Log.d(this.toString(), "configureFlutterChannel")
        channel?.setMethodCallHandler(null)
        channel = null
    }

    override fun onReceive(name: String, body: Map<String, Any>?) {

        Log.d("  CustomActivity  ", " onReceive ")
    }


}