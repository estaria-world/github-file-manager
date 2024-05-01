package world.estaria.github.file.manager.config

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class GitHubTokenConfigLoader : ConfigLoader<GitHubTokenConfig>(
    File("github-token.yaml"),
    YamlFileFormatter(
        GitHubTokenConfig.serializer()
    ),
    { GitHubTokenConfig.Default.get() }
)