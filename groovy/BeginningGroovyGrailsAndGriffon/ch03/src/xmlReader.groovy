def todos = new XmlSlurper().parse('./todos.xml')
assert 1 == todos.todo.size()
println "todos.todo.size() ${todos.todo.size()}"
assert "Buy Beginning Groovy, Grails and Griffon" == todos.todo[0].name.text()
println "todos.todo[0].name.text() ${todos.todo[0].name.text()}"
assert "1" == todos.todo[0].@id.text()
println "todos.todo[0].@id.text() ${todos.todo[0].@id.text()}"
