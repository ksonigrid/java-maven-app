// All environment variables available in Jenkinsfile are available in this file

def BuildApp(){
    echo "buiding the application"
}

def TestApp(){
    echo "testing the application"
}

def DeployApp(){
    echo "deploying the application"
    echo "version of the application ${params.VERSION}"
}

return this

