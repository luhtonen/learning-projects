package org.elu.grailsinaction.hubbub

class Post {

    String content
    Date dateCreated

    static belongsTo = [user: User]

    static constraints = {
        content blank: false
    }

    static mapping = {
        sort dateCreated: 'desc'
    }
}
