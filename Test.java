import java.util.*;
public class Test {
    
    public static void main(String[] args) {

        Train t = new Train();

        
        t.addLast("oil", 6);
        System.out.println(t);

        t.addFirst("books", 50);
        System.out.println(t);

        t.addLast("milk", 4);
        System.out.println(t);

        t.addLast("pens", 2);
        System.out.println(t);

        t.addFirst("glass", 42);
        System.out.println(t);

        t.addLast("phone", 9);
        System.out.println(t);

        t.addFirst("table", 56);
        System.out.println(t);

        t.addLast("yats", 52);
        System.out.println(t);

        t.addFirst("cars", 70);
        System.out.println(t);

        t.removelast();
        System.out.println(t);

        t.removeFirst();
        System.out.println(t);

        t.remove("oil");
        System.out.println(t);

        t.remove("table");
        System.out.println(t);

        t.remove("phone");
        System.out.println(t);

        t.remove("engine");
        System.out.println(t);

        
    }
}