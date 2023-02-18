job('NodeJS-JobDSL-docker') {
    scm {
        git('https://github.com/valentineanagbogu/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Valentine')
            node / gitConfigEmail('val@jenkins.jenk')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('valentineanagbogu/nodejs-jobdsl')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
