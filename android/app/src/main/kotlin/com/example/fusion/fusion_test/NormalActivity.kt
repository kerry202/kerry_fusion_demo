package com.example.fusion.fusion_test

import android.os.Bundle
import android.widget.TextView
import com.gtbluesky.fusion.container.FusionActivity
import com.gtbluesky.fusion.navigator.FusionNavigator

class NormalActivity : FusionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_layout)

        val title = intent.getStringExtra("title")

        val tvA = findViewById<TextView>(R.id.tv_a)
        tvA.text = title

        val tvB = findViewById<TextView>(R.id.tv_b)
        tvB.setOnClickListener {
            FusionNavigator.sendMessage("我是消息")
            finish()
        }

        val tvC = findViewById<TextView>(R.id.tv_c)
        tvC.setOnClickListener {
            FusionNavigator.open("/lifecycle", mapOf("title" to "lifecycle Flutter Page"))
        }

        val tvD = findViewById<TextView>(R.id.tv_d)
        tvD.setOnClickListener {
            FusionNavigator.open("/navigator", mapOf("title" to "navigator Flutter Page", "transparent" to true))
        }
    }
}