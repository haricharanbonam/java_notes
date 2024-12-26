

//printf in java
//%n just same as \n in C
System.out.printf("Hello%nWorld!%n");
//Output:
///Hello
///World!




System.out.printf("%-10s%s","charan","hari");
//charan    hari
//%-10s it will take occupies 10 spaces next to it , so the next string came after 10 spaces
//%-10s: Left-aligns a string in a field of width 10, padding with spaces on the right.

System.out.printf("%10s%s","hari","charan");
//          haricharan
//%5s: Right-aligns a string in a field of width 5, padding with spaces on the left. 

System.out.printf("%d",5);
//5
System.out.printf("%5d",5);
//    5
System.out.printf("%05d",5);
//00005
//until it reaches 5 digits

// %0Nd: The 0 flag indicates that the number should be padded with zeros, and N specifies the total width of the output.
//only works for zero
