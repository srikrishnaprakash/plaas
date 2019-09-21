node('master') {
    git(
			url: "$ApplicationRepository",
			branch: "master"
		)
    stage("Prepare"){
        println("Preparing...")
    }
    stage("Clone"){
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