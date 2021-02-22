package com.sonal.jenkins

def call(def repoURL){
     git repoURL
} 

def checkout(def branch, def repoURL){
     git branch: branch , url: repoURL
} 