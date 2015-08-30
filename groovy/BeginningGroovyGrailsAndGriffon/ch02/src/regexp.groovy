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

// uses of regular expressions
def phoneValidation = /^[01]?\s*[\(\.-]?(\d{3})[\)\.-]?\s*(\d{3})[\.-](\d{4})$/
assert '(800)555-1212' ==~ phoneValidation
assert '1(800) 555-1212' ==~ phoneValidation
assert '1-800-555-1212' ==~ phoneValidation
assert '1.800.555.1212' ==~ phoneValidation

class Phone {
    String areaCode
    String exchange
    String local
}
def phoneStr = '(800)555-1212'
def phonePattern = ~/^[01]?\s*[\(\.-]?(\d{3})[\)\.-]?\s*(\d{3})[\.-](\d{4})$/
def phoneMatcher = phonePattern.matcher(phoneStr)
def phone = new Phone(
        areaCode: phoneMatcher[0][1],
        exchange: phoneMatcher[0][2],
        local: phoneMatcher[0][3])
println "Original Phone Number: $phoneStr"
println """Parsed Phone Number\
\n\tArea Code = ${phone.areaCode}\
\n\tExchange = ${phone.exchange}\
\n\tLocal = ${phone.local}"""
