package com.atdev.feedsrssreader.pojo.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.atdev.feedsrssreader.R
import com.atdev.feedsrssreader.pojo.listners.ItemClickListner
import com.atdev.feedsrssreader.pojo.models.RootObject
import java.math.MathContext

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener,
    View.OnLongClickListener {
    //
    var tvTitle: TextView
    var tvUpdates: TextView
    var tvContent: TextView
    var clickListner: ItemClickListner? = null

    init {

        tvTitle = itemView.findViewById(R.id.tvTitle)
        tvUpdates = itemView.findViewById(R.id.tvTitle)
        tvContent = itemView.findViewById(R.id.tvTitle)

        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    fun setOnItemCLickListner(itemClickListner: ItemClickListner) {

        this.clickListner = itemClickListner
    }

    override fun onClick(view: View?) {
        view?.let {
            clickListner!!.onClick(it, adapterPosition, false)
        }
    }

    override fun onLongClick(view: View?): Boolean {

        view?.let {
            clickListner!!.onClick(it, adapterPosition, true)
        }
        return true
    }

}


class FeedsAdapter(private val rssObject: RootObject, private val mContext: Context) :
    RecyclerView.Adapter<FeedViewHolder>() {

    val infalter: LayoutInflater

    init {
        infalter = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        val view = infalter.inflate(R.layout.row, parent, false)
        return FeedViewHolder(view)

    }

    override fun getItemCount(): Int {

        return rssObject.items.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        holder.tvTitle.setText(rssObject.items[position].title)
        holder.tvContent.setText(rssObject.items[position].content)
        holder.tvUpdates.setText(rssObject.items[position].pubDate)

        holder.setOnItemCLickListner(object : ItemClickListner {

            override fun onClick(view: View, position: Int, isLongClick: Boolean) {

                if (!isLongClick) {

                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.items[position].link))
                    mContext.startActivity(browserIntent)
                }

            }
        })
        //....
    }

}