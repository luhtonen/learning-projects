package org.elu.grailsinaction.hubbub

class User {

    String loginId
    String password
    String homepage
    Date dateCreated

    static constraints = {
        loginId size: 3..20, unique: true, blank: false
        password size: 6..8, blank: false, validator: { passwd, user ->
            passwd != user.loginId
        }
        homepage url: true, nullable: true
    }
}
