pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Aymen322/taskapplication'
            }
        }

        stage('Build') {
            steps {
                powershell 'mvn clean package -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                powershell 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo "Build and tests succeeded!"
        }
        failure {
            echo "Build or tests failed!"
        }
    }
}
