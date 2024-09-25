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
                    echo "incrementing the application version....."
                    sh '
                        mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
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


