package sfedu.physics.dmitriy.githubapiresttestproject.api

import com.google.gson.annotations.SerializedName

class AccessToken(@field:SerializedName("access_token")
                  var accessToken: String?, @field:SerializedName("token_type")
                  var tokenType: String?)

