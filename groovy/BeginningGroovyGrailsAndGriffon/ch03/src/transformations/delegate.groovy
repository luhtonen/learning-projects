package transformations

class Author {
    String authorName
}
class Book {
    @Delegate Author author
    String title
}
def author = new Author(authorName: 'vishal')
def book = new Book (title: 'Beginning Groovy,Grails and Griffon', author: author)
assert book.title == 'Beginning Groovy,Grails and Griffon'
assert book.authorName == 'vishal'
println "Book title: ${book.title}"
println "Book author name: ${book.authorName}"
