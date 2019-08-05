package com.sapient.learning

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpHeaders
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.slf4j.event.Level

data class Author(var id: Int, val name: String, val website: String)

val authorList = ArrayList<Author>()

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start()
}

fun Application.module() {
    // sets the server header (has a default value of the application name if not set)
    install(DefaultHeaders) { header(HttpHeaders.Server, "My ktor server") }
    // controls what level the call logging is logged to
    install(CallLogging) { level = Level.INFO }
    // setup jackson json serialisation
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    // route requests to handler functions
    routing {
        route("/") {
            get("/") {
                call.respondText { "Hello Ktor!" }
            }
        }
        route("/authors") {
            post {
                val author = call.receive<Author>()
                author.id = authorList.size
                authorList.add(author)
                call.respond("Added")

            }
            delete("/{id}") {
                call.respond(authorList.removeAt(call.parameters["id"]!!.toInt()))
            }
            get("/{id}") {
                call.respond(authorList[call.parameters["id"]!!.toInt()])
            }
            get {
                call.respond(authorList)
            }
        }
    }
}