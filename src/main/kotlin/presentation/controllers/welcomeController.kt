package presentation.controllers

import com.github.salomonbrys.kodein.conf.KodeinGlobalAware
import com.github.salomonbrys.kodein.instance
import com.typesafe.config.Config
import org.jooby.mvc.GET
import org.jooby.mvc.Path
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Path("/welcome")
class welcomeController : KodeinGlobalAware {
    val Config : Config = instance()
    val Logger : Logger = LoggerFactory.getLogger(this::class.java!!)

    @GET
    fun getWelcome(): String  {
        val applicationPort = Config.getNumber("application.port")

        return "Welcome to sample kotlin application. Running on port $applicationPort"
    }
}