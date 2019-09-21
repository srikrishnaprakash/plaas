import groovy.json.JsonSlurperClassic
import jenkins.model.*

node (Buildnode) {
	wrks = env.WORKSPACE
	stage ("Checkout Code") {
		git(
			url: "$ApplicationRepo",
			credentialsId: 'SPGH',
			branch: "$Branch"
		)
	}
	cDelivery = readFile "$wrks/cdl/cdelivery.json"
	def jString = new JsonSlurperClassic().parseText(cDelivery).environments
	jString.each ( {
		if (it.deploy) {
			stage (it.name + "-deploy") {
				if (!it.name == "DEV") {
					println("Deployed for " + it.testname)
				}
			}
		}
	})
}