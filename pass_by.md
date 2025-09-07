
---

# 📘 Function Parameter Passing: Pass-by-Value vs Pass-by-Reference

---

## 1. Parent Topic: How Functions Receive Arguments

When you call a function (method), you pass **arguments**. How the function receives those arguments depends on the **parameter passing mechanism**.

There are two classical models:

### **1. Pass-by-Value**

* A **copy of the actual value** is passed to the function.
* Changes inside the function **do not affect** the original variable.

### **2. Pass-by-Reference**

* The function receives a **reference (alias/pointer) to the original variable**.
* Changes inside the function **directly affect** the original variable.

👉 Some languages are pure (only one way), others mix concepts, or abstract it differently.

---

## 2. Language Behaviors

### ✅ C Language

* **Primitives** (`int`, `char`, etc.) → always **pass-by-value**.
* To mimic **pass-by-reference**, you explicitly use **pointers** (`&` and `*` operators).

Example:

```c
#include <stdio.h>

void changeValue(int x) {
    x = 10;   // changes local copy
}

void changeValueByRef(int *x) {
    *x = 20;  // changes original
}

int main() {
    int a = 5;
    changeValue(a);
    printf("%d\n", a); // still 5

    changeValueByRef(&a);
    printf("%d\n", a); // now 20
    return 0;
}
```

---

### ✅ Python

* Python is **always pass-by-value** — but the "value" is a **reference to an object**.
* People call it **“pass-by-object-reference”** or **“call-by-sharing.”**
* If the object is mutable (like list, dict), you can change it inside the function.
* If you reassign, it won’t affect the caller.

Example:

```python
def change_num(x):
    x = 10   # only local change

def change_list(lst):
    lst.append(99)  # modifies original list

def reassign_list(lst):
    lst = [100]     # only local reassignment

a = 5
change_num(a)
print(a)  # 5

nums = [1, 2]
change_list(nums)
print(nums)  # [1, 2, 99]

reassign_list(nums)
print(nums)  # [1, 2, 99]  (not [100])
```

---

### ✅ Java

* **Always pass-by-value.**
* For primitives: value is the number/char/etc.
* For objects: value is the **reference** (a copy of the pointer).

Example:

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int x = 5;
        changeNum(x);
        System.out.println(x); // still 5

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        modifyList(nums);
        System.out.println(nums); // [1, 99]

        reassignList(nums);
        System.out.println(nums); // still [1, 99]
    }

    static void changeNum(int n) {
        n = 10;
    }

    static void modifyList(List<Integer> list) {
        list.add(99);
    }

    static void reassignList(List<Integer> list) {
        list = new ArrayList<>(); // new list, only local reference changed
        list.add(100);
    }
}
```

---

### ✅ JavaScript

* Works like Python.
* Primitives → pass-by-value.
* Objects → the reference is copied (call-by-sharing).

Example:

```javascript
function changeNum(x) {
  x = 10;
}

function modifyArr(arr) {
  arr.push(99);
}

function reassignArr(arr) {
  arr = [100];
}

let a = 5;
changeNum(a);
console.log(a); // 5

let nums = [1, 2];
modifyArr(nums);
console.log(nums); // [1, 2, 99]

reassignArr(nums);
console.log(nums); // [1, 2, 99]
```

---

## 3. Analogy

* **Pass-by-Value**: Giving someone a **photocopy** of your document.
  They can scribble on the copy, but your original is unchanged.
* **Pass-by-Reference**: Giving them the **original document itself**.
  Any edits they make will be visible to you.
* **Java/Python/JS objects**: Giving them a **copy of the key to a room**.
  They can rearrange the furniture inside (mutate object), but if they throw away their key and make a new room, your original key still opens the old room.

---

## 4. Interview Definitions (Concise)

* **Pass-by-Value**: A copy of the actual value is passed. Modifications don’t affect the caller’s variable.
* **Pass-by-Reference**: A reference (alias) to the original variable is passed. Modifications affect the caller’s variable.
* **Call-by-Sharing (Python/JS/Java objects)**: The reference is copied (pass-by-value of reference). Mutations affect the same object, but reassignment doesn’t affect the caller.

---

## 5. Comparison Table

| Language   | Mechanism for Primitives  | Mechanism for Objects                             |
| ---------- | ------------------------- | ------------------------------------------------- |
| **C**      | Pass-by-Value             | Pass-by-Value (use pointer for by-ref)            |
| **Python** | Pass-by-Value (immutable) | Call-by-Sharing (mutable objects can be modified) |
| **Java**   | Pass-by-Value             | Pass-by-Value of Reference                        |
| **JS**     | Pass-by-Value             | Call-by-Sharing                                   |

---


