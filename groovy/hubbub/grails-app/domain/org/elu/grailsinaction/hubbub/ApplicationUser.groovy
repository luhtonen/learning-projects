package org.elu.grailsinaction.hubbub

class ApplicationUser {

    String applicationName
    String password
    String apiKey

    static constraints = {
        importFrom User, include: ['password']

        applicationName blank: false, unique: true
        apiKey blank: false
    }
}
