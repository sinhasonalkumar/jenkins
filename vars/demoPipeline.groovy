def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

   pipeline{
    
    agent any
    
    libraries {
     lib('shared-library')
    }

    stages{
        
        stage("checkout"){
            
            steps{
                //gitUtils('https://github.com/sinhasonalkumar/microservices.git')
                //gitUtils(pipelineParams.sourceRepoURL)
                def logger = new Logger()
                logger.info(' checking file getting loaded from src folder')
            }
        }
    }
}
}