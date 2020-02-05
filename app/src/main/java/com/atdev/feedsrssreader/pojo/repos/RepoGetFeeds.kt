package com.atdev.feedsrssreader.pojo.repos

import androidx.lifecycle.LiveData
import com.atdev.feedsrssreader.pojo.models.RootObject
import com.atdev.feedsrssreader.pojo.network.RetrofitBuilder
import kotlinx.coroutines.*

object RepoGetFeeds {

    var job: CompletableJob? = null
    //val rss_Url = "https://rss.nytimes.com/services/xml/rss/nyt/Science.xml"

    fun getFeeds(rss_Url: String): LiveData<RootObject> {

        job = Job()

        return object : LiveData<RootObject>() {

            override fun onActive() {
                super.onActive()

                job?.let { thejob ->

                    CoroutineScope(Dispatchers.IO + thejob).launch {

                        val rssObject = RetrofitBuilder.apiService.getItems(rss_Url)
                        withContext(Dispatchers.Main) {

                            value = rssObject
                            thejob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        job!!.cancel()
    }
}