package world.estaria.github.file.manager.loader

import world.estaria.github.file.manager.token.GitHubToken
import world.estaria.github.file.manager.token.TokenStorageType
import java.net.URI
import java.net.URL
import java.util.*

/**
 * @author Niklas Nieberler
 */

class GitHubPropertiesLoader(
    path: String,
    tokenStorageType: TokenStorageType = TokenStorageType.KUBERNETES
) {

    val url: URL = URI("https://raw.githubusercontent.com/$path").toURL()
    val properties = Properties()

    init {
        val connection = this.url.openConnection()
        connection.setRequestProperty("Authorization", "token ${GitHubToken.getToken(tokenStorageType)}")
        properties.load(connection.getInputStream())
    }

}