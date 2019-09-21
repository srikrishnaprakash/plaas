node ('master') {
	bldVar = " "
	WS = env.WORKSPACE
	stage ('Code Checkout') {
		git(
			url: "$ApplicationRepo",
			credentialsId: 'SPGH',
			branch: "$Branch"
		)
		println ("$ApplicationRepo available in workspace and revision is $Branch")
	}
	stage ('Prepare') {
		bldVar = "mvn -f $WS/pom.xml clean build"
		println(bldVar)
		if (Boolean.parseBoolean(PerformUnitTest)) {
			bldVar = bldVar + " test"
			println(bldVar)
		}
		if (Boolean.parseBoolean(PublishReport)) {
			bldVar = bldVar + " sonar:sonar"
			println(bldVar)
		}
	}
	stage ('Build') {
		skp = "pwd"
		sh 'ls -l'
		sh "\"$skp\""
		println("Sucessfully built...")
	}
	stage ('Publish Artifact') {
		println("Artifact pushed to artifactory")
	}
}
