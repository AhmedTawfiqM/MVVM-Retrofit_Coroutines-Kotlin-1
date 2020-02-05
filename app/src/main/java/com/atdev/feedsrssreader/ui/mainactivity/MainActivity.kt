package com.atdev.feedsrssreader.ui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atdev.feedsrssreader.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.rootObject.observe(this, Observer { rssObject ->

            Toast.makeText(this@MainActivity, rssObject.items[0].title, Toast.LENGTH_LONG).show()
            println("DEbug:: ${rssObject.items[0].title} ")
        })

        viewModel.setRssUrl("https://rss.nytimes.com/services/xml/rss/nyt/Science.xml")
    }
}
