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
    steps {
        //This is a comment
        dsl {
                external('ci.groovy')
        }
    }
}