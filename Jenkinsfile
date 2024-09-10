pipeline{
    agent any
    stages{
        stage("build"){
            steps{
                echo "building the application"
            }
        }
        stage("test"){
            steps{
                echo "testing the application"
            }
        }
        stage("deploy"){
            steps{
                echo "deploying the application"
            }
        }
    }
}
post{
    success {
        // executed when build success
    }
    always {
        // always executed regardless of build failure/success
    }
    failure {
        // executed when build failure
    }
}