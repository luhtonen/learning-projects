package org.elu.grailsinaction.hubbub

class Profile {
    byte[] photo
    String fullName
    String bio
    String homepage
    String email
    String timezone
    String country
    String jabberAddress

    static belongsTo = [ user: User ]

    static constraints = {
        fullName blank: false
        bio nullable: true, maxSize: 1000
        homepage url: true, nullable: true
        email email: true, blank: false
        photo nullable: true, maxSize: 2 * 1024 * 1024 // 2M
        country nullable: true
        timezone nullable: true
        jabberAddress email: true, nullable: true
    }

    String toString() {
        "Profile of $fullName (id: $id)"
    }

    String getDisplayString() {
        fullName
    }
}
