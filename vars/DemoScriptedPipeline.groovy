import com.sonal.jenkins.GitUtils
import com.sonal.jenkins.BuildUtils
import com.sonal.jenkins.LogUtils

def call(body) {
    def logUtils = new LogUtils()
    def buildUtils = new BuildUtils()
    def gitUtils = new GitUtils()
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    
    node {

      /*  
        stage("Maven Build"){
             buildUtils.mavenBuild(' clean package')
        }

        stage("Log"){
            logUtils.info("Testing Scripted Pipeline")
        }
        */

        withStage("Git Checkout") {
            gitUtils.checkout(pipelineParams.sourceRepoURL)
        }

        withStage("Maven Build") {
            buildUtils.mavenBuild(' clean package')
        }

        withStage("Log") {
            logUtils.info("Testing Scripted Pipeline")
        }
    }
}