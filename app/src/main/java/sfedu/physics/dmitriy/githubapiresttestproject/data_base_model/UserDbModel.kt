package sfedu.physics.dmitriy.githubapiresttestproject.data_base_model

import io.realm.RealmObject

open class UserDbModel : RealmObject() {

    var login: String? = null


    var htmlURL: String? = null

    var bitmapData: ByteArray? = null
}
