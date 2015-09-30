class BookAuthor {
    String authorName
}
class Book1 {
    @Delegate BookAuthor author
    String title
}
def author = new BookAuthor(authorName: 'vishal')
def book = new Book1 (title: 'Beginning Groovy,Grails and Griffon', author: author)
assert book.title == 'Beginning Groovy,Grails and Griffon'
assert book.authorName == 'vishal'
println "Book title: ${book.title}"
println "Book author name: ${book.authorName}"
