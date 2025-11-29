

---

# 🟢 What an Interface CAN contain?

### ✔ Abstract methods (no body) — most important

```java
void run(); // no implementation
```

### ✔ Default methods (with implementation)

```java
default void info() {
    System.out.println("This is a default method");
}
```

### ✔ Static methods

```java
static void greet() {
    System.out.println("Hello!");
}
```

### ✔ Variables — BUT they are always:

> `public + static + final`
> (means constant values only — cannot store normal object fields like name, salary)

```java
int MAX = 100; // treated as public static final
```

---

# 🔴 What Interfaces CANNOT do well?

### ✘ Interfaces CANNOT have normal instance variables

Like this is **not possible**:

```java
String name;           // ❌ error
double salary;         // ❌ cannot store instance state
```

Because interface cannot create objects with stored data.
That’s why it is not ideal for Employee example (Manager, Developer, Tester).

Employees need:

| name | id | baseSalary |
→ These **must be stored** somewhere → *abstract class is perfect for that.*

---

# 🧠 Easy memory line

> **Interface → what to do** (rules, behavior)
> **Abstract class → what + common data** (shared properties + method)

So you weren’t wrong — interfaces used to contain *only methods*,
but now they also support **default & static methods**, just not instance variables.

---



