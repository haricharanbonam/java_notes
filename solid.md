
---

## ✅ 1. **Single Responsibility Principle (SRP)**

### 🔹 Rule:
> A class should **only have one reason to change**.

### 🔸 Meaning:
Each class should **do one job only**. If a class is handling multiple tasks, it becomes harder to maintain.

### 💡 Example (Bad):
```java
class UserManager {
    void createUser() {
        // logic to create user
    }
    void sendEmail() {
        // logic to send email
    }
}
```

This class handles both **user creation** and **email sending**. These are two responsibilities.

### ✅ Correct Way:
```java
class UserManager {
    void createUser() {
        // logic to create user
    }
}

class EmailService {
    void sendEmail() {
        // logic to send email
    }
}
```

Now each class has a **single responsibility**.

---

## ✅ 2. **Open/Closed Principle (OCP)**

### 🔹 Rule:
> Classes should be **open for extension**, but **closed for modification**.

### 🔸 Meaning:
You should be able to **add new features** without changing existing code.

### 💡 Example (Bad):
```java
class DiscountCalculator {
    double calculate(String type, double price) {
        if (type.equals("Regular")) return price * 0.9;
        else if (type.equals("Premium")) return price * 0.8;
        return price;
    }
}
```

If we want to add a new discount type, we need to **modify this class**.

### ✅ Correct Way:
```java
interface DiscountStrategy {
    double applyDiscount(double price);
}

class RegularDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}

class PremiumDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.8;
    }
}
```

Now you can **extend** by adding new classes without changing old ones.

---

## ✅ 3. **Liskov Substitution Principle (LSP)**

### 🔹 Rule:
> Subclasses should be able to replace their base classes **without breaking the app**.

### 🔸 Meaning:
A subclass must honor the **contract** of the parent class.

### 💡 Example (Bad):
```java
class Vehicle {
    void startEngine() { System.out.println("Engine started"); }
}

class Train extends Vehicle {
    void startEngine() {
        throw new UnsupportedOperationException("Train engine can't be started like this");
    }
}
```

🚫 `Train` violates LSP — it's **not truly a Vehicle** if it breaks the method behavior.

### ✅ Correct Way:
You can create separate hierarchies:
```java
interface EngineVehicle {
    void startEngine();
}

class Car implements EngineVehicle {
    public void startEngine() { /* ok */ }
}

class Train {
    void startByTrackSystem() { /* correct for train */ }
}
```

Now each class behaves **correctly** and doesn’t break expectations.

---

## ✅ 4. **Interface Segregation Principle (ISP)**

### 🔹 Rule:
> **Do not force** a class to implement interfaces it doesn’t use.

### 🔸 Meaning:
Break large interfaces into **smaller ones**.

### 💡 Example (Bad):
```java
interface MultiFunctionDevice {
    void print();
    void scan();
    void fax();
}

class BasicPrinter implements MultiFunctionDevice {
    public void print() { /* okay */ }
    public void scan() { throw new UnsupportedOperationException(); }
    public void fax()  { throw new UnsupportedOperationException(); }
}
```

🚫 Bad — this printer only prints but is **forced** to implement `scan()` and `fax()`.

### ✅ Correct Way:
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}
```

Then:
```java
class BasicPrinter implements Printer {
    public void print() { /* prints */ }
}
```

---

## ✅ 5. **Dependency Inversion Principle (DIP)**

### 🔹 Rule:
> High-level modules should not depend on low-level modules. Both should depend on **abstractions**.

### 🔸 Meaning:
Classes should **depend on interfaces**, not on concrete classes.

### 💡 Example (Bad):
```java
class MySQLDatabase {
    void save() { System.out.println("Saved in MySQL"); }
}

class DataManager {
    MySQLDatabase db = new MySQLDatabase();
    void saveData() {
        db.save();
    }
}
```

🚫 Tight coupling: DataManager is tied to `MySQLDatabase`.

### ✅ Correct Way:
```java
interface Database {
    void save();
}

class MySQLDatabase implements Database {
    public void save() { System.out.println("Saved in MySQL"); }
}

class DataManager {
    Database db;
    DataManager(Database db) {
        this.db = db;
    }
    void saveData() {
        db.save();
    }
}
```

Now `DataManager` is **flexible** — you can use MySQL, MongoDB, etc.

---

## 🔚 Summary of SOLID:

| Principle | Keyword | Why It Helps |
|----------|---------|--------------|
| SRP      | One Job | Simpler code, easier to maintain |
| OCP      | Add not Change | Easily extend features |
| LSP      | No Surprises | Subclasses behave properly |
| ISP      | Only What You Use | Avoid unnecessary methods |
| DIP      | Use Interfaces | Code becomes flexible and testable |

---

## How tight coupling varied in each of them?


**Coupling** is *very related* to concepts like composition vs inheritance — especially when you're trying to build clean, maintainable code. 💡

---

### 🔗 What is Coupling in OOP?

**Coupling** refers to how **tightly connected** different parts (classes/modules) of your code are.

- **Tight Coupling** = Classes are heavily dependent on each other’s internal details. Changes in one often force changes in another.
- **Loose Coupling** = Classes interact through clear interfaces or contracts, not implementation details. Changes are easier to manage.

---

### 🤝 Coupling & Composition vs Inheritance

Let’s compare:

#### ❌ Inheritance can create **tight coupling**
When `class B extends class A`, B is **strongly tied** to A's implementation.
If you change `A`, you may have to rewrite `B`.

```java
class Vehicle {
    void startEngine() { ... }
}

class Train extends Vehicle {
    // throws error inside startEngine(): violation!
}
```

Now `Train` is **tightly coupled** to `Vehicle`. But what if trains work totally differently? Then you get broken logic or bad hacks (like throwing exceptions in inherited methods 😬).

---

#### ✅ Composition encourages **loose coupling**
Using **interfaces and composition**, you design flexible code where components can be swapped out.

```java
interface FarePolicy {
    double computeFare(Ride ride);
}

class Driver {
    FarePolicy policy;

    Driver(FarePolicy policy) {
        this.policy = policy;
    }

    double calculateFare(Ride ride) {
        return policy.computeFare(ride);
    }
}
```

Now `Driver` doesn’t care how the fare is calculated — it just trusts the policy object to do its job. That’s **loose coupling** 🔥.

---

### ✅ Benefits of Loose Coupling via Composition

- ✅ Easier to test (you can mock `FarePolicy`)
- ✅ Easier to change behavior (just pass a new object)
- ✅ Easier to reuse code (policies are independent)
- ✅ Fewer bugs when changing existing logic

---

### 💡 Summary

| Concept        | Inheritance         | Composition          |
|----------------|---------------------|-----------------------|
| Coupling Type | Tight Coupling       | Loose Coupling        |
| Flexibility    | Hard to change       | Easy to swap behaviors |
| Extensibility | Can be rigid         | Highly extensible     |

---

single responsibility
-readale
-testable
-maintainable
solid is part of low level desgin
srp and ocp seems kind of similar in implementtion but different in the goal


y multiple inherir cant support in java just like py,cpp
what is builder pat in java,py ?
