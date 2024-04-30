package world.estaria.github.file.manager.token.local

import world.avionik.configkit.ConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import world.estaria.github.file.manager.token.GitHubTokenConfig
import java.io.File

/**
 * @author Niklas Nieberler
 */

class GitHubTokenConfigLoader : ConfigLoader<GitHubTokenConfig>(
    File("github-token.yaml"),
    YamlFileFormatter(
        GitHubTokenConfig.serializer()
    ),
    { GitHubTokenConfig("asd") }
)