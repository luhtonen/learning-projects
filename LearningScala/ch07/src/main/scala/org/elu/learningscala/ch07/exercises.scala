// Exercises
// ---------
// 1. The Fibonacci series starts with the numbers “1, 1” and then computes each successive element
// as the sum of the previous two elements. We’ll use this series to get familiarized with the
// collections in this chapter.
//   a. Write a function that returns a list of the first x elements in the Fibonacci series. Can
//      you write this with a Buffer? Would a Builder be appropriate here?
//   b. Write a new Fibonacci function that adds new Fibonacci numbers to an existing list of
//      numbers. It should take a list of numbers (List[Int]) and the count of new elements to add
//      and return a new list (List[Int]). Although the input list and returned lists are
//      immutable, you should be able to use a mutable list inside your function. Can you also
//      write this function using only immutable lists? Which version, using mutable versus
//      immutable collections, is more appropriate and readable?
//   c. The Stream collection is a great solution for creating a Fibonacci series. Create a stream
//      that will generate a Fibonacci series. Use it to print out the first 100 elements in the
//      series, in a formatted report of 10 comma-delimited elements per line.
//   d. Write a function that takes an element in the Fibonacci series and returns the following
//      element in the series. For example, fibNext(8) should return 13. How will you handle invalid
//      input such as fixNext(9)? What are your options for conveying the lack of a return value to
//      callers?

// 2. In the example for Array collections (see “Arrays” on page 112) we used the
// java.io.File(<path>).listFiles operation to return an array of files in the current directory.
// Write a function that does the same thing for a directory, and converts each entry into its
// String representation using the toString method. Filter out any dot-files (files that begin with
// the . character) and print the rest of the files separated by a semicolon (;). Test this out in
// a directory on your computer that has a significant number of files.

// 3. Take the file listing from exercise 2 and print a report showing each letter in the alphabet
// followed by the number of files that start with that letter.

// 4. Write a function to return the product of two numbers that are each specified as a String,
// not a numeric type. Will you support both integers and floating-point numbers? How will you
// convey if either or both of the inputs are invalid? Can you handle the converted numbers using a
// match expression? How about with a for-loop?

// 5. Write a function to safely wrap calls to the JVM library method System.getProperty(<String>),
// avoiding raised exceptions or null results. System.getProperty(<String>) returns a JVM
// environment property value given the property’s name. For example,
// System.getProperty("java.home") will return the path to the currently running Java instance,
// while System.getProperty("user.timezone") returns the time zone property from the operating
// system. This method can be dangerous to use, however, because it may throw exceptions or return
// null for invalid inputs. Try invoking System.getProperty("") or System.getProperty("blah") from
// the Scala REPL to see how it responds.
// Experienced Scala developers build their own libraries of functions that wrap unsafe code with
// Scala’s monadic collections. Your function should simply pass its input to the method and ensure
// that exceptions and null values are safely handled and filtered. Call your function with the
// example property names used here, including the valid and invalid ones, to verify that it never
// raises exceptions or returns null results.

// 6. Write a function that reports recent GitHub commits for a project. GitHub provides an RSS feed
// of recent commits for a given user, repository, and branch, containing XML that you can parse out
// with regular expressions. Your function should take the user, repository, and branch, read and
// parse the RSS feed, and then print out the commit information. This should include the date,
// title, and author of each commit.
// You can use the following RSS URL to retrieve recent commits for a given repository and branch:
//   https://github.com/<user name>/<repo name>/commits/<branch name>.atom
// Here is one way to grab the RSS feed as a single string:
//   scala> val u = "https://github.com/scala/scala/commits/2.11.x.atom"
//   u: String = https://github.com/scala/scala/commits/2.11.x.atom
//   scala> val s = io.Source.fromURL(u)
//   s: scala.io.BufferedSource = non-empty iterator
//   scala> val text = s.getLines.map(_.trim).mkString("")
//   text: String = <?xml version="1.0" encoding="UTF-8"?><feed xmlns=...
// Working with the XML will be a bit tricky. You may want to use text.split(<to ken>) to split the
// text into the separate <entry> components, and then use regular expression capture groups (see
// “Regular expressions” on page 19) to parse out the <title> and other elements. You could also
// just try iterating through all the lines of the XML file, adding elements to a buffer as you find
// them, and then converting that to a new list.
// Once you have completed this exercise (and there is a lot to do here), here are some additional
// features worth investigating:
//   a. Move the user, repo, and branch parameters into a tuple parameter.
//   b. Following exercise (a), have the function take a list of GitHub projects and print a report
//      of each one’s commits, in order of specified project.
//   c. Following exercise (b), retrieve all of the projects, commit data concurrently using
//      futures, await the result (no more than 5 seconds), and then print a commit report for each
//      project, in order of project specified.
//   d. Following exercise (c), mix the commits together and sort by commit date,then print your
//      report with an additional “repo” column.
//   These additional features will take some time to implement, but are definitely worthwhile for
//   learning and improving your Scala development skills.
//   Once you have finished these features, test out your commit report using entries from the
//   following projects:
//     https://github.com/akka/akka/tree/master
//     https://github.com/scala/scala/tree/2.11.x
//     https://github.com/sbt/sbt/tree/0.13
//     https://github.com/scalaz/scalaz/tree/series/7.2.x
//   These features are all active (as of 2014), so you should see an interesting mix of commit
//   activity data in your report. It’s worthwhile to browse the repositories for these core open
//   source Scala projects, or at least their documentation, to understand some of the excellent
//   work being done.

// 7. Write a command-line script to call your GitHub commit report function from exercise 6 and
// print out the results. This will require a Unix shell; if you are on a Windows system you will
// need a compatible Unix environment such as Cygwin or Virtualbox (running a Unix virtual machine).
// You’ll also need to install SBT (Simple Build Tool), a build tool that supports dependency
// management and plug-ins and is commonly used by Scala projects. You can download SBT from
// http://www.scala- sbt.org/ for any environment, including an MSI Windows Installer version.
// SBT is also available from popular package managers. If you are using Homebrew on OS X you can
// install it with brew install sbt.
// Here is an example SBT-based Scala script that reads the command-line arguments as a List and
// prints a greeting. The comment block starting with triple asterisks is reserved for SBT settings.
// In this script we are specifying that we want version 2.11.1 of the Scala language to be used:
// #!/usr/bin/env sbt -Dsbt.main.class=sbt.ScriptMain
// /***
//   scalaVersion := "2.11.1"
// */
// def greet(name: String): String = s"Hello, $name!"
// // Entry point for our script
// args.toList match {
//   case List(name) => {
//     val greeting = greet(name)
//     println(greeting)
//   }
//   case _ =>
//     println("usage: HelloScript.scala <name>")
// }
// Copy this into a file titled HelloScript.scala, and change the permissions to be exe‐ cutable (chmod a+x HelloScript.scala in a Unix environment). Then you can run the script directly:
//   $ ./HelloScript.scala Jason
//   [info] Set current project to root-4926629s8acd7bce0b (in
//   build file:/Users/jason/.sbt/boot/4926629s8acd7bce0b/)
//   Hello, Jason!
// Your commit report script will need to take multiple GitHub projects as arguments. To keep the
// arguments concise, you may want to combine each project’s input into a single string to be
// parsed, such as scala/scala/2.11.x.
// The printout should be clean, well-formatted, and easily readable. Using fixed column widths
// could help, using the printf-style formatting codes in string interpolation
// (see “String interpolation” on page 18).
