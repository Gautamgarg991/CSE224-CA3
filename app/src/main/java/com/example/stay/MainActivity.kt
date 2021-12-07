package com.example.stay

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.example.stay.R
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.stay.NewsShowingActivity
import com.example.stay.generesActivity

class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    var keywords: Array<String>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchbtn = findViewById<View>(R.id.searchbtn) as ImageView
        searchbtn.setOnClickListener {
            editText = findViewById<View>(R.id.editText) as EditText
            keywords = editText!!.text.toString().trim { it <= ' ' }.split(" ").toTypedArray()
            if (editText!!.text.toString() != "") {
                var finalkey = ""
                for (i in keywords!!.indices) {
                    if (i == keywords!!.size - 1) {
                        finalkey += keywords!![i]
                        break
                    }
                    finalkey += keywords!![i] + "+"
                }
                val url =
                    "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=eOlhGDZ8cWenLXD5rUg6wtrHJIttrUDL&q=$finalkey"
                val intent = Intent(this@MainActivity, NewsShowingActivity::class.java)
                intent.putExtra("url", url)
                intent.putExtra("header", editText!!.text.toString().trim { it <= ' ' })
                startActivity(intent)
            }
        }
        val exploreButton = findViewById<View>(R.id.explorebtn) as Button
        exploreButton.setOnClickListener {
            val intentgeneres = Intent(this@MainActivity, generesActivity::class.java)
            startActivity(intentgeneres)
        }
    }
}