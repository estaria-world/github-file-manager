package world.estaria.github.file.manager.token

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class GitHubTokenConfig(
    val token: String
)