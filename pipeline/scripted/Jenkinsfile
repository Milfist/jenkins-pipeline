@Library('jenkins-pipeline')_
import com.cleverbuilder.GlobalVars

pipeline {
    
    agent any
    
    parameters {
        string(name: 'email', defaultValue: 'miguel.anguita@gft.com', description: 'Direcciones de correo para las alertas')

        booleanParam(name: 'Sonar', defaultValue: true, description: 'Se debe ejecutar Sonar.')
        
        booleanParam(name: 'Nexus', defaultValue: true, description: 'El artefacto debe subir a Nexus.')

        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
    }
    
    stages {
        stage('Demo') {
            steps {
                echo '\033[31mHello World\033[0m'
            
                sayHello 'Dave'
          
                sayHello GlobalVars.foo
            }
        }
        
        stage("SonarQuBe Analysis") {
            steps {
                sonarQuBeAnalysis(Sonar)
            }
        }
          
        stage("Uploading to Nexus") {
            steps {
                script {
                    if (Nexus.toBoolean()) {
                        echo ' =========== ^^^^^^^^^^^^ Subiendo a Nexus...'
                    } else {
                        echo ' =========== ^^^^^^^^^^^^ Pasando de subir a Nexus...'    
                    }
                }     
            }
        }  
    }
    post {
        always {
            echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeeded!'
            echo 'Enviando email a: ' + email
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo '\033[31mI failed :(\033[0m'
            echo 'Enviando email a: ' + email
            //mail to: 'miguel.anguita@gft.com',
                //subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                //body: "Something is wrong with ${env.BUILD_URL}"
        }
        changed {
            echo 'Things were different before...'
        }
    }
}
