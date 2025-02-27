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
                                    tools: [[parser: 'JACOCO']],
                                            id: 'jacoco', name: 'JaCoCo Coverage',
                                            sourceCodeRetention: 'EVERY_BUILD',
                                            qualityGates: [
                                                    [threshold: 60.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                                                    [threshold: 60.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]]
                                )
            }
        }
    }
}