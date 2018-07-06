package sfedu.physics.dmitriy.githubapiresttestproject.utils

class QueryUtils {
    companion object {
        fun  createQueryByLocationAndLanguage(userLocation: String, userProgrammingLanguage: String): String {
            val query = StringBuilder()
            if (!userLocation.isEmpty())
                query.append(String.format("location:%s+", userLocation))
            if (!userProgrammingLanguage.isEmpty())
                query.append(String.format("language:%s", userProgrammingLanguage))

            return query.toString()
        }
    }
}
