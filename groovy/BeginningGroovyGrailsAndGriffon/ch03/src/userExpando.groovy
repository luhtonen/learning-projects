def user = new Expando()
user.firstName = 'Christopher'
user.lastName = 'Judd'
user.greeting = { greeting ->
    "${greeting} ${firstName} ${lastName}"
}

assert user.greeting('Hello') == 'Hello Christopher Judd'
println user.greeting('Hello')