package sfedu.physics.dmitriy.githubapiresttestproject.activity

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.support.v7.app.AppCompatActivity
import android.text.util.Linkify
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

import sfedu.physics.dmitriy.githubapiresttestproject.R
import sfedu.physics.dmitriy.githubapiresttestproject.utils.BitmapUtils
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_AVATAR_URL
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_BITMAP_DATA
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_HTML_URL
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_LOGIN

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        if (intent == null)
            finish()

        val extras = intent.extras

        val userName = extras!!.getString(USER_LOGIN)
        val avatarURL = extras.getString(USER_AVATAR_URL)
        val linkURL = extras.getString(USER_HTML_URL)
        val bitmapData = extras.getByteArray(USER_BITMAP_DATA)

        detail_link.text = linkURL
        Linkify.addLinks(detail_link, Linkify.WEB_URLS)

        detail_user_nameTV.text = userName

        val networkConnected = avatarURL != null && !avatarURL.isEmpty()


        if (networkConnected) {
            Glide.with(this)
                    .load(avatarURL)
                    .placeholder(R.drawable.load)
                    .into(detail_userIconHeaderIV)
        } else {
            val bitmap = BitmapUtils.byteArrayToBitmap(bitmapData)
            if (bitmap != null) {
                detail_userIconHeaderIV.setImageBitmap(bitmap)
            }
        }
        detail_show_repositoriesBT.setOnClickListener { v ->
            val intent = Intent(this@DetailActivity, MvpRepositoryActivity::class.java)
            intent.action = userName
            startActivity(intent)
        }

        configureActionBar()

    }


    private fun configureActionBar() {
        supportActionBar!!.title = "Details Activity"
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.detail_action_share, menu)
        val menuItem = menu.findItem(R.id.action_share)
        menuItem.intent = createShareForcastIntent()
        return true
    }

    private fun createShareForcastIntent(): Intent {
        val username = intent.extras!!.getString("login")
        val link = intent.extras!!.getString("html_url")
        return ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer @$username, $link")
                .intent
    }
}
