package world.estaria.github.file.manager.properties

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.KSerializer
import world.estaria.github.file.manager.GitHubToken
import java.io.FileNotFoundException
import java.net.URI
import java.net.URL

/**
 * @author Niklas Nieberler
 */

class GitHubYamlLoader<C>(
    path: String,
    serializer: KSerializer<C>
) {

    val url: URL = URI("https://raw.githubusercontent.com/$path").toURL()

    private var config: C? = null

    init {
        val connection = this.url.openConnection()
        connection.setRequestProperty("Authorization", "token ${GitHubToken.getToken()}")

        try {
            this.config = Yaml.default.decodeFromStream(serializer, connection.getInputStream())
        } catch (exception: FileNotFoundException) {
            println("Failed to find url $url")
        }
    }

    fun getYaml(): C? = this.config

}