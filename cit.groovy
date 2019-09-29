node("$NodeName") {
    stage("Prepare"){
        println("Preparing...")
        git(
			url: "git@github.com:srikrishnaprakash/pls.git",
			branch: "master"
	    )
    }
    stage("Clone Application"){
        load 'app/clne.groovy'
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