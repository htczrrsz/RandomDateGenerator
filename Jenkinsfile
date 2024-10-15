pipeline {
    agent any
tools {
        maven 'MAVEN_HOME'  // Jenkins'te tanımladığınız Maven ismi
    }
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/htczrrsz/RandomDateGenerator.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test --quiet'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed!'
        }
}
}

