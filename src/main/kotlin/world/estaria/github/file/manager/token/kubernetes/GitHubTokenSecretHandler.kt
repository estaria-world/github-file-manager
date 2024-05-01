package world.estaria.github.file.manager.token.kubernetes

import io.fabric8.kubernetes.client.KubernetesClientBuilder
import world.estaria.github.file.manager.kubernetes.KubernetesSecrets
import java.util.*
import kotlin.collections.HashMap

/**
 * @author Niklas Nieberler
 */

class GitHubTokenSecretHandler {

    private val kubernetesClient = KubernetesClientBuilder().build()
    private val namespace = kubernetesClient.namespace

    private val secretName = "github-token-secret"
    private val defaultSecrets = hashMapOf(
        Pair("token", ""),
    )

    private fun createSecret(): HashMap<String, String> {
        KubernetesSecrets.createSecret(
            this.kubernetesClient,
            this.namespace,
            this.secretName,
            this.defaultSecrets
        )
        return this.defaultSecrets
    }

    fun get(): String {
        val secrets = KubernetesSecrets
            .getSecret(this.kubernetesClient, this.namespace, this.secretName)?.data ?: createSecret()
        return secrets["token"]?.decodeBase64()
            ?: throw NullPointerException("failed to find connectionString")
    }

    private fun String.decodeBase64(): String {
        return String(Base64.getDecoder().decode(this))
    }

}