pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2"
    }

    stages {
        stage('Preparation') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/nicks204/Phase5_Aug22.git'
            }
        }
        stage('Build') {
            steps {
                bat "mvn clean test"
            }
        }
               
    }
}