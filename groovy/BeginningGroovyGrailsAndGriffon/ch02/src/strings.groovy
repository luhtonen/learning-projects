/** Created by luhtonen on 28/08/15. */

// Java String
String name = "Jim";
String helloName = "Hello " + name;
System.out.println(helloName);

// Groovy GString
str1 = "Jim"
str2 = "Hello "
println "$str2$str1"

s1 = 'Hello $name'
println s1

s1 = 'hello "edu"'
println s1

name = "Jim"
def multiLineQuote = """
Hello, ${name}
This is a multiline string with double quotes
"""
println multiLineQuote
println multiLineQuote.class.name

def multiLineSingleQuote = '''
Hello, ${name}
This is a multiline string with single quotes
'''
println multiLineSingleQuote
println multiLineSingleQuote.class.name

def winpathQuoted = 'C:\\windows\\system32'
def winpathSlashy = /C:\windows\system32/
println winpathQuoted
println winpathSlashy
assert winpathSlashy ==~ '\\w{1}:\\\\.+\\\\.+'
assert winpathSlashy ==~ /\w{1}:\\.+\\.+/

def path = "c:/groovy"
def multilineSlashy = /
    Hello $name
    path = $path
    dollar = $
    path = c:\/groovy
/
println multilineSlashy

def dollarSlashy = $/
    Hello $name
    path = $path
    dollar = $$test
    path = c:/groovy
/$
println dollarSlashy
