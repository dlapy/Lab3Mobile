package com.example.financialadvice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.financialadvice.data.TipDataSource

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val index = intent.getIntExtra("TIP_INDEX", 0)
        val tip = TipDataSource.getTips()[index]

        findViewById<TextView>(R.id.detailDay)
            .text = getString(R.string.day_format, tip.day)

        findViewById<TextView>(R.id.detailTitle)
            .setText(tip.titleResId)

        findViewById<TextView>(R.id.detailFullText)
            .setText(tip.fullDescResId)

        findViewById<ImageView>(R.id.detailImage)
            .setImageResource(tip.imageResId)
    }
}