pipelineJob('P1DSJ') {
    
    git [branch:'develop', url:'git@github.com:srikrishnaprakash/pls.git']
    definition {
        cps {
                script("readFileFromWorkspace('ci.groovy')")
                sandbox()
        }
    }
}