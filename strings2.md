
---

# 📘 Quick Notes: String Constant Pool (SCP) vs Heap in Java

---

## 🔑 Where Strings are Stored

* **String literals** (e.g., `"hello"`) → stored in the **String Constant Pool (SCP)** (a special area inside heap).
* **`new String("hello")`** → creates a **new object in the heap**, even if the same literal already exists in SCP.

👉 So:

* `"hello"` → SCP.
* `new String("hello")` → Heap + also ensures `"hello"` exists in SCP.

---

## 🟢 Example 1: Literals → SCP

```java
String a = "hello";
String b = "hello";

System.out.println(a == b);      // true
System.out.println(a.equals(b)); // true
```

* Both point to the same object in SCP.

---

## 🟢 Example 2: `new String` → Heap

```java
String a = new String("hello");
String b = new String("hello");

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

* Two new heap objects created.
* Contents are equal, references are not.

---

## 🟢 Example 3: Mix of SCP + Heap

```java
String a = "hello";
String b = new String("hello");

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

* `a` → SCP object.
* `b` → Heap object.
* Different references, same value.

---

## 🟢 Example 4: Using `intern()`

```java
String a = new String("hello");
String b = a.intern();   // forces reference to SCP

System.out.println("hello" == b); // true
System.out.println(a == b);       // false
```

* `intern()` makes sure you get the canonical (SCP) object.

---

## 📊 Quick Comparison Table

| Case                          | Location   | `==` Result                     | `.equals()` Result |
| ----------------------------- | ---------- | ------------------------------- | ------------------ |
| Both literals `"hello"`       | SCP        | true                            | true               |
| Both `new String("hello")`    | Heap       | false                           | true               |
| Literal vs new String         | SCP + Heap | false                           | true               |
| With `intern()` on new String | SCP        | true (when compared to literal) | true               |

---

## 🟢 Senior-Level Interview Traps

### Q1: Why does Java use SCP?

* To save memory (reuses common strings).
* To improve performance.

### Q2: Why is String immutable important here?

* SCP works only because strings are immutable — otherwise, one change would affect all references.

### Q3: When should you use `new String()` instead of literal?

* Almost never.
* `new String("...")` explicitly forces a new heap object → wastes memory.

---

# ✅ Final Takeaway

* **String literals** → SCP (reused).
* **`new String()`** → Heap (always new object).
* Always use `.equals()` for string comparison (not `==`).
* Use `.intern()` if you want heap-created strings to refer to SCP.

---


Do you want me to also show you **a visual diagram (SCP vs heap objects)** to lock this in permanently?
