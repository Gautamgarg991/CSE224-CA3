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
import android.os.Handler
import android.widget.ProgressBar
import com.example.stay.MyAdapter
import kotlin.Throws
import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import org.junit.runner.RunWith

class slpashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slpashscreen)
        Handler().postDelayed({
            val i = Intent(this@slpashscreen, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 5000)
    }
}