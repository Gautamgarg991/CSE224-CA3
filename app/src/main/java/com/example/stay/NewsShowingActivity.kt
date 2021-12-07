package com.example.stay

import com.example.stay.NewsItem
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.stay.R
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import com.squareup.picasso.Picasso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.stay.MainActivity
import com.example.stay.NewsShowingActivity.Backgroundtasks
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.*
import com.example.stay.MyAdapter
import kotlin.Throws
import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import org.junit.runner.RunWith
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.nio.charset.Charset
import java.util.ArrayList

class NewsShowingActivity : AppCompatActivity() {
    private var listView: ListView? = null
    private var stringurl: String? = ""
    private var newsArray: ArrayList<NewsItem?>? = null
    private val nextbtn: Button? = null
    private val prevbtn: Button? = null
    private val currentpos = 0
    private val dotsViews: Array<TextView?>?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_showing)
        val intent = intent
        stringurl = intent.getStringExtra("url")
        listView = findViewById<View?>(R.id.listView) as ListView
        val bb = Backgroundtasks()
        bb.execute()
        val heading = intent.getStringExtra("header")
        supportActionBar.setTitle("STAY-" + heading.toUpperCase())
    }

    private inner class Backgroundtasks : AsyncTask<Void?, Void?, ArrayList<NewsItem?>?>() {
        override fun doInBackground(vararg urls: Void?): ArrayList<NewsItem?>? {
            var jsonResponse: String? = ""
            val url = makeUrl()
            try {
                jsonResponse = makeHttpRequest(url)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            newsArray = extractFeatures(jsonResponse)
            return newsArray
        }

        override fun onPostExecute(newsItems: ArrayList<NewsItem?>?) {
            updateUi()
        }
    }

    private fun makeUrl(): URL? {
        var url: URL? = null
        url = try {
            URL(stringurl)
        } catch (e: MalformedURLException) {
            Log.e("SliderAdapter", "Error in makeurl function", e)
            return null
        }
        return url
    }

    private fun updateUi() {
        val progressBar = findViewById<View?>(R.id.progressBar) as ProgressBar
        progressBar.visibility = View.GONE
        val adapter = MyAdapter(this, R.layout.news_layout, newsArray)
        listView.setAdapter(adapter)
    }

    @Throws(IOException::class)
    private fun makeHttpRequest(url: URL?): String? {
        var jsonResponse: String? = ""
        var urlConnection: HttpURLConnection? = null
        var inputStream: InputStream? = null
        try {
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.readTimeout = 1000000000
            urlConnection.connectTimeout = 1500000000
            urlConnection.connect()
            inputStream = urlConnection.inputStream
            jsonResponse = readFromStream(inputStream)
        } catch (e: IOException) {
            // TODO: Handle the exception
        } finally {
            urlConnection?.disconnect()
            inputStream?.close()
        }
        return jsonResponse
    }

    @Throws(IOException::class)
    private fun readFromStream(inputStream: InputStream?): String? {
        val output = StringBuilder()
        if (inputStream != null) {
            val inputStreamReader = InputStreamReader(inputStream, Charset.forName("UTF-8"))
            val reader = BufferedReader(inputStreamReader)
            var line = reader.readLine()
            while (line != null) {
                output.append(line)
                line = reader.readLine()
            }
        }
        return output.toString()
    }

    private fun extractFeatures(earthquakeJSON: String?): ArrayList<NewsItem?>? {
        val list = ArrayList<NewsItem?>()
        try {
            val baseJsonResponse = JSONObject(earthquakeJSON)
            val status = baseJsonResponse.getString("status")
            if (status == "OK") {
                val response = baseJsonResponse.getJSONObject("response")
                val docs = response.getJSONArray("docs")
                if (docs.length() > 0 && docs != null) {
                    for (i in 0 until docs.length()) {
                        val newss = docs.getJSONObject(i)
                        val headline = newss.getJSONObject("headline")
                        val title = headline.getString("main")
                        val description = newss.getString("lead_paragraph")
                        val multimedia = newss.getJSONArray("multimedia")
                        var multimediaobject: JSONObject? = null
                        var imageurl = "https://i.postimg.cc/sgP1kSZk/noun-No-Image-340719.png"
                        if (!(multimedia == null || multimedia.length() <= 0)) {
                            multimediaobject = multimedia.getJSONObject(0)
                            imageurl =
                                "https://www.nytimes.com/" + multimediaobject.getString("url")
                        }
                        list.add(NewsItem(imageurl, title, description))
                    }
                    newsArray = list
                    return list
                }
            }
        } catch (e: JSONException) {
            Log.e("in news activity", "Problem parsing the earthquake JSON results", e)
        }
        return null
    }
}