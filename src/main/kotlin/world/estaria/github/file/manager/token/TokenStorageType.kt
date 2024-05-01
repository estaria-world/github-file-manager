package world.estaria.github.file.manager.token

import world.estaria.github.file.manager.token.kubernetes.GitHubTokenSecretHandler
import world.estaria.github.file.manager.token.local.GitHubTokenConfigLoader

/**
 * @author Niklas Nieberler
 */

enum class TokenStorageType {

    KUBERNETES {
        override fun getToken(): String {
            val configMapHandler = GitHubTokenSecretHandler()
            return configMapHandler.get()
        }
    },

    LOCAL {
        override fun getToken(): String {
            return GitHubTokenConfigLoader().load().token
        }
    };

    abstract fun getToken(): String

}