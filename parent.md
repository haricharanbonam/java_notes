

### The Golden Rule: Program to an Interface (Parent on the Left)

The overwhelming best practice, and what you see in most professional courses and production code, is to **program to an interface**. This means using the **parent interface (like `List`, `Set`, `Map`) on the left-hand side** for the reference variable's type, and the concrete implementation (like `ArrayList`, `HashSet`, `HashMap`) on the right-hand side when creating the object.

**Example:**

```java
List<String> myList = new ArrayList<>(); // MOST COMMON AND RECOMMENDED
Set<Integer> mySet = new HashSet<>();
Map<String, Double> myMap = new HashMap<>();
```

**Why this is the preferred way (When to use Parent on the Left):**

1.  **Flexibility and Substitutability:**
    * **The Big Reason:** This is the primary driver. Your code becomes less coupled to a specific implementation. If you later decide that `LinkedList` is a better fit for `myList` due to performance characteristics (e.g., frequent insertions/deletions in the middle), you only change *one line*:
        ```java
        List<String> myList = new LinkedList<>(); // Easy switch!
        ```
    * All your existing code that uses `myList` (e.g., `myList.add()`, `myList.get()`, `myList.remove()`, `myList.indexOf()`) will continue to work without modification, because both `ArrayList` and `LinkedList` fulfill the `List` contract.
    * If you had declared it as `ArrayList<String> myList = new ArrayList<>();`, and then wanted to switch to `LinkedList`, you'd have to change the declaration *and* potentially search for and modify any code that used `ArrayList`-specific methods (like `ensureCapacity()`), which is brittle and error-prone.

2.  **Abstraction and Better API Design:**
    * When you write methods that accept collection types, use interfaces as parameters.
    * Example:
        ```java
        public void processElements(List<String> elements) {
            // ... logic using only List methods ...
        }
        ```
    * This method can now accept an `ArrayList`, `LinkedList`, or any other future `List` implementation without modification. This makes your methods more generic and reusable.
    * Similarly, return interfaces from methods.
        ```java
        public List<String> getFilteredData() {
            // ...
            return new ArrayList<>(); // Or LinkedList, etc.
        }
        ```

3.  **Focus on "What" not "How":**
    * When you declare `List<String> myList`, you're stating that `myList` *is* a list of strings. You're focusing on its behavior (ordered, allows duplicates, index-based access) rather than its internal storage mechanism (resizable array vs. linked nodes). This promotes cleaner, more abstract thinking about your data structures.

**Your understanding of methods:**

You said: "So you are telling me that the parent is on the left-hand side, if all the methods, I mean, if all the methods are actually already in that parent class, but later they can be implemented or modified in the child class."

You're absolutely correct!

* The **parent interface (e.g., `List`)** defines the *contract* for the methods. It declares *what* methods exist (e.g., `add`, `get`, `indexOf`).
* The **child class (e.g., `ArrayList`)** provides the *implementation* for those methods. It defines *how* those methods actually work.
* The compiler cares about the **left-hand side** (`List`) to determine what methods you're *allowed* to call.
* The JVM at runtime cares about the **right-hand side** (`ArrayList`) to determine *which implementation* of the method to execute.

So, if you declare `List<Integer> nums`, the compiler knows `indexOf()` is part of the `List` contract, so it allows the call. At runtime, the `ArrayList`'s specific `indexOf()` implementation will be used.

### When to use the Concrete Type (Child on Both Sides)

There are specific, less frequent scenarios where you might choose to use the concrete class on both sides:

**Example:**

```java
ArrayList<String> myArrayList = new ArrayList<>(); // Child on both sides
```

**When to use this (and when not to use Parent on the Left):**

1.  **When you *absolutely need* methods specific to the concrete class that are *not* part of any interface you're programming to.**
    * For `ArrayList`, this would include methods like `ensureCapacity(int minCapacity)` (to pre-allocate space for performance) or `trimToSize()` (to reduce memory usage).
    * If you consistently use these `ArrayList`-specific methods throughout your code, then declaring it as `ArrayList` might be more straightforward, as it avoids casting:
        ```java
        // If declared as List:
        List<String> myList = new ArrayList<>();
        ((ArrayList<String>) myList).ensureCapacity(100); // Requires a cast

        // If declared as ArrayList:
        ArrayList<String> myArrayList = new ArrayList<>();
        myArrayList.ensureCapacity(100); // No cast needed
        ```
    * **Caveat:** This choice sacrifices flexibility. If you later wanted to switch to `LinkedList`, you would lose access to `ensureCapacity()` and have to refactor that specific logic. So, only do this if the concrete method is truly essential and the flexibility trade-off is acceptable.

2.  **When you are creating a small, isolated utility or helper class where the specific implementation details are highly relevant and unlikely to change.**
    * In very niche cases, where the exact internal workings of `ArrayList` (e.g., its array-based nature) are central to the logic and switching implementations is inconceivable, you *might* use the concrete type. This is rare and generally discouraged for larger applications.

3.  **For local variables in a method where the scope is very limited and the variable is not passed around.**
    * Sometimes, for a very short-lived local variable within a method, if you briefly need an `ArrayList`'s specific feature, you might declare it directly. However, even here, "programming to an interface" is often a better habit.

### Summary:

* **Default and Best Practice:** Use the **interface (parent)** on the left-hand side. This gives you maximum flexibility, promotes good design, and is generally what you'll see in well-written Java code.
    ```java
    List<String> items = new ArrayList<>(); // Go-to choice
    ```

* **Specific Exceptions:** Use the **concrete class (child)** on both sides *only* when you have a compelling, specific reason to access methods unique to that implementation, and you understand and accept the reduction in flexibility.
    ```java
    ArrayList<String> specificList = new ArrayList<>(); // Use only if you need ensureCapacity(), etc., frequently
    ```

