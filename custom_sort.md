```java
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		String s = "programming";
		List<Character>  l = new ArrayList<>();
		for(char i : s.toCharArray())
		{
		    l.add(i);
		}
		Map<Character,Integer> map = new HashMap<>();
		for(Character i : l)
		{
		    map.put(i,map.getOrDefault(i,0)+1);
		}
		Collections.sort(l,(a,b)->
		{
		    if(map.get(a)==map.get(b))
		    {
		        return a-b;
		    }
		    return map.get(a)-map.get(b);
		});
		System.out.println(l);
		
	}
// 	public static void main(String[] args) {
// // 		int arr[]={8,3,2,8,0,4,4,6,6,5};
// 		String arr[] = {"a","dfk","djfk"};
// 		List<Integer>  l = new ArrayList<>();
// // 		for(int i : arr)
// // 		{
// // 		    l.add(i);
// // 		}
// 		Arrays.sort(arr,(a,b)->a.compareTo(b));
// // 		Map<Integer,Integer> map = new HashMap<>();
// // 		for(Integer i : l)
// // 		{
// // 		    map.put(i,map.getOrDefault(i,0)+1);
// // 		}
// // 		Collections.sort(l,(a,b)->
// // 		{
// // 		    return map.get(a)-map.get(b);
// // 		});
// // 		System.out.println(l);
		
// 	}
}

```
# formatting
```
import java.util.*;

public class Main {
    public static void main(String[] args) {

        boolean bool = true;
        int num = 255;
        double pi = 1234.5678;
        char ch = 'A';
        String str = "Hello";
        Date date = new Date();

        System.out.printf("Boolean: %b\n", bool);              // true
        System.out.printf("Hashcode (hex): %h\n", str);        // hex hash
        System.out.printf("String: %s\n", str);                // Hello
        System.out.printf("Character: %c\n", ch);              // A

        System.out.printf("Decimal (base10): %d\n", num);      // 255
        System.out.printf("Octal (base8): %o\n", num);         // 377
        System.out.printf("Hex (base16): %x\n", num);          // ff

        System.out.printf("Scientific: %e\n", pi);             // 1.234568e+03
        System.out.printf("Float decimal: %f\n", pi);          // 1234.567800
        System.out.printf("General format: %g\n", pi);         // 1234.57 or scientific
        System.out.printf("Hex float: %a\n", pi);              // 0x1.34a458p10

        System.out.printf("Year: %tY\n", date);                // e.g., 2026

        System.out.printf("Percent sign: %%\n");               // %
    }
}
```
```java
public class Main
{
	public static void main(String[] args) {
	Integer x = 20200;
	Integer y = 20200;
	System.out.println(x==y);
	}
}
```
