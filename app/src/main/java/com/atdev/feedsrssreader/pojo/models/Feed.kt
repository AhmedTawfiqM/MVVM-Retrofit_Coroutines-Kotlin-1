package com.atdev.feedsrssreader.pojo.models

data class Feed(
    val url: String,
    val title: String,
    val link: String,
    val author: String,
    val description: String,
    val image: String
)