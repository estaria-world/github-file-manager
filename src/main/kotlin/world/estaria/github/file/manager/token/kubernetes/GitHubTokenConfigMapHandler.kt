package world.estaria.github.file.manager.token.kubernetes

import io.fabric8.kubernetes.client.KubernetesClientBuilder
import world.estaria.github.file.manager.token.GitHubTokenConfig
import world.estaria.kube.configmap.kit.KubeConfigMapKit

/**
 * @author Niklas Nieberler
 */

class GitHubTokenConfigMapHandler {

    private val kubernetesClient = KubernetesClientBuilder().build()

    private val configSerializer = GitHubTokenConfig.serializer()
    private val configName = "github-token.yaml"
    private val configMapManager = KubeConfigMapKit.initializeKubeConfig("strela-system", kubernetesClient)

    init {
        if (!this.configMapManager.existsConfig(configName)) {
            this.configMapManager.createConfigMap(configName, configSerializer, GitHubTokenConfig("asd"))
        }
    }

    fun updateConfig() {
        this.configMapManager.updateConfig(this.configName)
    }

    fun getConfig(): GitHubTokenConfig {
        return this.configMapManager.getConfig(this.configName, this.configSerializer)
            ?: throw NullPointerException("failed to find $configName")
    }

}