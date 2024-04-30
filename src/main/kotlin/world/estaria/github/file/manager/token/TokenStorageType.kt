package world.estaria.github.file.manager.token

import world.estaria.github.file.manager.token.kubernetes.GitHubTokenConfigMapHandler
import world.estaria.github.file.manager.token.local.GitHubTokenConfigLoader

/**
 * @author Niklas Nieberler
 */

enum class TokenStorageType {

    KUBERNETES {
        override fun getToken(): String {
            val configMapHandler = GitHubTokenConfigMapHandler()
            return configMapHandler.getConfig().token
        }
    },

    LOCAL {
        override fun getToken(): String {
            return GitHubTokenConfigLoader().load().token
        }
    };

    abstract fun getToken(): String

}