def call(var stageName, Closure closure){
    stage(stageName){
        return closure.call()
    }
}