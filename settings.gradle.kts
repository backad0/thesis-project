dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(":product-process")
include(":application-storage")
include(":scoring-manager")

rootProject.name = "thesis-project"
include("frontend-module")