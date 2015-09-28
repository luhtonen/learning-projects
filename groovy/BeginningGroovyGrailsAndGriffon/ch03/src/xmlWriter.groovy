import groovy.xml.MarkupBuilder

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.setDoubleQuotes(true)
builder.todos {
    todo(id: "1") {
        name "Buy Beginning Groovy, Grails and Griffon"
        note "Purchase book from Amazon.com for all co-workers."
    }
}
println writer.toString()