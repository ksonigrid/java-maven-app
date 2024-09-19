#! /usr/bin/env groovy
@Library('Jenkins-shared-library')
def gv

pipeline{
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages{
        stage("init"){ // loading the script.groovy
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
            
        }
        stage("build jar"){
            steps{
                script {
                    BuildJar()
                }
            }
        }
        stage("build image and push"){
            steps{
                script {
                    BuildImage('ksonigrid/java-mavenrepo:3.0')
                    dockerLogin()
                    dockerPush('ksonigrid/java-mavenrepo:3.0')
                    echo "yoo"
                }
            }
        }
        stage("deploy"){
            steps{
               script {
                    DeployApp()
               }
            }
        }
    }
}
// post{
//     success {
//         // executed when build success
//     }
//     always {
//         // always executed regardless of build failure/success
//     }
//     failure {
//         // executed when build failure
//     }
// }
