package world.estaria.github.file.manager.properties

import world.estaria.github.file.manager.GitHubToken
import java.io.InputStreamReader
import java.net.URI
import java.net.URL
import java.util.*

/**
 * @author Niklas Nieberler
 */

class GitHubPropertiesLoader(
    path: String
) {

    val url: URL = URI("https://raw.githubusercontent.com/$path").toURL()
    val properties = Properties()

    init {
        val connection = this.url.openConnection()
        connection.setRequestProperty("Authorization", "token ${GitHubToken.getToken()}")
        properties.load(InputStreamReader(connection.getInputStream(), "UTF-8"))
    }

}