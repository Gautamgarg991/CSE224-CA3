package com.example.stay

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
import android.widget.ProgressBar
import com.example.stay.MyAdapter
import kotlin.Throws
import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import org.junit.runner.RunWith

class NewsItem(var imageUrl: String?, var heading: String?, var description: String?) {
    fun getImageUrl(): String? {
        return imageUrl
    }

    fun getHeading(): String? {
        return heading
    }

    fun getDescription(): String? {
        return description
    }
}