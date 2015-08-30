/** Created by luhtonen on 30/08/15. */
// Match operation
assert "abc" ==~ 'abc'
assert "abc" ==~ /abc/
// assert "abcabc" ==~ /abc/ // assertion fails
assert "abc" ==~ /^a.c/
assert "abc" ==~ /^a../
assert "abc" ==~ /.*c$/
assert "abc" ==~ '.*c\$'

// Find operation
def winpath=/C:\windows\system32\somedir/
def matcher = winpath =~ /(\w{1}):\\(\w+)\\(\w+)\\(\w+)/
println matcher
println matcher[0]
println matcher[0][1]
def newPath = matcher.replaceFirst('/etc/bin')
println newPath

// Pattern operation
def saying = """Now is the time for all good men (and women) to come to the aid
of their country"""
def pattern = ~/(\w+en)/
matcher = pattern.matcher(saying)
def count = matcher.count
println "Matches = ${count}"
for (i in 0..<count) {
    println matcher[i]
}
