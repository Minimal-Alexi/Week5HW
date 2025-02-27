pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Minimal-Alexi/Week5HW.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                    recordCoverage(
                                    tool: 'JaCoCo', // Use the configured JaCoCo tool
                                    execPattern: '**/target/jacoco.exec', // Path to the JaCoCo execution data
                                    classPattern: '**/target/classes',   // Path to the compiled classes
                                    sourcePattern: '**/src/main/java'    // Path to the source code
                                )
            }
        }
    }
}