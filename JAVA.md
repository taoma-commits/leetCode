[TOC]
***
## Data types
***
### Primitive data types

* ```byte```: 8-bit signed two's complement integer.

* ```short```: 16-bit signed two's complement integer.

* ```int```: 32-bit signed two's complement integer.

* ```long```: 64-bit signed two's complement integer.

* ```float```: single-precision 32-bit IEEE 754 floating point.

* ```double```: double-precision 64-bit IEEE 754 floating point.

* ```boolean```: 1-bit information

* ```char```: a single 16-bit Unicode character.

### Primitive types and wrappers objects

* Primitive types can never be null. If primitive types are not assigned a value, the language will assign them a default value.
* Wrapper objects are reference types, their default value will be null.
* When a wrapper object get its value modified, the compiler must create a new object and then reassign that object to the original.

* Refer to this [article](https://medium.com/@bpnorlander/java-understanding-primitive-types-and-wrapper-objects-a6798fb2afe9#:~:text=Since%20wrapper%20objects%20are%20reference,assign%20them%20a%20default%20value.).
### Non-primitive data type

#### Mutability

* Mutable data types: StringBuilder, Stack, Counter, Java array
* Immutable data types: String, Integer, Double, Color, Vector, Transaction, Point2D
* **Keys of priority queues and symbol tables should be immutable**.
* The default value of wrapper objects are null.
* Wrapper objects are immutable.
***
## Logic
***
### ```boolean```
* The default ```boolean``` is ```false```.
  - initialize ```boolean[]```, default elements are ```false```.

### Logic operations

* XOR logic operation
exclusive or = addition modulo 2

* Using the bitwise operator can circumvent short-circuiting behavior.

### Bitwise logic operations
- bitwise OR |
- bitwise AND &
- bitwise XOR ^
- bitwise Complement ~

**Examples**
```
a = 5 = 0101
b = 7 = 0111
a | b = 0111 = 7
a & b = 0101 = 5
a ^ b = 0010 = 2
~ a = 1010 = 10
```

**Bitwise XOR properties**
* ```a ^ 0 = a```
* ```a ^ a = 0```
* Commutativity ```a ^ b = b ^ a ```
* Associativity ```(a ^ b) ^ c = a ^ (b ^ c)```

#### Applications

**Bitmask**
A *mask* or *bitmask* is data that is used for bitwise operations, particularly in a bit field.
* masking bits to 1: OR
* masking bits to 0: OR
* querying the status of a bit: AND
* toggling bitwise value: XOR

***
## Numbers
***
### Signed binary numbers

#### One's complement
* negate a number: invert all bits.
* $0$ has tow representations: $0\cdots 0$ and $1\cdots 1$.

>Example. Consider 4-bit numbers for simplicity.
$4 = 0100$, $-4 = 1011$.
The most significant bit represents sign:
$1$ for negative and $0$ for positive.
Max value $= 2^3 - 1$ represented as $0111$.
Min value $= -2^3 + 1$ represented as $1000$.

#### Two's complement
* negative a number: invert all bits and add $1$.
* $0$ has a unique representation: $0\cdots 0$.

>Example. Consider 4-bit numbers for simplicity.
$3 = 0011$, $-3 = 1101$.
Max value $= 2^3 - 1$ represented as $0111$.
Min value $= - 2^3$ represented as $1000$.

***
### Bitwise operators

#### Bitwise logic operators
Let ```a = 5 = 0101(in binary)``` and ```b = 7 = 0111(in binary)```
* Bitwise OR ```|```: ```a | b``` returns ```0111 = 7```.
* Bitwise AND ```&```: ```a & b``` returns ```0101 = 5```.
* Bitwise XOR ```^```: ```a ^ b``` returns ```0010 = 2``` (interpret as the sum without carry).
* Bitwise complement ```~```: ```~a``` returns ```1010 = -6```!!! (two's complement):
  - ```5 = 0...0101``` so the bitwise complement in binary representation is ```1...1010```.
    This is representation of the negative of ```0...0110``` which is ```6```.

#### Shift operators
* Signed right shift ```a >> _```: shifts every bit of a to the right by _ and fills the voids with the previous content of the top bit.
  - ```-10 >> 1 = -5```: ```-10 = 1...10110``` and after shift we get ```1...1011 = - (0...0101) = -5```.
* ```a >> 1 == a / 2```
* Unsigned right shift ```a >>> _```: shifts every bit of a to the right by _ and fills 0 on voids left.
  - ```10 >>> 1 = 5  = 10 >> 1```  
  - ```-10 >>> 1 = 2147483643```: ```-10 = 1...10110``` and after shift
    ```01...1011 = 2^31 - 1 - 4 = 2147483643```.
* Left shift ```a << _```: shifts every bit of a by _ and fills 0 on voids left.
  - ```Integer.MAX_VALUE << 1 = -2```
* ```a << 1 == 2 * a```

***
### ```int```
32-bit signed two's complement integer.
* The default value of ```int``` is 0.
  - initialize ```int[]```, default elements are 0.
  - can NOT initialize ```int ``` without assign value.

* Cast ```int``` to ```char```: ```(char) ('0' + digit)``` ??
* Cast ```int``` to ```String```: ```String.valueOf(digit)```

### ```Integer```
The wrapper class of ```int```.
* ```Integer.valueOf(str)```: convert a string representaion of an integer to ``int```.
* ```Integer.toString(int n)```
* ```Integer.toBinaryString(int n)```
  * ```Integer.toBinaryString(9) = 1001```
* ```Integer.parseInt(String s, int radix)```: parses the string argument as a signed integer in the radix specified in the second argument.
  * ```Integer.parseInt(String s)```: parses the string as a signed decimal integer.

### Class BigInteger

### ```short```
16-bit signed two's complement integer.

### ```long```
64-bit signed two's complement integer.
* suffix for ```long``` type: ```39832L```

### ```float```
single-precision 32-bit IEEE 754 floating point.
* suffix for ```float``` type: ```2.4f```

### ```double```
double-precision 64-bit IEEE 754 floating point.
* suffix for ```double``` type: ```-7.832d```

***

### Arithmetic operations

* modulus: ```a % b == a - (a / b) * b```

  warning: ```-1 % b = -1```. To always get positive remainder, use ```(a % b + b) % b``` instead of ```a % b```.

#### Class Math
* power: ```double Math.power(b, e)``` returns ```double``` to prevent overflow
* square root: ```double Math.sqrt(double a)``` returns the correctly rounded positive square root  of a double value.

***
## Characters and Strings
***

### ```char```

* test whether two characters are equal: ```==``` because ```char``` is primitive data type!

* ```int x = (char) A```,
then x is the ASCII code of character A.
* Get ```int``` value of a decimal digit character by ```int y = x -'0'```
This is because the ASCII codes of characters '0', '1', ..., '9' are ten consecutive numbers in ascending order.
* ```char``` type automatically casted into ```int``` when involved in arithmetic operations and indexing.
An important trick: hash letters to ```int[] hash = new int[26]```
by ```char - 'a'```.
* single quotes ```' '``` define characters. Double quotes ```" "``` define strings!

#### wrapper class ```Character```

* ```isLetter(char ch)``` determines if the specified character is a letter.
* ```isLetterOrDigit(char ch)``` determines if the specified character is a letter or digit.
* ```isLowerCase(char ch)```
* ```isUpperCase(char ch)```
* ```toLowerCase(char c)``` returns ```char```
* ```toUpperCase(char c)``` returns ```char```
* ```toString(char ch)```
* ```isWhitespace(char ch)```

### Strings

* String is **immutable** in Java.

* double quotes ```""``` define strings. Single quotes ```''``` define characters!
* get the character at index i: ```str.charAt(i)```
* get substring: ```str.substring(start_idx, end_idx)```
  - if start_idx == end_idx and both less than or equal to the length of string s, the method returns "".  
* get index of a substring or character:            
  - ```str.indexOf(substr, int fromIndex)```
  - ```str.indexOf(char, int fromIndex)```
  - if such substr or char does not exist, return -1.

* convert a string to array of char's:              ```str.toCharArray()```
* convert an array of char's to a string: ```String str = new String(arr)```
* convert an instance of primitive data type to a string:      
```String.valueOf(Object o)```
where o can be type ```int, long, doulbe, float, char, char[]```
  - ```String.valueOf(char[], int offset, int count)```

* convert ```String``` representation of an integer to the ```int``` value of the integer: ```Integer.valueOf(str)```

* compare two strings:
  - ```(boolean) str1.equals(str2)```
   **Note that ```String``` is non-primitive so ```==``` doesn't work!**
  - String implements comparable interface:
    ```int str1.compareTo(str2)``` compares strings by   lexicographical order. The shorter one of the two strings is padded with zeros at the end.
* split string ```str``` into an array of **strings** (not characters): ```String[] arr = str.split((String)splitter)```
  **Note that two successive splitters create an empty string!**
* find prefix: ```(boolean) (str).startsWith(prefix)```

### String builder

data type: ```StringBuilder```: because String type is immutable, we need StringBuilder to modify a string.

* initialize ```StringBuilder sb = new StringBuilder();```
 - initialize string builder from string: ```StringBuilder sb = new StringBuilder(str);```

* append ```sb.append(char or string)```
* length ```sb.length()```
* insert ```sb.insert(int offset, T t)``` where ```T``` can be any class or primitive type. The string representation of ```t``` is inserted at position ```offset```.
* replace ```sb.replace(int start, int end, String str)```
* to string ```sb.toString()```
* reverse ```sb.reverse()```
* delete a substring ```sb.delete(int start, int end)```
* delete a character ```sb.deleteCharAt(int index)```
* trancate a StringBuilder ```sb.setLength(int len)```

***
## Collections
***
### Array

* Initialize array: ```int[] arr = new int[n]{1,2,3,...,n}```
* Array sorting:
  - ```Arrays.sort(arr, start_idx, end_idx + 1)```
  - ```Arrays.sort(arr, comparator)```
  - One could initialize a Comparator object in the second field of ```Arrays.sort()```
  ```
    Arrays.sort(arr, new Comparator<T>() {
      public int compare(obj_1, obj_2) {
        ...
      }
    })
   ```
* Array slicing:
```int[] slice = Arrays.copyOfRange(arr, start_idx, end_idx)```
* Array filling: ```Arrays.fill(arr, value)```
* Array sum:
    - ```IntStream.of(arr).sum()```
    - ```Arrays.stream(arr).sum()``` overloaded for ```long``` and ```double``` arrays
* Convert array to list: ```Arrays.asList(arr)```




### Collections Framework

#### Class Collections
* ```binarySearch(List<? extends Comparable<? super T>> list, T key)```
  - The list must be sorted into ascending order according to the natural ordering of its elements (as by the sort(List) method) prior to making this call.
  - *insertion point* is defined as the point at which the key would be inserted into the list:
     1. the index of the first element greater than the key,
     2. or list.size() if all elements in the list are less than the key.
  - ```binarySearch(list, key)``` returns - insertion point - 1
     if the key is not in the list.

* ```Collections.swap(list, i, j)```
#### Class Set
A ```Set``` is a ```Collection``` that **cannot contain duplicate elements**.
```Set``` is an interface, can not be instantiated.
* ```HashSet<T>```
* ```LinkedHashSet<T>``` ?
* ```TreeSet<T>``` ?

#### Class List
* append element e to the end:
  ```list.add(E e)```
* insert e at index i: ```list.add(int i, E e)```
  - Shifts the element currently at that position (if any) and any subsequent elements to the right.
* the number of items: ```list.size()```

##### Compare LinkedList and ArrayList
|   | ArrayList | LinkedList |
|:-:|:----------:|:---------:|
|implementation| resize array| doubly linked list|
|manipulation| slow | fast |
|interface| List | List & Deque|
| pro | better for storing | better for manipulation|

##### ArrayList
* initialize an ArrayList: ```new ArrayList(collection)```
* initialize an ArrayList with values:
  - ```new ArrayList<T>(Arrays.aslist(obj 1, obj 2, ...))```
  - ```
    new ArrayList<T>{
      {
        add(obj 1);
        add(obj 2);
      }
    }
    ```
* merge two ArrayLists:
  - ```list1.addAll(list2)```
  - merge without duplicates:
    ```
    Set<T> set = new LinkedHashSet<>(list1);
    set.addAll(list2);
    List<String> combinedList = new ArrayList<>(set);
    ```
* remove object: ```list.remove()```

#### Deque
**Two implementations**
- `ArrayDeque`
  - `null` value not allowed.
- `LinkedList`
  - `null` value is allowed.

**Deque methods**
* initialization:
  - ```new ArrayDeque<E>()```
  - ```new LinkedList<E>()```
* insert:
  - ```addFirst(e)``` or ```offerFirst(e)```
  - ```addLast(e)``` or ```offerLast(e)```

* remove:
  - ```removeFirst(e)``` or ```pollFirst(e)```
  - ```removeLast(e)``` or ```pollLast(e)```
* examine:
  - ```getFirst(e)``` or ```peekFirst(e)```
  -   ```getLast(e)``` or ```peekLast(e)```

#### Priority queue

* The head of this queue is the **least** element with respect to the specified ordering.

* A ```PriorityQueue``` allows **duplicate elements**. If you want to ensure that two identical items are never present in the priority queue at the same time the simplest way would be to maintain a separate ```Set``` in parallel with the priority queue.

##### Initialize a priority queue
* ```PriorityQueue()```
* ```PriorityQueue(Collection<? extends E> c)```
* ```PriorityQueue(int initialCapacity, Comparator<? super E> comparator)```

##### Priority queue methods
* Insert a specific element into the priority queue: ```pq.add(E e)``` or ```pq.offer(E e)```

* Retrieves and removes the head of this queue, or returns null if this queue is empty:	```pq.poll()```
* Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty: ```pq.peek()```
* Returns an array containing all of the elements in this queue: ```pq.toArray()```

#### Map

* search key and value
  - ```map.containsKey(key)```
  - ```map.containsValue(value)```

* set of keys: ```map.keySet()```

* collection of values: ```map.values()```  

* ```map.getOrDefault(key, defaultValue)``` returns the value associated with the key or the default value if the key is not stored in the map.

* The difference between put and replace methods
  - ```map.put(key, value)``` add the pair (key, value) to the map even if key was not stored.
  - ```map.replace(key, value)``` does nothing if key is not found in map.

* Removes all of the mappings from this map: ```map.clear()```

* Initialize a map and add elements by hand
```
Map<String, String> map = new HashMap<>() {{
        put("a", "b");
        put("c", "d");
    }};
```
**Two implementations**

| | key interface | ordering | inherited interface |
|:-:|:-:|:-:|:-:|
|`HashMap`| `equals()`, `hashCode()` | not sorted | `Map` |
|`TreeMap`| `compareTo()` | keys sorted | `Map`, `NagivableMap`, `SortedMap` |


**Odered operations**

* `floorKey(K key)`: Returns the greatest key less than or equal to the given key, or null if there is no such key.
* `ceilingKey(K key)`: Returns the least key greater than or equal to the given key, or null if there is no such key.
* `lastKey()`: Returns the last (highest) key currently in this map.
* `firstKey()`: Returns the first (lowest) key currently in this map.

***
## Interfaces
***
An *interface* is nothing more than **a list of instance methods**.

### Comparable interface

  method: ```compareTo()```

  ```v.compareTo(w)``` returns an integer that is negative, zero, or positive
  (usually -1, 0, or +1) when v<w, v=w,
  or v>w, respectively.

  ```Java
  public class Transaction implements Comparable<Transaction>
    {
      private final double amount;

      public int compareTo(Transaction that)
        {
          if (this.amount > that.amount) return +1;
          if (this.amount < that.amount) return -1;
          return 0;
        }
    }
  ```

### Comparator interface

  method: ```compare()```

  The Java Comparator interface allows us to build multiple orders within a single class. It has a single public method ```compare()``` that compares two objects.

  Comparator implementation for Transaction data type:
  ```java
  import java.util.Comparator;
  public class Transaction
    {
      private final String who;
      private final Date when;
      private final double amount;

      public static class WhoOrder implements Comparator<Transaction>
        {
          public int compare(Transaction v, Transaction w)
            { return v.who.compareTo(w.who); }
        }
      public static class WhenOrder implements Comparator<Transaction>
        {
          public int compare(Transaction v, Transaction w)
            { return v.when.compareTo(w.when); }
        }
      public static class HowMuchOrder implements Comparator<Transaction>
        {
          public int compare(Transaction v, Transaction w)
            {
              if (v.amount < w.amount) return -1;
              if (v.amount > w.amount) return +1;
              return 0;
            }
        }
    }
  ```
  WhoOrder, WhenOrder, and HowMuchOrder are three Comparators the Transaction type data equipped. To sort an array of Transactions by WhenOrder, simply pass WhenOrder instance to the sort method like ```Collections.sort(a, new Transaction.WhenOrder())```


### Iterable Interface

* ```Iterable```: an interface with a method that returns an instance of an ```Iterator``` over elements of type T.

* ```Iterator```: an ```Iterator``` is an object from a class implements the methods ```hasNext()```, ```next()```, and ```remove()```.

API of ```Iterable``` interface:

```java
public interface Iterable<T> {
  Iterator<T> iterator();
}
```

Implementation of ```Iterable``` interface in a class.

```java
public class CLASS<T> implements Iterable<T> {
  ...
  public Iterator<T> iterator() {
    return new customIterator<>;
  }

  private class customIterator(){
    public boolean hasNext() {
      ...
    }
    public T next() {
      ...
    }
    public void remove() {
      ...
    }
  }
}
```
### Collection interface
***

## Static and dynamic binding in java

Association of method call to the method body is known as binding. There are two types of binding: Static Binding that happens at compile time and Dynamic Binding that happens at runtime. [See this thread](https://beginnersbook.com/2013/04/java-static-dynamic-binding/).
