import jenkins.model.*

folder ("$ApplicationName") {
}
folder ("$ApplicationName" + "-cdl") {
}

jNameci = "$ApplicationName" + "/" + "$BUName" + "-" + "$ApplicationName" + "-dev-con-int"
jNamecd = "$ApplicationName" + "/" + "$BUName" + "-" + "$ApplicationName" + "-dev-con-dep"
jNamect = "$ApplicationName" + "/" + "$BUName" + "-" + "$ApplicationName" + "-dev-con-tst"
jNamecdl = "$ApplicationName" + "-cdl/" + "$BUName" + "-" + "$ApplicationName" + "-dev-con-del"

pipelineJob (jNameci) {
	parameters {
		stringParam('ApplicationRepo',"$ApplicationRepo", "Application code repo to build")
		stringParam('Branch',"$Branch", "Application code branch to build")
		booleanParam('PerformUnitTest', true, 'Uncheck to disable unit tests')
		booleanParam('PublishReport', true, 'Uncheck not to push in artifactory after tests')
		booleanParam('PerformIntegrationTest', true, 'Uncheck to disable integration tests')
		booleanParam('PushArtifact', true, 'Uncheck not to push in artifactory after tests')
		stringParam('Buildnode',"$Buildnode", "Slave node to perform build")
	}
	definition {
		cps {
			def jobScript = readFileFromWorkspace('ci.groovy')
			script(jobScript)
			def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
			approvals.approveScript(approvals.hash(jobScript,"groovy"))
		}
	}
}

pipelineJob (jNamecd) {
	parameters {
		stringParam('ApplicationRepo',"$ApplicationRepo", "Application code repo to build")
		stringParam('Branch',"$Branch", "Application code branch to build")
		stringParam('Buildnode',"$Buildnode", "Slave node to perform build")
	}
	definition {
		cps {
			def jobScript = readFileFromWorkspace('cd.groovy')
			script(jobScript)
			def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
			approvals.approveScript(approvals.hash(jobScript,"groovy"))
		}
	}
}

pipelineJob (jNamect) {
		parameters {
			stringParam('ApplicationRepo',"$ApplicationRepo", "Application code repo to build")
			stringParam('Branch',"$Branch", "Application code branch to build")
			stringParam('Buildnode',"$Buildnode", "Slave node to perform build")
		}
		definition {
			cps {
				def jobScript = readFileFromWorkspace('ct.groovy')
				script(jobScript)
				def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
				approvals.approveScript(approvals.hash(jobScript,"groovy"))
			}
		}
}

pipelineJob (jNamecdl) {
		parameters {
			stringParam('ApplicationRepo',"$ApplicationRepo", "Application code repo to build")
			stringParam('Branch',"$Branch", "Application code branch to build")
			stringParam('Buildnode',"$Buildnode", "Slave node to perform build")
		}
		definition {
			cps {
				def jobScript = readFileFromWorkspace('cdl.groovy')
				script(jobScript)
				def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
				approvals.approveScript(approvals.hash(jobScript,"groovy"))
			}
		}
}