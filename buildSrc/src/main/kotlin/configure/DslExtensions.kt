package configure

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.compose.desktop.DesktopExtension
import org.jetbrains.compose.experimental.dsl.ExperimentalExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

val KotlinMultiplatformExtension.compose: ComposePlugin.Dependencies
    get() = (this as ExtensionAware).extensions.getByType()

fun Project.compose(configure: ComposeExtension.() -> Unit): Unit =
    extensions.configure("compose", configure)

fun ComposeExtension.desktop(block: DesktopExtension.() -> Unit) =
    (this as ExtensionAware).configure<DesktopExtension>(block)

fun ComposeExtension.experimental(block: ExperimentalExtension.() -> Unit) =
    (this as ExtensionAware).configure<ExperimentalExtension>(block)

fun Project.kotlin(configure: KotlinMultiplatformExtension.() -> Unit): Unit =
    extensions.configure("kotlin", configure)

fun Project.android(configure: LibraryExtension.() -> Unit): Unit =
    extensions.configure("android", configure)


