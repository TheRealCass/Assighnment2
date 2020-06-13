import java.util.Scanner;

public class TrainCar {

    //commands
    private static final String PICKUP = "PICKUP";
    private static final String TO_STRING = "PRINT";
    private static final String REMOVE_FIRST = "DROPFIRST";
    private static final String REMOVE_LAST = "DROPLAST";
    private static final String REMOVE = "DROP";
    private static final Object ENGINE = "engine";

    private Train train;
    private Scanner scan;


    public TrainCar () {
        train = new Train();
    }

    public void executeCommand(String command) {

        int items = 0;
        String keyword = "";
        String type = "";
        scan = new Scanner(command);
        keyword = scan.next();
        
        if(keyword.equals(REMOVE)) {
            type = scan.next();
            items = scan.nextInt();
        } else if (keyword.equals(TO_STRING)){
            toString();
            return;
        } else {
            items = scan.nextInt();
        }

        System.out.println("Processing command: " + keyword + " " + items);

        if (keyword.equals(PICKUP)) 
            addBogey(command, items);
        else if (keyword.equals(TO_STRING)) {
            String info = toString();
            System.out.println(info);
        } else if (keyword.equals(REMOVE_FIRST))
            removeFrontBogey(command);
        else if (keyword.equals(REMOVE_LAST))
            removeLastBogey(command);
        else{
            System.out.println("Invalid command");
        }
    }

    private boolean removeLastBogey(String command) {

        return false;
    }

    private boolean removeFrontBogey(String command) {
        return false;
    }

    @Override
    public String toString() {
        return "a";
    }

    private void addBogey(String command, int items) {
        scan = new Scanner(command);
        scan.nextLine();
        String cargo = "";
        int price = 0;

        for (int i = 1; i < items; i++) {
            String instruction = scan.nextLine();
            Scanner scanner = new Scanner(instruction);
            cargo = scanner.next();
            if (cargo.equals(ENGINE)) {
                train.addEngine();
                scanner.close();
            } else {
            price = scanner.nextInt();
            scanner.close();   
            }
            train.addLast(cargo, price);
        }
       
    }
}