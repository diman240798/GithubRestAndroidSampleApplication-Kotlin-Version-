package sfedu.physics.dmitriy.githubapiresttestproject

import org.junit.Assert.assertEquals
import org.junit.Test
import sfedu.physics.dmitriy.githubapiresttestproject.utils.QueryUtils.createQueryByLocationAndLanguage

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun query_creation_works_fine() {

        val emptyQuery = createQueryByLocationAndLanguage("", "")
        assertEquals(emptyQuery, "")

        val query_with_location = createQueryByLocationAndLanguage("USA", "")
        assertEquals(query_with_location, "location:USA+");

        val query_with_language = createQueryByLocationAndLanguage("", "java")
        assertEquals(query_with_language, "language:java")

        val query_with_location_and_language = createQueryByLocationAndLanguage("USA", "kotlin")
        assertEquals(query_with_location_and_language, "location:USA+language:kotlin")
    }
}
