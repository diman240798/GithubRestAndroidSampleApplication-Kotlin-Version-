package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.api.AccessToken;
import sfedu.physics.dmitriy.githubapiresttestproject.api.AuthorizationServiceRxJava;
import sfedu.physics.dmitriy.githubapiresttestproject.application.Application;

/**
 * A login screen that offers login via email/password.
 */
public class AuthorizationActivity extends AppCompatActivity {

    private String CLIENT_ID;
    private String CLIENT_SECRET;
    private String CLIENT_CALLBACK_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        CLIENT_ID = getString(R.string.github_id);
        CLIENT_SECRET = getString(R.string.github_secret);
        CLIENT_CALLBACK_URL = getString(R.string.github_callback_url);

    }

    public void attemptLogin(View v) {

        String github_auth_url = String.format("https://github.com/login/oauth/authorize?client_id=%s&scope=repo&redirect_uri=%s",
                CLIENT_ID, CLIENT_CALLBACK_URL);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(github_auth_url));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else Toast.makeText(this, "Can't open Browser!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Uri uri = getIntent().getData();

        if (uri != null && uri.toString().startsWith(CLIENT_CALLBACK_URL)) {
            String code = uri.getQueryParameter("code");
            AuthorizationServiceRxJava authorizationServiceRxJava = Application.getRxJavaClient().create(AuthorizationServiceRxJava.class);
            authorizationServiceRxJava.getAccessToken(CLIENT_ID, CLIENT_SECRET, code).enqueue(new Callback<AccessToken>() {
                @Override
                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                    startActivity(new Intent(AuthorizationActivity.this, UsersActivity.class));
                }

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    Toast.makeText(AuthorizationActivity.this, "No", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void skipRegistration(View v) {
        Intent intent = new Intent(this, UsersActivity.class);
        startActivity(intent);
    }
}
