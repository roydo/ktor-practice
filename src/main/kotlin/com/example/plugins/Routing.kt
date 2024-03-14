package com.example.plugins

import freemarker.cache.ClassTemplateLoader
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import javax.naming.AuthenticationException

fun Application.module() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondHtml(status = status) {
                body {
                    h1 { +"404!!!!!" }
                }
            }
        }
    }
    
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    
    routing {
        get("/") {
            call.respond(FreeMarkerContent(
                "index.ftl",
                null
            ))
        }
        get("/article") {
            call.respond(FreeMarkerContent(
                "article.ftl",
                null
            ))
        }
        get("/sub/subpage") {
            call.respond(FreeMarkerContent(
                "subpage.ftl",
                null
            ))
        }
        
        staticResources(
            "/static",
            "files"
        ) {
            /*exclude { url ->
                url.path.contains("secret")
            }*/
        }
    }
}
