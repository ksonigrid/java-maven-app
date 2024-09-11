// All environment variables available in Jenkinsfile are available in this file

def BuildJar(){
    echo "building Jar"
    sh "mvn package"
}

def BuildImage(){
    echo "building images"
    withCredentials([usernamePassword(credentialsId: "Dockerhub PAT for jenkins", paswordVariable: 

        sh('docker build . -t ksonigrid/java-mavenrepo:2.0')
        sh('echo ${PASS} | docker login -u ${USER} --password-stdin')
        sh('docker push ksonigrid/java-mavenrepo:2.0')
        
        
    )])
    

}

def DeployApp(){
    echo "deploying the application"
}

return this

