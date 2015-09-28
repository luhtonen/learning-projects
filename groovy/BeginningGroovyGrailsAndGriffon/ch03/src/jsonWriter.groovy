import groovy.json.*
def builder = new JsonBuilder()
def root = builder.Book {
    Groovy {
        title: 'Beginning Groovy, Grails and Griffon'
        Authors (
                1: 'Vishal',
                2: 'Chris',
                3: 'Joseph',
                4: 'James'
        )
    }
}
println builder.toString()

println builder.toPrettyString()

// JSON can be read with JsonSlurper