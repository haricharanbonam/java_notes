Sure. This is one of Java's interesting optimizations.

### What is Integer Cache?

`Integer` is a wrapper class around the primitive `int`.

When you write:

```java
Integer a = Integer.valueOf(10);
Integer b = Integer.valueOf(10);
```

Java does **not** create two separate `Integer` objects for values between **-128 and 127**.

Instead, it reuses objects from an internal cache.

```java
System.out.println(a == b);
```

Output:

```java
true
```

because both `a` and `b` point to the **same object** in memory.

---


Whenever you ask for one of these values using `Integer.valueOf()`, Java returns the cached object instead of creating a new one.



```

Both variables point to the same object.

---

### Outside the Cache Range

```java
Integer a = Integer.valueOf(200);
Integer b = Integer.valueOf(200);

System.out.println(a == b);
```

Output:

```java
false
```

Memory:

```text
a ---> Integer(200)

b ---> Integer(200)
```

Java creates two different objects because `200` is outside the cache range.

---

### Difference Between `==` and `.equals()`

`==` compares references.

```java
Integer a = Integer.valueOf(100);
Integer b = Integer.valueOf(100);

System.out.println(a == b);
```

Output:

```java
true
```

because same cached object.

---

```java
Integer a = Integer.valueOf(200);
Integer b = Integer.valueOf(200);

System.out.println(a == b);
```

Output:

```java
false
```

because different objects.

---

`.equals()` compares values:

```java
Integer a = Integer.valueOf(200);
Integer b = Integer.valueOf(200);

System.out.println(a.equals(b));
```

Output:

```java
true
```

because both contain the value `200`.

---

### What About Autoboxing?

When you write:

```java
Integer a = 10;
Integer b = 10;
```

Java automatically converts this to:

```java
Integer a = Integer.valueOf(10);
Integer b = Integer.valueOf(10);
```

So:

```java
System.out.println(a == b);
```

Output:

```java
true
```

because the cache is used.

---

### What If I Use `new Integer()`?

```java
Integer a = new Integer(10);
Integer b = new Integer(10);

System.out.println(a == b);
```

Output:

```java
false
```


### Rule to Remember

* `Integer.valueOf()` uses the Integer Cache.
* Cache range is **-128 to 127** by default.
* `==` compares object references.
* `.equals()` compares values.
* Autoboxing (`Integer x = 10`) uses `Integer.valueOf()`.
* Never use `==` to compare wrapper values; use `.equals()` instead.
