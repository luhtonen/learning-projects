package transformations

@Newify rubyLikeNew() {
    assert Integer.new(42) == 42
}
rubyLikeNew()

class Tree {
    def elements
    Tree(Object... elements) { this.elements = elements as List }
}
class Leaf {
    def value
    Leaf(value) { this.value = value }
}
def printTree(Tree tree, String prefix) {
    println "${prefix}Tree"
    prefix += "\t"
    tree.elements.each { it ->
        if (it instanceof Leaf) println "${prefix}Leaf: ${it.value}"
        else printTree it, prefix
    }
}
def buildTree() {
    new Tree(new Tree(new Leaf(1), new Leaf(2)), new Leaf(3))
}
def tree1 = buildTree()
printTree tree1, ''

@Newify([Tree, Leaf]) buildNewTree() {
    Tree(Tree(Leaf(1), Leaf(2)), Leaf(3))
}
def tree2 = buildNewTree()
printTree(tree2, '')