freeStyleJob('FldrCreateDSJ') {
    git {
        remote {
            url('git@github.com:srikrishnaprakash/pls.git')
        }
    }
    steps {
        dsl {
            external('fldr.groovy')
        }
    }
}