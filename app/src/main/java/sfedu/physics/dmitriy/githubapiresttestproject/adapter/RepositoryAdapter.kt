package sfedu.physics.dmitriy.githubapiresttestproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import sfedu.physics.dmitriy.githubapiresttestproject.R
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository

class RepositoryAdapter(private val context: Context, val repositories: List<Repository>) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repository_model, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryAdapter.ViewHolder, position: Int) {
        val dataRepository = repositories[position]

        val repositoryName = dataRepository.name
        val repositoryLanguage = dataRepository.language
        val repositoryPrivate = dataRepository.isPrivate
        val repositoryDescription = dataRepository.description
        val repositoryClone_url = dataRepository.clone_url
        val repositoryHtml_url = dataRepository.html_url


        holder.repo_model_nameTV.text = "RepositoryName: $repositoryName"
        holder.repo_model_languageTV.text = "RepositoryLanguage: $repositoryLanguage"
        holder.repo_model_isPrivateTV.text = "IsPrivate: $repositoryPrivate"
        holder.repo_model_descritionTV.text = "RepositoryDescription: $repositoryDescription"
        holder.repo_model_cloneURLTV.text = "RepositoryCloneURL: $repositoryClone_url"
        holder.repo_model_htmlURLTV.text = "RepositoryHtmlURL: $repositoryHtml_url"


    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val repo_model_nameTV: TextView
        val repo_model_isPrivateTV: TextView
        val repo_model_descritionTV: TextView
        val repo_model_languageTV: TextView
        val repo_model_cloneURLTV: TextView
        val repo_model_htmlURLTV: TextView


        init {

            repo_model_nameTV = view.findViewById<View>(R.id.repo_model_nameTV) as TextView
            repo_model_isPrivateTV = view.findViewById<View>(R.id.repo_model_isPrivateTV) as TextView
            repo_model_descritionTV = view.findViewById<View>(R.id.repo_model_descritionTV) as TextView
            repo_model_languageTV = view.findViewById<View>(R.id.repo_model_languageTV) as TextView
            repo_model_cloneURLTV = view.findViewById<View>(R.id.repo_model_cloneURLTV) as TextView
            repo_model_htmlURLTV = view.findViewById<View>(R.id.repo_model_htmlURLTV) as TextView
        }
    }
}
