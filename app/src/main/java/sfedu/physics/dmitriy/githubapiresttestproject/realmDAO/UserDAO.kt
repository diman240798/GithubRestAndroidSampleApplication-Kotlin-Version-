package sfedu.physics.dmitriy.githubapiresttestproject.realmDAO

import java.util.ArrayList

import io.realm.Realm
import io.realm.RealmResults
import sfedu.physics.dmitriy.githubapiresttestproject.data_base_model.UserDbModel
import sfedu.physics.dmitriy.githubapiresttestproject.json_model.user_model.User

class UserDAO {
    private val realm: Realm

    init {
        realm = Realm.getDefaultInstance()
    }

    fun deleteAllUsers() {
        realm.beginTransaction()
        realm.delete(UserDbModel::class.java)
        realm.commitTransaction()
    }

    fun saveUsers(users: List<User>) {
        realm.beginTransaction()
        for (user in users) {
            val userDbModel = realm.createObject(UserDbModel::class.java)
            userDbModel.login = user.login
            userDbModel.bitmapData = user.bitmapData
            userDbModel.htmlURL = user.htmlURL
        }
        realm.commitTransaction()
    }

    fun loadAllUsers(): List<User> {
        val userModels = realm.where(UserDbModel::class.java).findAll()
        val users = ArrayList<User>()
        for (userDbModel in userModels) {
            val user = User()
            user.bitmapData = userDbModel.bitmapData
            user.htmlURL = userDbModel.htmlURL
            user.login = userDbModel.login
            users.add(user)
        }
        return users
    }

    fun closeConnection() {
        realm.close()
    }
}
