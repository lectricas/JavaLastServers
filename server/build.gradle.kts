plugins {
    application
}

configure<JavaApplication> {
    mainClass.set("ru.itmo.java.server.Server")
}

dependencies {
    implementation(project(":common"))
}
