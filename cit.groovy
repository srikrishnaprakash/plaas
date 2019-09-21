node('master') {
    stage("Prepare"){
        println("Preparing...")
    }
    stage("Clone"){
        println("Cloning the git...")
    }
    stage("Build"){
        println("Building the app using maven")
    }
    stage("Test"){
        println("Testing...")
    }
    stage("Deploy"){
        println("Deploying...")
    }
}