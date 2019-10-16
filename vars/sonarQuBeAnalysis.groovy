// vars/sonarQuBeAnalysis.groovy

def call(Boolean sonar = true) {
    if (sonar.toBoolean()) {
        echo ' =========== ^^^^^^^^^^^^ Pasando Sonar...'
    } else {
        echo ' =========== ^^^^^^^^^^^^ Pasando del Sonar...'
    }
}
