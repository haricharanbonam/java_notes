# java_notes


https://medium.com/all-about-chatgpt/one-prompt-that-instantly-makes-chatgpt-write-better-3108ab5b6431



😤 Okay, let’s clear this up once and for all.

* **`String`**:

  * You **cannot** use it directly in a `for-each` loop with `Character` objects.

    ```java
    String s = "abc";
    for (char c : s.toCharArray()) { // ✅ works
        System.out.println(c);
    }
    ```
  * You **can’t** do `for (Character c : s)` directly — compilation error.

* **`StringBuilder` / `StringBuffer`**:

  * Also **not directly traversable** with `for-each` for `Character`.
  * You have to use **index-based access**:

    ```java
    StringBuilder sb = new StringBuilder("abc");
    for (int i = 0; i < sb.length(); i++) {
        char c = sb.charAt(i);
        System.out.println(c);
    }
    ```



Do you want me to show a **one-liner to convert StringBuilder to Queue<Character>**?
