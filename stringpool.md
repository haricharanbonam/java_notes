
---

## 📘 Notes: Java String, String Pool, and `new String()`

---

### ✅ **1. String Literal (`String s = "hello";`)**

* Stored in the **String Pool** (part of method area in JVM).
* If a literal already exists, **Java reuses it** (to save memory).
* Example:

  ```java
  String a = "hello";
  String b = "hello";
  System.out.println(a == b); // true (same reference)
  ```

---

### 🆚 **2. `new String()` Constructor (`String s = new String("hello");`)**

* Creates a **new object in the heap**, even if the same string literal is in the pool.
* Doesn’t reuse the string from the pool unless **explicitly interned**.
* Example:

  ```java
  String a = new String("hello");
  String b = new String("hello");
  System.out.println(a == b); // false (different heap objects)
  ```

---

### 🧠 **3. What is String Pool?**

* A special memory area where **Java stores string literals**.
* Maintains **unique** strings only.
* **Automatic** for literals, **manual** for objects (via `.intern()`).
* Example:

  ```java
  String a = new String("hello");
  String b = a.intern(); // Forces reuse from pool
  String c = "hello";
  System.out.println(b == c); // true
  ```

---

### 🔥 **4. `==` vs `.equals()`**

| Comparison  | What it checks             | Example Output                |
| ----------- | -------------------------- | ----------------------------- |
| `==`        | Reference (memory address) | `false` (in most `new` cases) |
| `.equals()` | Actual content (value)     | `true` (if same text)         |

---

### ⚙️ **5. Interning**

* Use `s.intern()` to put a string from heap into the pool.
* Makes it eligible for reuse.
* Saves memory and improves comparison speed (when using `==`).

---

### 📌 Summary Table:

| Code                           | Pool | Heap | Same Reference? |
| ------------------------------ | ---- | ---- | --------------- |
| `String a = "hi";`             | ✅    | ❌    | -               |
| `String b = "hi";`             | ✅    | ❌    | ✅               |
| `String c = new String("hi");` | ✅    | ✅    | ❌               |
| `String d = c.intern();`       | ✅    | ✅    | ✅ (with `"hi"`) |

---

### 📚 Extra:

* Strings in Java are **immutable** – once created, they can't be changed.
* That's why Java uses a pool. Safe and efficient.
* Ideal for keys in maps, constants, and comparisons.

---

