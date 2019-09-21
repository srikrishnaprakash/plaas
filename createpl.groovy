pipelineJob('P1DSJ') {
    description('My first job')
    displayName('PipelineExampleProject')
    scm {
        git {
            remote {
                url('git@github.com:srikrishnaprakash/pls.git')
            }
        }
    }
    definition {
        //This is a comment
        cps {
                script(readFileFromWorkspace('ci.groovy'))
                sandbox()
        }
    }
}