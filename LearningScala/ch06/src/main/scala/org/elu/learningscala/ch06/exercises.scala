// 1. Create a list of the first 20 odd Long numbers. Can you create this with a for-loop, with the
// filter operation, and with the map operation? What’s the most efficient and expressive way to
// write this?
for (i <- 1 to 20 if (i % 2) == 1) yield i

(1 to 20).filter(_ % 2 == 1)

(1 to 20).map {
  case x if x % 2 == 1 => x
  case _ =>
}

// 2. Write a function titled “factors” that takes a number and returns a list of its factors, other
// than 1 and the number itself. For example, factors(15) should return List(3, 5).
// Then write a new function that applies “factors” to a list of numbers. Try using the list of Long
// numbers you generated in exercise 1. For example, executing this function with
// List(9, 11, 13, 15) should return List(3, 3, 5), because the factor of 9 is 3 while the factors
// of 15 are 3 again and 5. Is this a good place to use map and flatten? Or would a for-loop be a
// better fit?

// 3. Write a function, first[A](items: List[A], count: Int): List[A], that returns the first x
// number of items in a given list. For example, first(List('a','t','o'), 2) should return
// List('a','t'). You could make this a one-liner by invoking one of the built-in list operations
// that already performs this task, or (preferably) implement your own solution. Can you do so with
// a for-loop? With foldLeft? With a recursive function that only accesses head and tail?

// 4. Write a function that takes a list of strings and returns the longest string in the list. Can
// you avoid using mutable variables here? This is an excellent candidate for the list-folding
// operations (Table 6-5) we studied. Can you implement this with both fold and reduce? Would your
// function be more useful if it took a function parameter that compared two strings and returned
// the preferred one? How about if this function was applicable to generic lists, i.e., lists of
// any type?

// 5. Write a function that reverse s a list. Can you write this as a recursive function? This may
// be a good place for a match expression.

// 6. Write a function that takes a List[String] and returns a (List[String],List[String]), a tuple
// of string lists. The first list should be items in the original list that are palindromes
// (written the same forward and backward, like “racecar”). The second list in the tuple should be
// all of the remaining items from the original list. You can implement this easily with partition,
// but are there other operations you could use instead?

// 7. The last exercise in this chapter is a multipart problem. We’ll be reading and processing a
// forecast from the excellent and free OpenWeatherMap API.
// To read content from the URL we’ll use the Scala library operation
// io.Source.+fromURL(url: String), which returns an +io.Source instance. Then we’ll reduce the
// source to a collection of individual lines using the getLines.toList operation. Here is an
// example of using io.Source to read content from a URL, separate it into lines, and return the
// result as a list of strings:
//   scala> val l: List[String] = io.Source.fromURL(url).getLines.toList
// Here is the URL we will use to retrieve the weather forecast, in XML format:
//   scala> val url = "http://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0"
// Go ahead and read this URL into a list of strings. Once you have it, print out the first line to
// verify you’ve captured an XML file. The result should look pretty much like this:
//    scala> println( l(0) )
//    <?xml version="1.0" encoding="utf-8"?>
// If you don’t see an XML header, make sure that your URL is correct and your Internet connection
// is up.
// Let’s begin working with this List[String] containing the XML document.
// a. To make doubly sure we have the right content, print out the top 10 lines of the file. This
// should be a one-liner.
// b. The forecast’s city’s name is there in the first 10 lines. Grab it from the correct line and
// print out its XML element. Then extract the city name and country code from their XML elements
// and print them out together (e.g., “Paris, FR”). This is a good place to use regular expressions
// to extract the text from XML tags (see “Regular expressions” on page 19).
// If you don’t want to use regular expression capturing groups, you could instead use the
// replaceAll() operation on strings to remove the text surrounding the city name and country name.
// c. How many forecast segments are there? What is the shortest expression you can write to count
// the segments?
// d. The “symbol” XML element in each forecast segment includes a description of the weather
// forecast. Extract this element in the same way you extracted the city name and country code. Try
// iterating through the forecasts, printing out the description.
// Then create an informal weather report by printing out the weather descriptions over the next 12
// hours (not including the XML elements).
// e. Let’s find out what descriptions are used in this forecast. Print a sorted listing of all of
// these descriptions in the forecast, with duplicate entries removed.
// f. These descriptions may be useful later. Included in the “symbol” XML element is an attribute
// containing the symbol number. Create a Map from the symbol number to the description. Verify this
// is accurate by manually accessing symbol values from the forecast and checking that the
// description matches the XML document.
// g. What are the high and low temperatures over the next 24 hours?
// h. What is the average temperature in this weather forecast? You can use the “value” attribute in
// the temperature element to calculate this value.
// Now that you have solved the exercises, are there simpler or shorter solutions than the ones you
// chose? Did you prefer infix dot notation or infix operator notation? Was using for..yield easier
// than higher-order operations like map and filter?
// This is a good place to rework some of your solutions to really find your favored coding style,
// which is often the intersection between ease of writing, ease of reading, and expressiveness.
