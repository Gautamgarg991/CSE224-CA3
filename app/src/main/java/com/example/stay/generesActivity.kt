package com.example.stay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stay.R
import android.widget.TextView
import android.content.Intent
import android.view.View
import com.example.stay.NewsShowingActivity

class generesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generes)
        val sports = findViewById<View>(R.id.textView5) as TextView
        val business = findViewById<View>(R.id.textView7) as TextView
        val classifieds = findViewById<View>(R.id.textView8) as TextView
        val culture = findViewById<View>(R.id.textView9) as TextView
        val edu = findViewById<View>(R.id.textView10) as TextView
        val enterpreneur = findViewById<View>(R.id.textView11) as TextView
        val health = findViewById<View>(R.id.textView12) as TextView
        val movies = findViewById<View>(R.id.textView13) as TextView
        sports.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=sports+india"
            )
            intent.putExtra("header", sports.text.toString())
            startActivity(intent)
        }
        classifieds.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&fq=news_desk(\"Classifieds\") AND glocations:(\"INDIA\")"
            )
            intent.putExtra("header", classifieds.text.toString())
            startActivity(intent)
        }
        business.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=business"
            )
            intent.putExtra("header", business.text.toString())
            startActivity(intent)
        }
        culture.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=indian+culture"
            )
            intent.putExtra("header", culture.text.toString())
            startActivity(intent)
        }
        edu.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=education+india"
            )
            intent.putExtra("header", edu.text.toString())
            startActivity(intent)
        }
        enterpreneur.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=entrepreneurs"
            )
            intent.putExtra("header", enterpreneur.text.toString())
            startActivity(intent)
        }
        health.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=health+fitness"
            )
            intent.putExtra("header", health.text.toString())
            startActivity(intent)
        }
        movies.setOnClickListener {
            val intent = Intent(this@generesActivity, NewsShowingActivity::class.java)
            intent.putExtra(
                "url",
                "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=Bollywood+india+movies"
            )
            intent.putExtra("header", movies.text.toString())
            startActivity(intent)
        }
    }
}