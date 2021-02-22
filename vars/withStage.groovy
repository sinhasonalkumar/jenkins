def call(String stageName, Closure closure){
    stage(stageName){
       return closure.call()
    }
}