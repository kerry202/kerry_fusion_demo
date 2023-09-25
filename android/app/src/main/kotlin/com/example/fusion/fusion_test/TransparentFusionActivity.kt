package com.example.fusion.fusion_test

import com.gtbluesky.fusion.container.FusionActivity
import com.gtbluesky.fusion.handler.FusionMessengerHandler
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

class TransparentFusionActivity : FusionActivity(), FusionMessengerHandler {

    private var channel: MethodChannel? = null
    override fun configureFlutterChannel(binaryMessenger: BinaryMessenger) {
        channel = MethodChannel(binaryMessenger, "custom_channel")
        channel?.setMethodCallHandler { call, result ->
        }
    }

    override fun releaseFlutterChannel() {
        channel?.setMethodCallHandler(null)
        channel = null
    }
}