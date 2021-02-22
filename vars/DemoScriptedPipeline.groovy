import com.sonal.jenkins.GitUtils
import com.sonal.jenkins.BuildUtils
import com.sonal.jenkins.LogUtils

def call(body) {
    def logUtils = new LogUtils()
    def buildUtils = new BuildUtils()
    def gitUtils = new GitUtils()
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    
    node(any) {
        
        logUtils.info("Testing Declarative Pipeline")
    }
}