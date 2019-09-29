folder ("$BUName") { }
folder ("$BUName/$ProductName") { }
pipelineJob("$BUName/$ProductName/CICD_$AppName") {
  parameters {
    stringParam('AppRepo',"$ApplicationRepo","GIT URL")
  }
}