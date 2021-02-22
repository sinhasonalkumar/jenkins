def makeStage(var stageName, Closure closure){
    stage(${stageName}){
        closure.call()
    }
}