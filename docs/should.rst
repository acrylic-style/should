####
Should class
####

****
Fields
****

Private fields
====
These fields are private and cannot be accessed without reflection.

o: Object
----
A field to hold object that being evaluated.

invert: boolean
----
Does invert evaluation or not.

Chaining fields
====
These fields are simple chaining to improve readability. Does nothing.

 * an
 * of
 * a
 * and
 * been
 * with
 * should

****
Static Methods
****
These methods are static and can be accessed directly without using constructor.

object(T): Should<T>
====
Initializes should object. It's exactly same as calling constructor.

map(Map<K, V>): Should<Map<K, V>>
====
This method exists to improve readability. Does same as object(T).

list(List<T>): Should<List<T>>
====
This method exists to improve readability. Does same as object(T).

objectNoType(Object): Should<Object>
====
Initializes should object with Object type. (Disables compile-time type check)

****
Methods
****
These methods are public and can be accessed using should instance.

must: Must<T>
====
object(null).must()

not: Should<T>
====
Inverts current evaluation.

shouldNot: Should<T>
====
Inverts current evaluation.

shouldnt: Should<T>
====
Inverts current evaluation.

exactly: Must<T>
====
Returns Must<T> object that matches exactly when using Must#sameAs.

be: Must<T>
====
object(null).should.be()

ok: Must<T>
====
Simple alias to Must#ok.

true\_: Must<T>
====
Simple alias to Must#true_.

false\_: Must<T>
====
Simple alias to Must#false_.

have: Have<T>
====
object(null).should.have()

has: Have<T>
====
object(null).should.has()

exist: Should<T>
====
Returns null if object is null.
Returns new instance if object is null but inverted.

startsWith(String): Should<T>
====
Checks if the string starts with specified string.
Returns null if object isn't string or does not starts with specified string.

endsWith(String): Should<T>
====
Checks if the string ends with specified string.
Returns null if object isn't string or does not ends with specified string.
