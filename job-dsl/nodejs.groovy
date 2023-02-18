// start
job('NodeJS-JobDSL') {
    
    // git repository which will be used in the job
    scm {
        git('https://github.com/valentineanagbogu/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Valentine A')
            node / gitConfigEmail('val@jenkins.jenk')
        }
    }
    
    // how often you want to build
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    
    //build steps
    steps {
        shell("npm install")
    }
}
