```java
public class RealityCheck {
    public static void main(String[] args) {
        // Test 1: Strings
        String name = "Alice";
        changeString(name);
        System.out.println("String test: " + name);
        
        // Test 2: Arrays
        int[] numbers = {1, 2, 3};
        changeArrayReference(numbers);
        System.out.println("Array reference: " + numbers[0]);
        
        changeArrayContent(numbers);
        System.out.println("Array content: " + numbers[0]);
        
        // Test 3: Custom Objects
        Person person = new Person("Bob");
        changePersonReference(person);
        System.out.println("Person reference: " + person.name);
        
        changePersonContent(person);
        System.out.println("Person content: " + person.name);
    }
    
    static void changeString(String s) {
        s = "Charlie";
    }
    
    static void changeArrayReference(int[] arr) {
        arr = new int[]{9, 8, 7};
    }
    
    static void changeArrayContent(int[] arr) {
        arr[0] = 99;
    }
    
    static void changePersonReference(Person p) {
        p = new Person("David");
    }
    
    static void changePersonContent(Person p) {
        p.name = "Eve";
    }
    
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
    }
}
```
