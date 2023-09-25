package com.example.fusion.fusion_test

import android.app.Application
import android.content.Intent
import android.graphics.Color
import android.util.Log
import com.gtbluesky.fusion.Fusion
import com.gtbluesky.fusion.FusionRouteDelegate
import com.gtbluesky.fusion.container.buildFusionIntent

class MyApp : Application(), FusionRouteDelegate {
    companion object {
        private const val TAG = "MyApp"
    }

    override fun onCreate() {
        super.onCreate()
        Fusion.install(this, this)
    }

    override fun pushNativeRoute(name: String, arguments: Map<String, Any>?) {

        Log.d(TAG, "pushNativeRoute: name=${name}, arguments=${arguments}")

        when (name) {
            "/normal" -> {
                val intent = Intent(applicationContext, NormalActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                (arguments?.get("title") as? String).let {
                    intent.putExtra("title", it)
                }
                startActivity(intent)
            }
            "/testActivity" ->{
                val intent = Intent(applicationContext, TestActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            else -> {
                Log.e(TAG, "pushNativeRoute error, name=$name")
            }
        }
    }

    override fun pushFlutterRoute(name: String, arguments: Map<String, Any>?) {
        Log.d(TAG, "pushFlutterRoute: name=${name}, arguments=${arguments}")
        val transparent = (arguments?.get("transparent") as? Boolean) ?: false
        val backgroundColor = (arguments?.get("backgroundColor") as? Long) ?: Color.WHITE
        val clazz = if (transparent) {
            TransparentFusionActivity::class.java
        } else {
            CustomActivity::class.java
        }
        startActivity(
            buildFusionIntent(
                applicationContext,
                clazz,
                name,
                arguments,
                transparent,
                backgroundColor.toInt()
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
        Log.d("  MyApp ", " pushFlutterRoute ")
    }

}