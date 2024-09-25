// All environment variables available in Jenkinsfile are available in this file
def increment_version() {
    echo "incrementing the application version....."
    sh '
        mvn build-helper:parse-version versions:set \
        -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion} versions:commit'
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
}
def BuildJar(){
    echo "building Jar"
    sh "mvn clean package"
}

def BuildImage(){
    echo "building images"
    withCredentials([usernamePassword(credentialsId: "dockerhub-credential", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh """
            docker build . -t ksonigrid/java-mavenrepo:${IMAGE_NAME}
            echo ${PASS} | docker login -u ${USER} --password-stdin
            docker push ksonigrid/java-mavenrepo:${IMAGE_NAME}
        """
    }
}

def DeployApp(){
    echo "deploying the application"
}

return this

