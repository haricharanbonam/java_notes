

---

## Do C and Java have call by reference?

### 🔴 C → **NO (but can simulate it)**

### 🔴 Java → **NO (at all)**

---

## Why **C is NOT call by reference**

In C:

* **Everything is passed by value**
* Even **pointers** are passed by value

Example idea (conceptual, not code-heavy):

* You pass the **address** of a variable
* But that **address itself is copied**
* So technically → still **call by value**

👉 C **simulates** call by reference using pointers
👉 But **true call by reference does not exist**

**Key line (exam gold ⭐):**

> C supports call by value, but call by reference is achieved using pointers.

---

## Why **Java is NOT call by reference**

In Java:

* **Everything is call by value**
* Even **objects**

What actually happens:

* The **reference (address) is copied**
* Both variables point to the same object
* But the reference itself is **not shared**

So:

* You can change the **object’s data**
* You **cannot change which object the reference points to**

👉 That’s why Java is called
**“call by value of reference”**, NOT call by reference

**Key line (exam gold ⭐):**

> Java is strictly call by value.

---

## One table that clears everything 🔥

| Language | True Call by Reference? | Explanation                       |
| -------- | ----------------------- | --------------------------------- |
| C        | ❌ No                    | Uses pointers to simulate         |
| Java     | ❌ No                    | Passes object references by value |

---

## Ultimate memory line 🧠

> **If the variable itself can be reassigned by the function → call by reference.**
> **If only the data inside can change → call by value.**

By that rule:

* C ❌
* Java ❌

---


