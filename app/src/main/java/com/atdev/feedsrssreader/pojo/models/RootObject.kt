package com.atdev.feedsrssreader.pojo.models

data class RootObject(
    val status: String,
    val feed: Feed,
    val items: List<Item>
)