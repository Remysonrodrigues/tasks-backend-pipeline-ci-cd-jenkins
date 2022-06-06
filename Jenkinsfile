pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                sh 'mvn clean package -DskipTest=true'
            }
        }
        stage ('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8002/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        stage ('Deploy Prod') {
            steps {
                sh 'docker-compose build'
                sh 'docker-compose up -d'
            }
        }
    }
    post {
        always {
           junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
        unsuccessful {
            emailext: attachLog: true, body: 'See the attached log below', subject: 'Build $BUILD_NUMBER has failed', to: 'remyson@gmail.com'
        }
        fixed {
            emailext: attachLog: true, body: 'See the attached log below', subject: 'Build is fine!!', to: 'remyson@gmail.com'
        }
    }
}