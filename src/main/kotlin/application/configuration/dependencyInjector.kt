package application.configuration

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.conf.global
import com.github.salomonbrys.kodein.singleton
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

class dependencyInjector
{
    fun Setup()
    {
        val conf = ConfigFactory.load()

        Kodein.global.addConfig {
            //config
            bind<Config>() with singleton { conf }
        }
    }
}