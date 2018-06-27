package sfedu.physics.dmitriy.githubapiresttestproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import sfedu.physics.dmitriy.githubapiresttestproject.R;

public class DetailActivity extends AppCompatActivity {

    TextView detail_link;
    TextView detail_user_nameTV;
    ImageView detail_userIconHeaderIV;
    Button show_repositoriesBT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        configureViews();
        configureActionBar();

    }

    private void initView() {
        detail_link = (TextView) findViewById(R.id.detail_link);
        detail_user_nameTV = (TextView) findViewById(R.id.detail_user_nameTV);
        detail_userIconHeaderIV = (ImageView) findViewById(R.id.detail_userIconHeaderIV);
        show_repositoriesBT = (Button) findViewById(R.id.detail_show_repositoriesBT);
    }

    private void configureViews() {

        if (getIntent() == null)
            finish();

        Bundle extras = getIntent().getExtras();

        String userName = extras.getString("login");
        String avatarURL = extras.getString("avatar_url");
        String linkURL = extras.getString("html_url");

        detail_link.setText(linkURL);
        Linkify.addLinks(detail_link, Linkify.WEB_URLS);

        detail_user_nameTV.setText(userName);

        Glide.with(this)
                .load(avatarURL)
                .placeholder(R.drawable.load)
                .into(detail_userIconHeaderIV);

        show_repositoriesBT.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, RepositoryActivity.class);
            intent.setAction(userName);
            startActivity(intent);
        });
    }

    private void configureActionBar() {
        getSupportActionBar().setTitle("Details Activity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_action_share, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForcastIntent());
        return true;
    }

    private Intent createShareForcastIntent(){
        String username = getIntent().getExtras().getString("login");
        String link = getIntent().getExtras().getString("html_url");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer @" + username + ", " + link)
                .getIntent();
        return shareIntent;
    }
}
