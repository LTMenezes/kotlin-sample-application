package application

import application.configuration.dependencyInjector
import com.github.salomonbrys.kodein.conf.KodeinGlobalAware
import org.jooby.handlers.Cors
import org.jooby.handlers.CorsHandler
import org.jooby.swagger.SwaggerUI
import presentation.controllers.welcomeController

object app : KodeinGlobalAware
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        dependencyInjector().Setup()

        org.jooby.run(*args) {
            SwaggerUI().filter({ route -> route.pattern().startsWith("/") }).install(this)

            use("*", CorsHandler(Cors()))

            use(welcomeController::class)
        }
    }
}