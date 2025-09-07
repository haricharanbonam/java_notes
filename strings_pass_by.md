
---

# 📘 Java Strings — Complete Senior-Level Notes

---

## 🔑 Parent Concepts

* **Immutable**: Once created, the object’s value cannot be changed.
* **Mutable**: Object’s value can be changed without creating a new object.

---

## 🟢 Strings in Java

In Java, `String` is a **class** (not a primitive).

* Created using `"..."` or `new String("...")`.
* They are **immutable**.

### What does immutable mean?

* Once a `String` object is created, its contents cannot change.
* Any operation that looks like a modification actually creates a **new String object** in memory.
* The original object remains unchanged.

---

## 🟢 Example 1: Reassignment with Strings

```java
public class StringDemo {
    private static void modifyString(String text) {
        text = "goodbye"; // reassigns local copy
    }

    public static void main(String[] args) {
        String greeting = "hello";
        modifyString(greeting);
        System.out.println(greeting); // hello
    }
}
```

### Explanation

* Caller `greeting` → `"hello"`.
* Method parameter `text` → copy of reference to `"hello"`.
* Inside: `text = "goodbye";` → local copy points to `"goodbye"`.
* Caller still points to `"hello"`.
* **Because Strings are immutable**, you can never mutate `"hello"`.

👉 This is **reassignment**, not mutation.

---

## 🟢 Example 2: String Methods (like `substring`)

```java
public class SubstringDemo {
    public static void main(String[] args) {
        String s = "Interview";
        String sub = s.substring(0, 5); // "Inter"
        System.out.println(s);   // Interview
        System.out.println(sub); // Inter
    }
}
```

### Explanation

* `substring` creates a **new String object** `"Inter"`.
* Original `"Interview"` is untouched.
* Confirming immutability: operations like `concat()`, `replace()`, `toUpperCase()` **always create new objects**.

---

## 🟢 Example 3: Why Swap/Modify Doesn’t Work

```java
public class SwapDemo {
    static void changeName(String name) {
        name = "NewName"; // reassignment only
    }

    public static void main(String[] args) {
        String myName = "Hari";
        changeName(myName);
        System.out.println(myName); // Hari
    }
}
```

### Explanation

* `name` inside method was only a copy.
* Reassignment doesn’t affect caller.
* Since `String` objects can’t be mutated → caller remains unchanged.

---

## 🟢 Contrast: Mutable Strings

### 🔹 Using `StringBuilder`

```java
public class StringBuilderDemo {
    static void modify(StringBuilder sb) {
        sb.append(" World");
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        modify(sb);
        System.out.println(sb); // Hello World
    }
}
```

### Explanation

* `StringBuilder` is mutable.
* Passing a `StringBuilder` reference → both caller and method share same object.
* Mutating with `append` updates the object directly.

---

### 🔹 Using `StringBuffer`

* Same as `StringBuilder`, but **thread-safe** (synchronized).
* Slightly slower, but safe for multithreaded contexts.

---

## 🟢 Memory Behavior

### For Strings:

* Stored in the **heap**.
* String literals (like `"hello"`) are stored in the **String Constant Pool (SCP)** for efficiency.
* Any modification → new object is created. Old one is untouched.

### For StringBuilder/StringBuffer:

* Stored in the heap.
* Modification happens **in-place** (same object).
* More efficient if frequent changes are needed.

---

## 📊 Comparison Table

| Feature       | String (Immutable)                   | StringBuilder (Mutable)   | StringBuffer (Mutable + Thread-Safe)      |
| ------------- | ------------------------------------ | ------------------------- | ----------------------------------------- |
| Mutability    | ❌ No                                 | ✅ Yes                     | ✅ Yes                                     |
| Performance   | Slower (new object each time)        | Faster (same object)      | Slower than StringBuilder (sync overhead) |
| Thread-safety | ✅ Yes (immutable is inherently safe) | ❌ No                      | ✅ Yes                                     |
| Usage example | Fixed values, keys in collections    | Dynamic text manipulation | Multi-threaded dynamic text manipulation  |

---

## 🟢 Senior-Level Interview Questions

### Q1. Why are Strings immutable in Java?

* Security (e.g., for class loading, file paths, database URLs).
* Thread safety (shared strings don’t need synchronization).
* Caching and interning in String Constant Pool.
* Hashcode immutability (used as keys in `HashMap`).

---

### Q2. What happens when you do `s = s + "abc"`?

* A new object is created with the new value.
* Old `s` object is left for garbage collection (if no references remain).

---

### Q3. What is the difference between `String`, `StringBuilder`, and `StringBuffer`?

* Immutability, performance, and thread-safety (covered in table above).

---

### Q4. If I call `s.toUpperCase()`, why doesn’t `s` change?

* `toUpperCase()` returns a new object.
* Example:

  ```java
  String s = "java";
  String upper = s.toUpperCase();
  System.out.println(s);     // java
  System.out.println(upper); // JAVA
  ```

---

### Q5. What is the String Constant Pool (SCP)?

* A special memory region inside heap.
* Stores unique string literals.
* Helps memory efficiency — two variables with the same literal point to the same object.

  ```java
  String a = "hello";
  String b = "hello";
  System.out.println(a == b); // true (same object from SCP)
  ```

---

# ✅ Final Takeaways (Strings)

1. **String = Immutable**.

   * All modifications → new object.
   * Original stays untouched.

2. **Method Reassignment** → Only changes local reference, caller unaffected.

3. **String Methods** like `substring`, `concat`, `replace` → Return **new strings**.

4. **StringBuilder/StringBuffer = Mutable**.

   * In-place modification.
   * Builder → fast, non-thread-safe.
   * Buffer → thread-safe, slower.

5. **Interview Pro Tips**:

   * Be ready to explain **why immutability matters** (security, pooling, hashcode).
   * Demonstrate knowledge of **memory impact** (SCP, GC).
   * Show clear understanding of **mutable alternatives** (`StringBuilder` for performance, `StringBuffer` for concurrency).

---

