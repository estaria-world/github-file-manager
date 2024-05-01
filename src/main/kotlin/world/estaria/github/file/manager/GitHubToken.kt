package world.estaria.github.file.manager

import world.estaria.github.file.manager.config.GitHubTokenConfigLoader

/**
 * @author Niklas Nieberler
 */

object GitHubToken {

    /**
     * Gets a github token via a config or via Kubernetes
     * @return github token
     */
    fun getToken(): String {
        val tokenConfig = GitHubTokenConfigLoader().load()
        return tokenConfig.getToken()
    }

}