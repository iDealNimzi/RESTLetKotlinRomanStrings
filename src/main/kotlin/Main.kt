import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.Javalin
import io.javalin.http.HttpStatus

fun main() {

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(HttpStatus.NOT_FOUND) { ctx -> ctx.json("not found") }
    }.start(7070)

    app.routes {

        //Blanket input for testing and smoke testing restlet
        get("/") { ctx ->
            ctx.result("Please provide an input!") }

    }
}