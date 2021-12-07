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
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.stay.MyAdapter
import kotlin.Throws
import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.stay", appContext.packageName)
    }
}