package com.oldfredddy.kotlinfishermanbook

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_2_layout.*
import kotlinx.android.synthetic.main.item_layout.*

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_2_layout)

//        tvTitle.text = intent.getStringExtra("title")
//        tvContent.text = intent.getStringExtra("content")
//        im.setImageResource(intent.getIntExtra("image", R.drawable.som))
        var index: Int = 1
        webView.loadUrl("file:///android_asset/item$index.html")


    }
}