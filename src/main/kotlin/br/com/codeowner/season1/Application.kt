package br.com.codeowner.season1

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    var appServer: ApplicationEngine? = null
    try {
        appServer = Application::appServer.startServer(8080, false)
        Application::managementServer.startServer(8081, true)
    } catch (ex: Exception) {
        println("An exception occurs and server will shutdown.")
    } finally {
        appServer?.stop(3000, 3000)
    }
}

fun Application.appServer() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        myRoutes()
    }
}

fun Application.managementServer() {
    routing {
        get("healthcheck") {
            call.respondText("OK")
        }
    }
}

fun (Application.() -> Unit).startServer(port: Int, waitStart: Boolean): NettyApplicationEngine =
    embeddedServer(Netty, port, module = this).start(waitStart)
