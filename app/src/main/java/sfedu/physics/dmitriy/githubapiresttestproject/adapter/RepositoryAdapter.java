package sfedu.physics.dmitriy.githubapiresttestproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sfedu.physics.dmitriy.githubapiresttestproject.R;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private List<Repository> repositories;
    private Context context;

    public RepositoryAdapter(Context context, List<Repository> repositories) {
        this.context = context;
        this.repositories = repositories;
    }

    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.repository_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.ViewHolder holder, int position) {
        Repository dataRepository = repositories.get(position);

        String repositoryName = dataRepository.getName();
        String repositoryLanguage = dataRepository.getLanguage();
        boolean repositoryPrivate = dataRepository.isPrivate();
        String repositoryDescription = dataRepository.getDescription();
        String repositoryClone_url = dataRepository.getClone_url();
        String repositoryHtml_url = dataRepository.getHtml_url();


        holder.repo_model_nameTV.setText("RepositoryName: " + repositoryName);
        holder.repo_model_languageTV.setText("RepositoryLanguage: " + repositoryLanguage);
        holder.repo_model_isPrivateTV.setText("IsPrivate: " + String.valueOf(repositoryPrivate));
        holder.repo_model_descritionTV.setText("RepositoryDescription: " + repositoryDescription);
        holder.repo_model_cloneURLTV.setText("RepositoryCloneURL: " + repositoryClone_url);
        holder.repo_model_htmlURLTV.setText("RepositoryHtmlURL: " + repositoryHtml_url);


    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView repo_model_nameTV, repo_model_isPrivateTV,
                repo_model_descritionTV, repo_model_languageTV,
                repo_model_cloneURLTV, repo_model_htmlURLTV;


        public ViewHolder(View view) {
            super(view);

            repo_model_nameTV = (TextView) view.findViewById(R.id.repo_model_nameTV);
            repo_model_isPrivateTV = (TextView) view.findViewById(R.id.repo_model_isPrivateTV);
            repo_model_descritionTV = (TextView) view.findViewById(R.id.repo_model_descritionTV);
            repo_model_languageTV = (TextView) view.findViewById(R.id.repo_model_languageTV);
            repo_model_cloneURLTV = (TextView) view.findViewById(R.id.repo_model_cloneURLTV);
            repo_model_htmlURLTV = (TextView) view.findViewById(R.id.repo_model_htmlURLTV);
        }
    }
}
