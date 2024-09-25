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
        stage("version increment"){
            steps{
                script{
                    gv.IncrementVersion()
                }
            }
        }
        stage("build jar"){
            steps{
                script {
                    gv.BuildJar()
                }
            }
        }
        stage("build image"){
            steps{
                script {
                    gv.BuildImage()
                }
            }
        }
        stage("deploy"){
            steps{
               script {
                    gv.DeployApp()
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


