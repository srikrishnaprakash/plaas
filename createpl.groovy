pipelineJob('P1DSJ') {
    parameters {
		stringParam('ApplicationRepository',"$ApplicationRepo", "Application code repo to build")
    }
    definition {
        cps {
			def jobScript = readFileFromWorkspace('cit.groovy')
			script(jobScript)
			def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
			approvals.approveScript(approvals.hash(jobScript,"groovy"))
        }
    }
}