pipeline{
    agent any
    parameters {
        // these are the parameters that user should provide while triggering the pipeline
        string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'choices', choices: ['1.1.0', '1.1.1', '1.1.2'])
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages{
        stage("build"){
            steps{
                echo "building the application"
            }
        }
        stage("test"){
            when{
                expression {
                    params.executeTests // this stage executed if executeTests is true
                }
            }
            steps{
                echo "testing the application"
            }
        }
        stage("deploy"){
            steps{
                echo "deploying the application"
                echo "deploying version ${params.VERSION}"
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