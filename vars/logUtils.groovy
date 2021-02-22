package com.sonal.jenkins
class Logger{
     def info(message){
       echo "INFO: ${message}"
     } 

    def warning(message) {
      echo "WARNING: ${message}"
    }
}
