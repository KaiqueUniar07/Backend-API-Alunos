pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK 21', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Clonar Repositório') {
            steps {
                git url: 'https://github.com/KaiqueUniar07/Backend-API-Alunos.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Testes') {
            steps {
                sh './mvnw test'
            }
        }
    }

    post {
        success {
            echo 'Pipeline finalizada com sucesso.'
        }
        failure {
            echo 'Erro na Pipeline.'
        }
    }
}
