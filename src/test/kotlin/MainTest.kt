
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

class MainTest {
    //declare HTTPClient used for testing
    private val client : OkHttpClient
    //Initialize the Restlet Once for all tests
    companion object {
        @BeforeClass
        @JvmStatic fun setup() {
            main()
        }
    }
    //Initalize builder and client
    init {
        val newBuilder = OkHttpClient.Builder()
        client = newBuilder.build()
    }
    @Test
    fun `test launching of Restlet localhost`() {


        //port 7070 hard coded for localhost
        val response = client.newCall(Request.Builder().url("http://localhost:7070/").build()).execute()
        assertEquals(200, response.code)
    }
    @Test
    fun `Restlet to ask for input`() {
        val response = client.newCall(Request.Builder().url("http://localhost:7070/").build()).execute()
        assertEquals("Please provide an input!", response.body?.string())
    }
    @Test
    fun `Restlet to ask for INT logical resoning`() {
        val response = client.newCall(Request.Builder().url("http://localhost:7070/55").build()).execute()
        assertEquals("LV", response.body?.string())
    }
    @Test
    fun `Restlet to ask for  STRING logical resoning`() {
        val response = client.newCall(Request.Builder().url("http://localhost:7070/XXI").build()).execute()
        assertEquals("21", response.body?.string())
    }
    @Test
    fun `Restlet to ask for roman conversion`() {
        val response = client.newCall(Request.Builder().url("http://localhost:7070/romans/MM").build()).execute()
        assertEquals("2000", response.body?.string())
    }
    @Test
    fun `Restlet to ask for integer conversion`() {
        val response = client.newCall(Request.Builder().url("http://localhost:7070/numbers/1458").build()).execute()
        assertEquals("MCDLVIII", response.body?.string())
    }

}