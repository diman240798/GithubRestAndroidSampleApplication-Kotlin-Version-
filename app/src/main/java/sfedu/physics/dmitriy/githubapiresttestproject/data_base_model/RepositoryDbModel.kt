package sfedu.physics.dmitriy.githubapiresttestproject.data_base_model

import io.realm.RealmObject

open class RepositoryDbModel : RealmObject() {

    var name: String? = null

    var isPrivate: Boolean = false

    var description: String? = null

    var language: String? = null

    var clone_url: String? = null

    var html_url: String? = null
}
