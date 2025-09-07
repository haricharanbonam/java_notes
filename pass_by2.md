

---

# 📘 Java Parameter Passing — Senior-Level Interview Notes

---

## 🔑 Parent Topic: *Parameter Passing Mechanism*

In programming languages, **parameter passing** is how values/variables are handed over from the caller (main code) to the callee (function/method).

Two classic models in theory:

* **Pass by Value** → Function gets a copy of the data.
* **Pass by Reference** → Function gets direct access to the caller’s variable.

👉 **Java**: Always **pass by value**.

* For primitives → value = the literal (e.g., `10`).
* For objects → value = the reference (memory address).

So Java doesn’t have “pass-by-reference” in the true sense, but it can *look like it* when objects are mutated.

---

## 🟢 Case 1: Passing Primitives

### Code

```java
public class PrimitiveDemo {
    static void modify(int x) {
        x = 50; // modifies only local copy
    }

    public static void main(String[] args) {
        int a = 10;
        modify(a);
        System.out.println(a); // 10
    }
}
```

### Explanation

* The function gets a copy of `10`.
* Inside the method, `x` changes, but `a` in `main` stays `10`.

### Interview Trap Question

**Q:** Why didn’t the value change?
**A:** Because primitives are copied by value; the method only works with its local copy.

---

## 🟢 Case 2: Passing Objects (Mutation)

### Code

```java
import java.util.*;

public class ObjectMutationDemo {
    static void addElement(List<String> list) {
        list.add("Added");
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Hari");
        addElement(names);
        System.out.println(names); // [Hari, Added]
    }
}
```

### Explanation

* A copy of the **reference (address)** is passed.
* Both caller and method variable point to the same list object.
* Mutating the object (`add`) is visible everywhere.

### Interview Trap Question

**Q:** Is this pass-by-reference?
**A:** No. It’s still pass-by-value — the value being copied is the reference itself.

---

## 🟢 Case 3: Passing Objects (Reassignment)

### Code

```java
import java.util.*;

public class ObjectReassignDemo {
    static void reassignList(List<String> list) {
        list = new ArrayList<>(); // local reference points to a new object
        list.add("New");
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Hari");
        reassignList(names);
        System.out.println(names); // [Hari]
    }
}
```

### Explanation

* The method got a copy of the reference.
* Reassigning inside the method only changes the **local copy**.
* Caller’s reference still points to the old object.

### Interview Trap Question

**Q:** Why didn’t the caller’s list change to `[New]`?
**A:** Because reassignment only updated the method’s copy of the reference. The caller’s reference still points to the original object.

---

## 📊 Senior-Level Comparison Table

| Case                              | What is passed?             | Can callee mutate caller’s object? | Caller sees reassignment? |
| --------------------------------- | --------------------------- | ---------------------------------- | ------------------------- |
| Primitive (`int`, `double`, etc.) | Copy of value               | ❌ No                               | ❌ No                      |
| Object (mutation)                 | Copy of reference (address) | ✅ Yes                              | ❌ No                      |
| Object (reassignment)             | Copy of reference (address) | ❌ No (new object is local only)    | ❌ No                      |

---

## 🟢 Common Senior-Level Questions & Answers

### 1. **If Java is pass-by-value, why do objects appear to change?**

Because the value being copied is the **reference**. Both caller and callee share the same object through that reference.

---

### 2. **Can I swap two objects in a method in Java?**

No, because Java doesn’t support true pass-by-reference. You can mutate them but not reassign caller’s references.

```java
static void swap(List<String> a, List<String> b) {
    List<String> temp = a;
    a = b;
    b = temp;
}
```

Caller’s `a` and `b` remain unchanged outside.

---

### 3. **What about arrays?**

Arrays are objects in Java.

* Mutating elements inside works.
* Reassigning the array inside doesn’t affect caller.

---

### 4. **How is this different from C?**

* **C Primitives**: Pass-by-value (like Java).
* **C Pointers**: Can simulate pass-by-reference by passing addresses.
* **Java**: No pointer arithmetic, always pass-by-value, but values can be references.

---

### 5. **How is this different from Python?**

Python also uses a **pass-by-object-reference (or call-by-sharing)** model, very similar to Java objects.

* Mutations visible.
* Reassignments not visible.

---

# ✅ Final Takeaways (for interviews)

* **Java = always pass-by-value**.
* Think in terms of **copy of primitive** vs **copy of reference**.
* 3 situations:

  1. Primitive → safe copy, caller unaffected.
  2. Object mutation → shared object, caller sees changes.
  3. Object reassignment → local only, caller unaffected.
* Strings behave specially because they are immutable (we’ll cover next).

---

