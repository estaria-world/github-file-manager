package world.estaria.github.file.manager.config

import kotlinx.serialization.Serializable

/**
 * @author Niklas Nieberler
 */

@Serializable
class GitHubTokenConfig(
    private val storageType: TokenStorageType,
    private val token: String?
) {

    object Default {
        fun get(): GitHubTokenConfig {
            return GitHubTokenConfig(
                TokenStorageType.LOCAL,
                ""
            )
        }
    }

    fun getToken(): String {
        return when (this.storageType) {
            TokenStorageType.LOCAL -> this.token ?: "empty"
        }
    }

}