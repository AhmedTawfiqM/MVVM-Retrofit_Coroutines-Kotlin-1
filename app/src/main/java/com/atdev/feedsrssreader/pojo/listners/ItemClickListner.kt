package com.atdev.feedsrssreader.pojo.listners

import android.view.View
import android.widget.TextView
import java.text.FieldPosition

interface ItemClickListner {
    fun onClick(view: View, position: Int, isLongClick: Boolean)
}