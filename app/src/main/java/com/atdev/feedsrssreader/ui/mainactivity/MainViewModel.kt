package com.atdev.feedsrssreader.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.atdev.feedsrssreader.pojo.models.RootObject
import com.atdev.feedsrssreader.pojo.repos.RepoGetFeeds

class MainViewModel : ViewModel() {

    private var _rssUrl: MutableLiveData<String> = MutableLiveData()

    val rootObject: LiveData<RootObject> = Transformations
        .switchMap(_rssUrl) {

                url ->
            RepoGetFeeds.getFeeds(url)
        }

    fun setRssUrl(rssUrl: String) {

        val update = rssUrl
        if (_rssUrl.value == update) {
            return
        }
        _rssUrl.value = update
    }

    fun cancelJob() {
        RepoGetFeeds.cancelJob()
    }
}