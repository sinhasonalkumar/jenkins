package com.sonal.jenkins

def mavenBuild(buildArgs){
    withMaven(maven: 'maven') {
        sh "mvn ${buildArgs}"
    }
}