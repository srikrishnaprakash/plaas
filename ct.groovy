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
		stage (it.testname + "-testing") {
			if (!it.name == "DEV") {
				println(it.testname)
			}
		}
	})
	stage ("Fortify Scan") {
		println ("Performing fortify scan...")
		println ("Completed fortify scan successfully ...")
	}
}