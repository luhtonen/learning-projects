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