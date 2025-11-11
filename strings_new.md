```java
public class StringRepeatMethod {
    public static void main(String[] args) {
        String originalString = "abc";
        int repeatCount = 2;
        String repeatedString = originalString.repeat(repeatCount);

        System.out.println(repeatedString); // Output: abcabc
    }
}
```



---

## 🧩 **1. `contains()`**

**Definition:**
Checks whether a given substring exists inside a string.

**Syntax:**

```java
boolean result = str.contains("text");
```

**Returns:**

* `true` → if `"text"` exists in `str`
* `false` → otherwise

**Example:**

```java
String s = "Hello World";
System.out.println(s.contains("World"));  // true
System.out.println(s.contains("world"));  // false (case-sensitive)
```

✅ **Notes:**

* It is **case-sensitive**.
* It internally uses `indexOf()` (returns true if index ≥ 0).

---

## 🧩 **2. `substring()`**

Used to extract part of a string.

There are **two main forms:**

### 👉 (a) `substring(int beginIndex)`

Extracts substring from `beginIndex` to **end of the string**.

```java
String s = "Programming";
System.out.println(s.substring(3)); // "gramming"
```

* Starts from index 3 → `'g'`
* Goes till the end

---

### 👉 (b) `substring(int beginIndex, int endIndex)`

Extracts substring from `beginIndex` to **endIndex - 1** (endIndex is excluded).

```java
String s = "Programming";
System.out.println(s.substring(0, 4)); // "Prog"
```

* Takes characters from index **0 → 3**
* Stops *before* index 4

---

✅ **Important Points:**

* `beginIndex` must be ≥ 0
* `endIndex` ≤ string length
* If `beginIndex == endIndex`, returns an empty string `""`
* Throws `StringIndexOutOfBoundsException` if indices are invalid

---

### 🧠 Example combining both:

```java
String str = "HariCharan";

System.out.println(str.substring(4));      // "Charan"
System.out.println(str.substring(0, 4));   // "Hari"

if (str.contains("Char")) {
    System.out.println("Yes, it contains 'Char'");
}
```

Output:

```
Charan
Hari
Yes, it contains 'Char'
```

---

✅ **Summary Table**

| Method            | Purpose                    | Example                   | Output  |
| ----------------- | -------------------------- | ------------------------- | ------- |
| `contains(str)`   | Checks if substring exists | `"hello".contains("ell")` | `true`  |
| `substring(i)`    | From index `i` to end      | `"hello".substring(2)`    | `"llo"` |
| `substring(i, j)` | From index `i` to `j-1`    | `"hello".substring(1,4)`  | `"ell"` |

---

