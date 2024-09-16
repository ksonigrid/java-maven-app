// All environment variables available in Jenkinsfile are available in this file

def BuildJar(){
    echo "building Jar"
    sh "mvn package"
}

def BuildImage(){
    echo "building images"
    withCredentials([usernamePassword(credentialsId: "dockerhub-credential", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh """
            docker build . -t ksonigrid/java-mavenrepo:2.0
            echo ${PASS} | docker login -u ${USER} --password-stdin
            docker push ksonigrid/java-mavenrepo:2.0
        """
    }
}

def DeployApp(){
    echo "deploying the application"
}

return this

