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

   pipeline{
    
    agent any

    stages{
        
        stage("Maven Build"){
            
            steps{
                //gitUtils('https://github.com/sinhasonalkumar/microservices.git')
                //gitUtils(pipelineParams.sourceRepoURL)
                 script{
                     buildUtils.mavenBuild(' clean package')
                 }    

            }
        }

        stage("Log"){
            
            steps{
                script{
                    logUtils.info(' successfully executed pipeline')     
                }
            }
        }
    }
   }
}