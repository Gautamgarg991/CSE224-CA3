package com.example.stay

import android.content.Context
import com.example.stay.NewsItem
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.stay.R
import android.widget.TextView
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import com.squareup.picasso.Picasso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.stay.MainActivity
import com.example.stay.NewsShowingActivity.Backgroundtasks
import android.os.AsyncTask
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.stay.MyAdapter
import com.squareup.picasso.Transformation
import kotlin.Throws
import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import org.junit.runner.RunWith
import java.util.ArrayList

internal class MyAdapter(
    var mcontext: Context?,
    resource: Int,
    var newslist: ArrayList<NewsItem?>?
) : ArrayAdapter<NewsItem?>(
    mcontext, 0, newslist
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val current = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.news_layout, parent, false)
        }
        val heading = convertView.findViewById<View?>(R.id.headline) as TextView
        val description = convertView.findViewById<View?>(R.id.content) as TextView
        val imageView = convertView.findViewById<View?>(R.id.image) as ImageView
        heading.text = current.getHeading()
        description.text = current.getDescription()
        val transformation: Transformation = RoundedCornersTransformation(30, 0)
        Picasso.get().load(current.getImageUrl()).fit().transform(transformation)
            .error(R.drawable.img1).into(imageView)
        heading.setOnClickListener { description.visibility = View.VISIBLE }
        imageView.setOnClickListener { description.visibility = View.VISIBLE }
        return convertView
    }
}