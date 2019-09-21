import groovy.json.JsonSlurperClassic
import jenkins.model.*

node (Buildnode) {
	wrks = env.WORKSPACE
	stage ('Code Checkout') {
		git(
			url: "$ApplicationRepo",
			credentialsId: 'SPGH',
			branch: "$Branch"
		)
	}
	cDelivery = readFile "$wrks/cdl/cdelivery.json"
	def jString = new JsonSlurperClassic().parseText(cDelivery).environments
	exec = "";
	jString.each ( {
		stage (it.name) {
			if (it.name == "DEV") {
				if (it.testexecution) {
					exec = "mvn -f $wrks/pom.xml clean build " + it.execute + " package"
				} else {
					exec = "mvn -f $wrks/pom.xml clean build package"
				}
				println ("****************************    Code checkedout from $ApplicationRepo with the revision $Branch ****************************")
				println ("****************************    Executing command $exec ****************************")
			} else {
				if (it.mergecode) {
					println ("****************************    Merging code from ${it.srcbranch} to ${it.destbranch} ****************************")
				}
				if (it.deploy) {
					println ("**************************** Deploying the artifact using deployment tool ****************************")
				} else{
					println ("**************************** Not deploying the artifact ****************************")
				}
				exec = "cdl/" + it.execute 
				sh "chmod 755 $exec"
				println ("****************************  ${it.executiontype}  $exec ****************************")
				if (it.executiontype=="shell") {
					sh "\"$exec\""
				} else if (it.executiontype=="python3"){
					sh "python3 $exec"
				} else if (!it.testname ==""){
					sh "python $exec"
				}
					 
			}
		}
	})
}