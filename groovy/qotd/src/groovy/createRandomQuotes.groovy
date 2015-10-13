/** Created by luhtonen on 13/10/15. */
def authors = [
        "Peter Ledbrook",
        "Glen Smith"
]

def quoteParts = [
        ["Time", "waits", "for no man"],
        ["The roundhouse kick", "solves", "all problems"],
        ["Groovy", "is", "the bees knees"]
]

for (int i in 0..<10) {
    def quote = createQuote(quoteParts, authors)
    println quote
}

for (int i in 0..<10) {
    def quote = createQuote(quoteParts, authors)
    println quote

    def pigLatinWords = []
    for (String word in quote.split(/\s+/)) {
        pigLatinWords << pigLatinize(word)
    }

    println pigLatinWords.join(' ')
}

String createQuote(List quoteParts, List authors) {
    def rand = new Random()
    def n = quoteParts.size()
    def m = authors.size()
    return quoteParts[rand.nextInt(n)][0] + ' ' +
            quoteParts[rand.nextInt(n)][1] + ' ' +
            quoteParts[rand.nextInt(n)][2] + ' by ' +
            authors[rand.nextInt(m)]
}

def pigLatinize(String word) {
    if (isVowel(word[0])) {
        return word + "way"
    } else {
        def pos = firstVowel(word)
        return word[pos..-1] + word[0..<pos] + "ay"
    }
}

def firstVowel(String word) {
    for (int i in 0..<word.size()) {
        if (isVowel(word[i])) return i
    }
    return -1
}

def isVowel(String ch) {
    return ch.toLowerCase() in ["a", "e", "i", "o", "u"]
}