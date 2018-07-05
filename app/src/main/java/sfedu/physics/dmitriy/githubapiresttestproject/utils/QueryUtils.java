package sfedu.physics.dmitriy.githubapiresttestproject.utils;

public class QueryUtils {
    public static String createQueryByLocationAndLanguage(String userLocation, String userProgrammingLanguage) {
        StringBuilder query = new StringBuilder();
        if (!userLocation.isEmpty())
            query.append(String.format("location:%s+", userLocation));
        if (!userProgrammingLanguage.isEmpty())
            query.append(String.format("language:%s", userProgrammingLanguage));

        return query.toString();
    }
}
