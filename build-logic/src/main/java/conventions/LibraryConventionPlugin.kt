package conventions

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin
import co.yml.ytag.configureFlavors
import co.yml.ytag.configureKotlinAndroid

/**
 * Library convention plugin
 *
 * @constructor Create empty Library convention plugin
 */
class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("versionCatalogLibs")
            with(pluginManager) {
                apply(libs.findPlugin("android.library").get().get().pluginId)
                apply(libs.findPlugin("kotlin.android").get().get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    testInstrumentationRunner = "co.yml.ytag.core.test.HiltTestRunner"
                }
                defaultConfig.targetSdk = 33
                configureFlavors(this)
            }

            dependencies {
                add("implementation", libs.findLibrary("coroutine").get())

                add("testImplementation", kotlin("test"))
                add("testImplementation", libs.findBundle("coroutine.test").get())
                add("testImplementation", libs.findLibrary("androidx.junit").get())
                add("androidTestImplementation", libs.findLibrary("androidx.junit").get())
                add("androidTestImplementation", kotlin("test"))

            }
        }
    }
}
