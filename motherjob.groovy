import jenkins.model.*

folder ("$BUName") { 
}

job("$BUName/MotherJob") {
	parameters {
		stringParam('ApplicationName',"$AppName", "Name of the application")
		stringParam('BUName',"$BUName", "Name of the BU")
		stringParam('ApplicationRepo',"$ApplicationRepo", "Application code repo to build")
		stringParam('Branch',"$Branch", "Branch to build")
		stringParam('Buildnode',"master", "Slave node to perform build")
	}
	label ("master")
	
	scm {
		git {
			remote {
				url "git@github.com:srikrishnaprakash/doara.git"
				credentials "SPGH"
			}
			branch ("master")
		}
	}
	
	steps {
		dsl {
			external ('basepipelines.groovy')
			lookupStrategy('SEED_JOB')
		}
	}
}