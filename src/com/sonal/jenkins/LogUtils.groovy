package com.sonal.jenkins

def info(message){
   echo "INFO: ${message}"
} 

def warning(message) {
   echo "WARNING: ${message}"
}


def infoWithStage(message){

   makeStage("Log Stage"){
      echo "INFO: ${message}"
      return ${message}
   }
} 