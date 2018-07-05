package sfedu.physics.dmitriy.githubapiresttestproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.activity.DetailActivity;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User;
import sfedu.physics.dmitriy.githubapiresttestproject.utils.BitmapUtils;

import static sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.*;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading, noMore;

    private List<User> users;
    private Context context;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.context = context;
    }

    public List<User> getUsers() {
        return users;
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

        /*Glide.with(context)
                .load(userAvatarURL)
                .placeholder(R.drawable.load)
                .into(holder.avatarIV);*/

        boolean networkConnected = userAvatarURL != null;

        if (networkConnected) {
            Glide.with(context)
                    .load(userAvatarURL)
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            holder.avatarIV.setImageBitmap(resource);
                            dataUser.setBitmapData(BitmapUtils.bitmapToByte(resource));
                        }
                    });
        } else {
            Bitmap bitmap = BitmapUtils.byteArrayToBitmap(dataUser.getBitmapData());
            if (bitmap != null)
                holder.avatarIV.setImageBitmap(bitmap);
        }


        if (onLoadMoreListener != null && !isLoading && !noMore && holder.getAdapterPosition() == getItemCount() - 1 && networkConnected) {
            isLoading = true;
            onLoadMoreListener.onLoadMore();
        }

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
                    byte[] userbitmapData = dataUser.getBitmapData();

                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(USER_LOGIN, userLogin);
                    intent.putExtra(USER_HTML_URL, userHtmlURL);
                    intent.putExtra(USER_AVATAR_URL, userAvatarURL);
                    intent.putExtra(USER_BITMAP_DATA, userbitmapData);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(context, "You Clicked " + userLogin, Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void endLoading() {
        this.isLoading = false;
    }

    public void setNoMore() {
        this.noMore = false;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }
}
