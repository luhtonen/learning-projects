/** Created by luhtonen on 30/08/15. */
// Match operation
assert "abc" ==~ 'abc'
assert "abc" ==~ /abc/
// assert "abcabc" ==~ /abc/ // assertion fails
assert "abc" ==~ /^a.c/
assert "abc" ==~ /^a../
assert "abc" ==~ /.*c$/
assert "abc" ==~ '.*c\$'

// 