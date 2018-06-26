package sfedu.physics.dmitriy.githubapiresttestproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.activity.DetailActivity;
import sfedu.physics.dmitriy.githubapiresttestproject.user_model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;
    private Context context;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_model, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User dataUser = users.get(position);

        String userLogin = dataUser.getLogin();
        String userHtmlURL = dataUser.getHtmlURL();
        String userAvatarURL = dataUser.getAvatarURL();


        holder.title.setText(userLogin);
        holder.githubLink.setText(userHtmlURL);

        Glide.with(context)
                .load(userAvatarURL)
                .placeholder(R.drawable.load)
                .into(holder.avatarIV);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, githubLink;
        private ImageView avatarIV;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.user_model_titleTV);
            githubLink = (TextView) view.findViewById(R.id.user_model_githubLinkTV);
            avatarIV = (ImageView) view.findViewById(R.id.user_model_iconIV);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    User dataUser = users.get(position);

                    String userLogin = dataUser.getLogin();
                    String userHtmlURL = dataUser.getHtmlURL();
                    String userAvatarURL = dataUser.getAvatarURL();

                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("login", userLogin);
                    intent.putExtra("html_url", userHtmlURL);
                    intent.putExtra("avatar_url", userAvatarURL);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(context, "You Clicked " + userLogin, Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
}
