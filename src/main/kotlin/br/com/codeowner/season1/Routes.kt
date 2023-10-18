package br.com.codeowner.season1

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.myRoutes() {
    route("v1") {
        route("trips") {
            get {
                val r = Injection.tripUseCase.getTrip()
                call.respond(r)
            }
        }
    }
}
