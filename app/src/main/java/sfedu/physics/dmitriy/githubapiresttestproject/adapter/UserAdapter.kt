package sfedu.physics.dmitriy.githubapiresttestproject.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import sfedu.physics.dmitriy.githubapiresttestproject.R
import sfedu.physics.dmitriy.githubapiresttestproject.activity.DetailActivity
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User
import sfedu.physics.dmitriy.githubapiresttestproject.utils.BitmapUtils
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_AVATAR_URL
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_BITMAP_DATA
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_HTML_URL
import sfedu.physics.dmitriy.githubapiresttestproject.utils.IntentConstantsUtils.Companion.USER_LOGIN

class UserAdapter(private val context: Context, val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    private var onLoadMoreListener: OnLoadMoreListener? = null
    private var isLoading: Boolean = false
    private var noMore: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_model, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataUser = users[position]

        val userLogin = dataUser.login
        val userHtmlURL = dataUser.htmlURL
        val userAvatarURL = dataUser.avatarURL




        holder.title.text = userLogin
        holder.githubLink.text = userHtmlURL

        /*Glide.with(context)
                .load(userAvatarURL)
                .placeholder(R.drawable.load)
                .into(holder.avatarIV);*/

        val networkConnected = userAvatarURL != null

        if (networkConnected) {
            Glide.with(context)
                    .load(userAvatarURL)
                    .asBitmap()
                    .into(object : SimpleTarget<Bitmap>() {
                        override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                            holder.avatarIV.setImageBitmap(resource)
                            dataUser.bitmapData = BitmapUtils.bitmapToByte(resource)
                        }
                    })
        } else {
            val bitmap = BitmapUtils.byteArrayToBitmap(dataUser.bitmapData)
            if (bitmap != null)
                holder.avatarIV.setImageBitmap(bitmap)
        }


        if (onLoadMoreListener != null && !isLoading && !noMore && holder.adapterPosition == itemCount - 1 && networkConnected) {
            isLoading = true
            onLoadMoreListener!!.onLoadMore()
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val githubLink: TextView
        val avatarIV: ImageView

        init {
            title = view.findViewById<View>(R.id.user_model_titleTV) as TextView
            githubLink = view.findViewById<View>(R.id.user_model_githubLinkTV) as TextView
            avatarIV = view.findViewById<View>(R.id.user_model_iconIV) as ImageView

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val dataUser = users[position]

                    val userLogin = dataUser.login
                    val userHtmlURL = dataUser.htmlURL
                    val userAvatarURL = dataUser.avatarURL
                    val userbitmapData = dataUser.bitmapData

                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(USER_LOGIN, userLogin)
                    intent.putExtra(USER_HTML_URL, userHtmlURL)
                    intent.putExtra(USER_AVATAR_URL, userAvatarURL)
                    intent.putExtra(USER_BITMAP_DATA, userbitmapData)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                    Toast.makeText(context, "You Clicked " + userLogin!!, Toast.LENGTH_SHORT).show()
                }
            }


        }

    }

    fun setOnLoadMoreListener(onLoadMoreListener: OnLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener
    }

    fun endLoading() {
        this.isLoading = false
    }

    fun setNoMore() {
        this.noMore = false
    }

    interface OnLoadMoreListener {
        fun onLoadMore()
    }
}
