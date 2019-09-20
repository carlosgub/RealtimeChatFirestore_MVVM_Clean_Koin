buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath (Build.androidGradlePlugin)
        classpath (Build.kotlinGradlePlugin)
        classpath (Build.googleServicesPlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean").configure {
    delete("build")
}
