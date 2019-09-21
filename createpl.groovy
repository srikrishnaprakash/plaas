pipelineJob('P1DSJ') {
    definition {
        cps {
                script("readFileFromWorkspace('ci.groovy')")
                sandbox()
        }
    }
}