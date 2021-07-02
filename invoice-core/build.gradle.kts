plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm {
        library();
        withJava()
        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
    js(IR) { library() }
    val darwinTargets = listOf(
        macosX64(),
        iosArm64(),
        iosArm32(),// comment this out if IDEA can't resolve source sets
        iosX64(),
        watchosArm32(),
        watchosArm64(),
        watchosX86(), // comment this out if IDEA can't resolve source sets
        tvosArm64(),
        tvosX64()
    )

    val linuxTargets = listOf(
        linuxX64()
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx("serialization-json", vers.kotlinx.serialization))
                api(kotlinx("datetime", vers.kotlinx.datetime))
                api(asoft("email-core", vers.asoft.contacts))
                api(asoft("phone-core", vers.asoft.contacts))
                api(asoft("kash-core", vers.asoft.kash))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("expect-core", vers.asoft.expect))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.invoice,
    description = "A platform agnostic representation of invoices"
)