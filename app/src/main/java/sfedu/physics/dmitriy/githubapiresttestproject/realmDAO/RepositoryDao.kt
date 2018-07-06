package sfedu.physics.dmitriy.githubapiresttestproject.realmDAO

import java.util.ArrayList

import io.realm.Realm
import io.realm.RealmResults
import sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.RepositoryDbModel
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.repos_model.Repository

class RepositoryDao {
    private val realm: Realm

    init {
        realm = Realm.getDefaultInstance()
    }

    fun saveRepositories(repositories: List<Repository>) {
        realm.beginTransaction()
        for (repository in repositories) {
            val repositoryDbModel = realm.createObject(RepositoryDbModel::class.java)
            repositoryDbModel.clone_url = repository.clone_url
            repositoryDbModel.description = repository.description
            repositoryDbModel.html_url = repository.html_url
            repositoryDbModel.language = repository.language
            repositoryDbModel.isPrivate = repository.isPrivate
        }
        realm.commitTransaction()
    }

    fun loadAllRepositories(): List<Repository> {
        val userModels = realm.where(RepositoryDbModel::class.java).findAll()
        val repositories = ArrayList<Repository>()
        for (repositoryDbModel in userModels) {
            val repository = Repository()
            repository.clone_url = repositoryDbModel.clone_url
            repository.description = repositoryDbModel.description
            repository.html_url = repositoryDbModel.html_url
            repository.language = repositoryDbModel.language
            repository.isPrivate = repositoryDbModel.isPrivate
            repositories.add(repository)
        }
        return repositories
    }

    fun deleteAllRepositories() {
        realm.beginTransaction()
        realm.delete(RepositoryDbModel::class.java)
        realm.commitTransaction()
    }

    fun closeConnection() {
        realm.close()
    }
}
