import org.apache.commons.codec.binary.Base64

tasks.register("hello") {
    doLast {
        println("Hello world!")
    }
}

tasks.register("upper") {
    doLast {
        val someString: String = "mY_nAmE"
        println("Original: ${someString}")
        println("Upper case: ${someString.toUpperCase()}")
    }
}

tasks.register("count") {
    doLast {
        for (i in 0 until 4) {
            print("${i} ")
        }
    }
}

tasks.register("intro") {
    dependsOn("hello")
    doLast {
        println("I'm Gradle")
    }
}

tasks.register("taskX") {
    dependsOn("taskY")
    doLast {
        println("taskX")
    }
}

tasks.register("taskY") {
    doLast {
        println("taskY")
    }
}

repeat(4) {
    tasks.register("task${it}") {
        doLast {
            println("I'm task number ${it}")
        }
    }
}

tasks.named("task0") { dependsOn("task2", "task3") }

tasks.register("planet") {
    doLast {
        println("Hello Earth")
    }
}

tasks.named("planet") {
    doFirst {
        println("Hello Venus")
    }
}

tasks.named("planet") {
    doLast {
        println("Hello Mars")
    }
}

tasks.named("planet") {
    doLast {
        println("Hello Jupiter")
    }
}

defaultTasks("clean", "run")

tasks.register("clean") {
    doLast {
        println("Default Cleaning!")
    }
}

tasks.register("run") {
    doLast {
        println("Default Running!")
    }
}

tasks.register("other") {
    doLast {
        println("I'm not a default task!")
    }
}

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        "classpath"(group="commons-codec", name="commons-codec", version="1.2")
    }
}

tasks.register("encode") {
    doLast {
        val encodedString: ByteArray = Base64().encode("hello world\n".toByteArray())
        println(String(encodedString))
    }
}