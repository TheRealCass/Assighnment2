import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        //trainStuff();


        Scanner scan = new Scanner(new File("trainInput.txt"));
        scan.nextLine();
        String check = scan.nextLine();
        System.out.println(check);
        
    }

    private static void trainStuff() {
        
        Train t = new Train();

        
        t.addLast("oil", 6);
        t.addFirst("books", 50);
        t.addLast("milk", 4);
        t.addLast("pens", 2);
        t.addFirst("glass", 42);
        t.addLast("phone", 9);
        t.addFirst("table", 56);
        t.addLast("yats", 52);
        t.addFirst("cars", 70);
        System.out.println(t);


        t.remove("oil");
        System.out.println(t);

        t.remove("table");
        System.out.println(t);

        t.remove("yats");
        System.out.println(t);

        t.remove("engine");
        System.out.println(t);

    }
}