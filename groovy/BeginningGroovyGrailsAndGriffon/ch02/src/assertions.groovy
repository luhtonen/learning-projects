/** Created by luhtonen on 28/08/15. */

assert 1==2 : "One isn't Two"
// One isn't Two. Expression: (1 == 2)

assert new File("HelloWorld.txt") == new File("Hello.txt")
//assert new File("HelloWorld.txt") == new File("Hello.txt")
//       |                          |  |
//       HelloWorld.txt             |  Hello.txt
//                                  false
