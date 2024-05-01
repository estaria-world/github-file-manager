package world.estaria.github.file.manager.kubernetes

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder
import io.fabric8.kubernetes.api.model.Secret
import io.fabric8.kubernetes.client.KubernetesClient
import io.fabric8.kubernetes.client.KubernetesClientBuilder


/**
 * @author Niklas Nieberler
 */

object KubernetesSecrets {

    fun createSecret(
        kubernetesClient: KubernetesClient,
        namespace: String,
        secretName: String,
        secrets: Map<String, String>
    ) {
        val secret = Secret()
        secret.metadata = ObjectMetaBuilder().withName(secretName).build()
        secret.data = secrets

        kubernetesClient.secrets()
            .inNamespace(namespace)
            .resource(secret)
            .create()
    }

    fun getSecret(kubernetesClient: KubernetesClient, namespace: String, secretName: String): Secret? {
        return kubernetesClient.secrets()
            .inNamespace(namespace)
            .withName(secretName)
            .get()
    }

}