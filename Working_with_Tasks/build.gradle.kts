tasks.register("hello") {
    doLast {
        println("hello")
    }
}

tasks.register<Copy>("copy") {
    from(file("srcDir"))
    into(buildDir)
    println("This is copy task")
}

//val hello2 by tasks.registering {
//    doLast {
//        println("hello")
//    }
//}
//
//val copy2 by tasks.registering(Copy::Class) {
//    from(file("srcDir"))
//    into(buildDir)
//}

println(tasks.named("hello").get().name)
println(tasks.named<Copy>("copy").get().destinationDir)

tasks.withType<Tar>().configureEach {
    enabled=false
}

tasks.register("test") {
    dependsOn(tasks.withType<Copy>())
}

tasks.register<Copy>("copy2") {
    from("resources")
    into("target")
    include("**/*.txt", "**/*.xml", "**/*.properties")
}