node("$NodeName") {
    wrks = env.WORKSPACE
    stage("Prepare"){
        println("Preparing...")
        git(
                url: "git@github.com:srikrishnaprakash/pls.git",
                branch: "master"
	    )
        dir('config') {
          git(
                url: "git@github.com:srikrishnaprakash/conf.git",
                branch: "master"
	        )  
        }
        
        
    }
    stage("Clone Application"){
        load 'app/clne.groovy'
    }
    stage("Build"){
        load 'app/bld.groovy'
    }
    stage("Test"){
        println("Testing...")
    }
    stage("Deploy"){
        println("Deploying...")
    }
}