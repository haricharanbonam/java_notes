```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Ex {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Comparator<Integer> comp = new Comparator<Integer>()
        {
            public int compare(Integer i,Integer j)
            {
                if(i%10 > j%10)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
        };
        nums.add(34);
        nums.add(57);
        nums.add(11);
        nums.add(64);
        nums.add(634);
        nums.add(19);
        nums.add(19);
        System.err.println(nums );
        java.util.Collections.sort(nums,comp);

        System.err.println(nums );
    }
}
```
