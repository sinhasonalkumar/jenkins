def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

   pipeline{
    
    agent any

    stages{
        
        stage("checkout"){
            
            steps{
                //gitUtils('https://github.com/sinhasonalkumar/microservices.git')
                gitUtils(pipelineParams.sourceRepoURL)
            }
        }

        stage("log"){
            
            steps{
                script{
                    logUtils.info(' successfully executed pipeline')    
                }
            }
        }
    }
}
}