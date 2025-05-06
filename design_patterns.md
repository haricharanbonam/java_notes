
---

## 🧱 1. Singleton Pattern

### ✅ Definition:

Ensures only **one instance** of a class exists and provides a **global access point** to it.

### 🎯 When to Use:

* Only one object is needed (e.g., Logger, Configuration, DB Connection).
* Global access is required.

### 💡 Java Example:

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {} // private constructor

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println(msg);
    }
}
```

### 📌 Usage:

```java
Singleton logger = Singleton.getInstance();
logger.log("App started");
```

---

## 🏭 2. Factory Pattern

### ✅ Definition:

Defines an **interface for creating objects**, but lets subclasses decide which class to instantiate.

### 🎯 When to Use:

* Don’t know what class objects you'll need.
* Want to decouple object creation from client code.

### 💡 Java Example:

```java
interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() { System.out.println("Woof!"); }
}

class Cat implements Animal {
    public void speak() { System.out.println("Meow!"); }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        if (type.equals("dog")) return new Dog();
        else if (type.equals("cat")) return new Cat();
        return null;
    }
}
```

### 📌 Usage:

```java
Animal a = AnimalFactory.getAnimal("dog");
a.speak(); // Output: Woof!
```

---

## 🧱🏭 3. Abstract Factory Pattern

### ✅ Definition:

Factory of factories. Provides an interface for creating **families of related or dependent objects**.

### 🎯 When to Use:

* System must work with multiple product families.
* Need to enforce usage of related objects together.

### 💡 Java Example:

```java
interface Button {
    void paint();
}

class WindowsButton implements Button {
    public void paint() { System.out.println("Windows Button"); }
}

class MacButton implements Button {
    public void paint() { System.out.println("Mac Button"); }
}

interface GUIFactory {
    Button createButton();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
}
```

### 📌 Usage:

```java
GUIFactory factory = new WindowsFactory(); // or new MacFactory()
Button btn = factory.createButton();
btn.paint(); // Output: Windows Button
```

---

## 🧬 4. Prototype Pattern

### ✅ Definition:

Create new objects by **cloning existing ones** (instead of `new` keyword).

### 🎯 When to Use:

* Object creation is costly.
* Need to create many similar objects.

### 💡 Java Example:

```java
class Shape implements Cloneable {
    int x, y;

    public Shape(int x, int y) {
        this.x = x; this.y = y;
    }

    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
}
```

### 📌 Usage:

```java
Shape original = new Shape(10, 20);
Shape copy = original.clone();
System.out.println(copy.x + ", " + copy.y); // Output: 10, 20
```

---

## 🏗️ 5. Builder Pattern

### ✅ Definition:

Builds complex objects **step-by-step**, separating construction from representation.

### 🎯 When to Use:

* Need to build an object with many optional parts.
* Want to create different representations using the same construction process.

### 💡 Java Example:

```java
class Car {
    String engine, color;

    public Car(String engine, String color) {
        this.engine = engine;
        this.color = color;
    }

    public String toString() {
        return engine + " - " + color;
    }
}

class CarBuilder {
    private String engine;
    private String color;

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Car build() {
        return new Car(engine, color);
    }
}
```

### 📌 Usage:

```java
Car myCar = new CarBuilder().setEngine("V8").setColor("Red").build();
System.out.println(myCar); // Output: V8 - Red
```

---

## 📝 Summary Table

| Pattern          | Purpose                                | Example Use             |
| ---------------- | -------------------------------------- | ----------------------- |
| Singleton        | One instance globally                  | Logger, ConfigManager   |
| Factory          | Create object without specifying class | Animal Factory          |
| Abstract Factory | Create families of related objects     | GUI Toolkit (Mac/Win)   |
| Prototype        | Clone objects instead of new ones      | Game objects, Documents |
| Builder          | Build complex objects step-by-step     | Car, Pizza              |

---

