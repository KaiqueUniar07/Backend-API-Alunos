pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/KaiqueUniar07/Backend-API-Alunos.git'
            }
        }
        stage('Build e Testes') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}
