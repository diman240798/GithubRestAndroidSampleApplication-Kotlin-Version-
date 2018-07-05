package sfedu.physics.dmitriy.githubapiresttestproject.realmDAO;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel;
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository;

public class RepositoryDao {
    private final Realm realm;

    {
        realm = Realm.getDefaultInstance();
    }

    public void saveRepositories(List<Repository> repositories) {
        realm.beginTransaction();
        for (Repository repository : repositories) {
            RepositoryDbModel repositoryDbModel = realm.createObject(RepositoryDbModel.class);
            repositoryDbModel.setClone_url(repository.getClone_url());
            repositoryDbModel.setDescription(repository.getDescription());
            repositoryDbModel.setHtml_url(repository.getHtml_url());
            repositoryDbModel.setLanguage(repository.getLanguage());
            repositoryDbModel.setPrivate(repository.isPrivate());
        }
        realm.commitTransaction();
    }

    public List<Repository> loadAllRepositories() {
        RealmResults<RepositoryDbModel> userModels = realm.where(RepositoryDbModel.class).findAll();
        List<Repository> repositories = new ArrayList<>();
        for (RepositoryDbModel repositoryDbModel : userModels) {
            Repository repository = new Repository();
            repository.setClone_url(repositoryDbModel.getClone_url());
            repository.setDescription(repositoryDbModel.getDescription());
            repository.setHtml_url(repositoryDbModel.getHtml_url());
            repository.setLanguage(repositoryDbModel.getLanguage());
            repository.setPrivate(repositoryDbModel.isPrivate());
            repositories.add(repository);
        }
        return repositories;
    }

    public void deleteAllRepositories() {
        realm.beginTransaction();
        realm.delete(RepositoryDbModel.class);
        realm.commitTransaction();
    }

    public void closeConnection() {
        realm.close();
    }
}
