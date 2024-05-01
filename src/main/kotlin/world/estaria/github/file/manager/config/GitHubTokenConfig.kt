package world.estaria.github.file.manager.config

import kotlinx.serialization.Serializable
import world.estaria.github.file.manager.kubernetes.GitHubTokenSecretHandler

/**
 * @author Niklas Nieberler
 */

@Serializable
class GitHubTokenConfig(
    private val storageType: TokenStorageType,
    private val token: String
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
            TokenStorageType.KUBERNETES -> GitHubTokenSecretHandler().get()
            TokenStorageType.LOCAL -> this.token
        }
    }

}