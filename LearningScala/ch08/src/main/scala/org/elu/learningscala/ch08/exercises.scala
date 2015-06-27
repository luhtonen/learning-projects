// Exercises
// 1. We’re working on a gaming site, and need to track popular consoles like the Xbox Two and
// Playstation 5 (I’m planning for the future here).
//   a. Create a console class that can track the make, model, debut date, WiFi type, physical media
//      formats supported, and maximum video resolution. Override the default toString method to
//      print a reasonably sized description of the instance (< 120 chars).
//      • The debut date (or launch date) should be an instance of java.util.Date.
//      • Keep the WiFi type (b/g, b/g/n, etc.) field optional, in case some consoles don’t have
//        WiFi.
//      • The physical media formats should be a list. Is a String the best be there, or an Int that
//        matches a constant value?
//      • The maximum video resolution should be in a format that would make it possible to sort
//        consoles in order of greatest number of pixels.
//   b. Test your new console class by writing a new class that creates four instances of this
//      console class. All of the instances should have reasonably accurate values.
//   c. Now it’s time for games. Create a game class that includes the name, maker, and a list of
//      consoles it supports, plus an “isSupported” method that returns true if a given console is
//      supported.
//   d. Test out this game class by generating a list of games, each containing one or more
//      instances of consoles. Can you convert this list to a lookup table for consoles with a list
//      of supported games? How about a function that prints a list of the games, sorted first by
//      maker and then by game name?

// 2. Create a linked list, object-oriented-style.
//   a. Create a container class that has an instance of itself plus an instance of a parameterized
//      type. The constructor should take a variable number of the instances (e.g., strings or ints
//      or any other parameterized type), which can be implemented with vararg parameters
//      (see “Vararg Parameters” on page 54). Implement a “foreach” method that users can call to
//      iterate over the list, invoking their function for every element.
//      • How will you determine the end of the list?
//      • C-style lists often use a null value to denote the end of the list. Is that the best
//        approach here?
//      • Do you have a good use for the apply() method here?
//   b. I’m sure your linked list works great, but let’s try refactoring it with a more interesting
//      approach. Make your container class abstract with two subclasses: one representing a node
//      with a valid item and one representing a node without a valid item, signifying the last item
//      in the list.
//      • Will you ever need more than one instance of the second subclass?
//      • Are there any helper methods that should be private?
//      • How about abstract methods that the subclasses will need to implement?
//      • If you implemented the apply() method, should each subclass have its own implementation?
//   c. Add the standard head, tail, filter, size, and map collection methods for your linked list.
//      Can you implement any of these using lazy values? Which of these should be implemented in
//      the parent class versus being implemented in its sub‐ classes?
//   d. Implement the head, tail, filter, size, and map collection methods using recursion instead
//      of iteration. Can you ensure these all use tail recursion (see “Recursive Functions” on
//      page 50) to prevent stack overflow errors for massive collections?

// 3. For a change of pace, let’s create a directory listing class. The constructor fields should be
// the full path to the directory and a predicate function that takes a String (the filename) and
// returns true if the file should be included. The method “list” should then list the files in the
// directory.
// To implement this, create an instance of java.io.File and use its
// listFiles(filter: FilenameFilter) to list files that match the given filter. You’ll find Javadocs
// for this method and for the java.io.FilenameFilter class, but you will need to figure out how
// this would be called from Scala. You should pass in the Filename Filter argument as an anonymous
// class.
// • Is there any part of this class that would work well as a lazy value?
// • Would it make sense to store the anonymous subclass of
//   java.io.FilenameFilter as a lazy val?
// • How about the filtered directory listing?

// 4. The JVM library includes a working MIDI sound synthesizer. Here’s an example of playing a
// short set of notes:
//   scala> val synth = javax.sound.midi.MidiSystem.getSynthesizer
//   synth: javax.sound.midi.Synthesizer = com.sun.media.sound
//     .SoftSynthesizer@283a8ad6
//   scala> synth.open()
//   scala> val channel = synth.getChannels.head
//   channel: javax.sound.midi.MidiChannel = com.sun.media.sound
//     .SoftChannelProxy@606d6d2c
//   scala> channel.noteOn(50, 80); Thread.sleep(250); channel.noteOff(30)
//   scala> synth.close()
// Create a simpler interface to this by writing a class that plays a series of notes. The class’s
// constructor should take the volume (set to 80 in the example) but always use the same duration
// (250 milliseconds in the example). Its “play” method should take a list of the notes, for example
// Seq(30, 35, 40, 45, 50, 55, 60, 65, 70), and play them in the synthesizer.
// • Assume the getSynthesizer method call is expensive. How can you prevent unnecessarily calling
//   it in case the “play” method is never called?
// • Make sure to hide fields that callers don’t need to know about.
// • Can you support a Range as input, e.g., play(30 to 70 by 5) ?
// • Can you support multiple ranges, for example a series of notes that rise, fall, and then rise
//   again?
// • Assume we only ever need one instance, ever, with the volume set to 95. Can you use access
//   controls to ensure that there will never be more than one instance of this class?
