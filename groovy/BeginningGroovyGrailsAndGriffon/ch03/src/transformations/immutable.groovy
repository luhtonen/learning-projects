package transformations

import groovy.transform.Immutable

@Immutable
class Book1 {
    String title
    Collection authors
}

def book1 = new Book1(title: 'Beginning Groovy, Grails and Griffon', authors: ['Vishal', 'Chris', 'James', 'Joseph'])
def book2 = new Book1('Beginning Groovy, Grails and Griffon', ['Vishal', 'Chris', 'James', 'Joseph'])
assert book1 == book2
println "book1 == book2 is ${book1 == book2}"
