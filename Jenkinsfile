pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat 'mvn clean test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Build') {
            steps {
                bat 'mvn package -DskipTests'
            }

            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t fibonacci-app:latest .'
            }
        }

        stage('Verify Docker Image') {
            steps {
                bat 'docker images fibonacci-app'
            }
        }
    }
}