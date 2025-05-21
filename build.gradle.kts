plugins {
    id("net.labymod.labygradle")
    id("net.labymod.labygradle.addon")
}

val versions = providers.gradleProperty("net.labymod.minecraft-versions").get().split(";")

group = "org.example"
version = providers.environmentVariable("VERSION").getOrElse("1.0.0")

labyMod {
    defaultPackageName = "com.rappytv.nametagresizer"

    addonInfo {
        namespace = "nametagresizer"
        displayName = "Nametag Resizer"
        author = "RappyTV"
        description = "Easily edit the render size of nametags"
        minecraftVersion = "1.8.9<1.21.5"
        version = rootProject.version.toString()
    }

    minecraft {
        registerVersion(versions.toTypedArray()) {
            runs {
                getByName("client") {
                    devLogin = true
                }
            }
        }
    }
}

subprojects {
    plugins.apply("net.labymod.labygradle")
    plugins.apply("net.labymod.labygradle.addon")

    group = rootProject.group
    version = rootProject.version
}