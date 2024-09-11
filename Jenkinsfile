CODE_CHANGES = getGitChanges()
pipeline{
    agent any
    environment { // define environment variables like this
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages{
        stage("build"){
            steps{
                echo "building the application"
                echo "building version ${NEW_VERSION}"
            }
        }
        stage("test"){
            when { // just like if else
            // this stage only executed if current branch is "dev"
                expression {
                    BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                }
            }
            steps{
                echo "testing the application"
            }
        }
        stage("deploy"){
            steps{
                echo "deploying the application"
                withCredentials([
                    usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD) // limited to this scope username & password will
                    // will be stored in USER & PWD variable
                ]) {
                        sh "some script ${USER} ${PWD}"
                }
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