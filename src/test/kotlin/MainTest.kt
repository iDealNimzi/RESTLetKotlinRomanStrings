
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.Test

class MainTest {
    //declare HTTPClient used for testing
    private val client : OkHttpClient
    //Initalize builder and client
    init {
        val newBuilder = OkHttpClient.Builder()
        client = newBuilder.build()
    }
    @Test
    fun `test launching of Restlet localhost`() {

        main()
        //port 7070 hard coded for localhost
        val response = client.newCall(Request.Builder().url("http://localhost:7070/").build()).execute()
        assertEquals(200, response.code)
    }
}