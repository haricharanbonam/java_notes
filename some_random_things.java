// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    static interface AB{
        void display();
        default int hello()
        {
            return 0;
        }
        static void pika()
        {
            System.out.println("pika");
        }
        
    }
    public static void main(String[] args) {
    String x = "my name is hari";
    char ch = ' ';

    String arr1[] = x.split(" ");
    for(String i : arr1)
    {
        System.out.println(i);
    }
    AB.pika();
    System.out.print("0000000".replaceAll("\0+", "0") );
    

    }
}
