package transformations

class Groovy {
    @Lazy authors = ['Vishal', 'Chris', 'James', 'Joseph']
}
def g = new Groovy()
assert g.authors.size() == 4
println g.authors.size()
assert g.dump().contains('Vishal')
println g.dump()
