package org.elu.grailsinaction.hubbub

import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    static scaffold = true

    def search() {}

    def results(String loginId) {
        def users = User.where {
            loginId =~ "%${loginId}%"
        }.list()
        return [users     : users,
                term      : params.loginId,
                totalUsers: User.count()]
    }

    def advSearch() {}

    def advResults() {
        def profileProps = Profile.metaClass.properties*.name

        def profiles = Profile.withCriteria {
            "${params.queryType}" {
                params.each { field, value ->
                    if (profileProps.contains(field) && value) {
                        ilike field, "%${value}%"
                    }
                }
            }
        }
        [ profiles: profiles ]
    }

    def register() {
        if (request.method == 'POST') {
            def user = new User(params)
            if (user.validate()) {
                user.save()
                flash.message = 'Successfully created user'
                redirect(uri: '/')
            } else {
                flash.message = 'Error registering user'
                return [ user: user ]
            }
        }
    }
}
