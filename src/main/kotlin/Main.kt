import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.Javalin
import io.javalin.http.HttpStatus

fun main() {
    val numberDao = NumberDao()
    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(HttpStatus.NOT_FOUND) { ctx -> ctx.json("not found") }
    }.start(7070)

    app.routes {

        //Blanket input for testing and smoke testing restlet
        get("/") { ctx ->
            ctx.result("Please provide an input!") }

        //Catch-all for user input
        get("/{input}") { ctx ->
            ctx.json(numberDao.logicalResponse(ctx.pathParam("input")))
        }
        //Numbered entry to restlet
        get("/numbers/{input}") { ctx ->
            ctx.json(numberDao.romanString(ctx.pathParam("input").toInt()))
        }
        //Roman entry to restlet
        get("/romans/{input}") { ctx ->
            ctx.json(numberDao.regularNumber(ctx.pathParam("input")))
        }
    }
}