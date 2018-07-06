package sfedu.physics.dmitriy.githubapiresttestproject.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sfedu.physics.dmitriy.githubapiresttestproject.R
import sfedu.physics.dmitriy.githubapiresttestproject.api.AccessToken
import sfedu.physics.dmitriy.githubapiresttestproject.api.AuthorizationService
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application

/**
 * A login screen that offers login via email/password.
 */
class AuthorizationActivity : AppCompatActivity() {

    private val CLIENT_ID: String
        get() = getString(R.string.github_id)
    private val CLIENT_SECRET: String
        get() = getString(R.string.github_secret)
    private val CLIENT_CALLBACK_URL: String
        get() = getString(R.string.github_callback_url)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)


    }

    fun attemptLogin(v: View) {

        val github_auth_url = String.format("https://github.com/login/oauth/authorize?client_id=%s&scope=repo&redirect_uri=%s",
                CLIENT_ID, CLIENT_CALLBACK_URL)

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(github_auth_url))

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else
            Toast.makeText(this, "Can't open Browser!", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()

        val uri = intent.data

        if (uri != null && uri.toString().startsWith(CLIENT_CALLBACK_URL!!)) {
            val code = uri.getQueryParameter("code")
            val authorizationService = Application.rxJavaRetrofit.create(AuthorizationService::class.java)
            authorizationService.getAccessToken(CLIENT_ID!!, CLIENT_SECRET!!, code).enqueue(object : Callback<AccessToken> {
                override fun onResponse(call: Call<AccessToken>, response: Response<AccessToken>) {
                    startActivity(Intent(this@AuthorizationActivity, MvpUsersActivity::class.java))
                }

                override fun onFailure(call: Call<AccessToken>, t: Throwable) {
                    Toast.makeText(this@AuthorizationActivity, "No", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    fun skipRegistration(v: View) {
        val intent = Intent(this, MvpUsersActivity::class.java)
        startActivity(intent)
    }
}
