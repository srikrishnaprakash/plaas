freeStyleJob('FldrCreateDSJ') {
     scm {
        github('srikrishnaprakash/psl', 'master')
    }
    steps {
        dsl {
            external('fldr.groovy')
        }
    }
}