package org.elu.grailsinaction.hubbub

class Tag {

    String name
    User user

    static constraints = {
        name blank: false
    }

    static hasMany = [ posts: Post ]
    static belongsTo = [ User, Post ]
}
