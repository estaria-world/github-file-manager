package world.estaria.github.file.manager.token

/**
 * @author Niklas Nieberler
 */

object GitHubToken {

    /**
     * Gets a github token via a config or via Kubernetes
     * @param type the storage type of the token
     * @return github token
     */
    fun getToken(type: TokenStorageType = TokenStorageType.KUBERNETES): String {
        return type.getToken()
    }

}