public class Node {

    private int price;
    private String cargo;
    private Node next;
    private Node privious;

    /**
     * constructor
     */
    public Node(String cargo, int price) {
        this.cargo = cargo;
        this.price = price;
        this.privious = null;
        this.next = null;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrivious() {
        return this.privious;
    }

    public void setPrivious(Node privious) {
        this.privious = privious;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        String toReturn = "";
        toReturn += getCargo() + "(";
        toReturn += getPrice() + ")";
        return toReturn;
    }

    public boolean isSame (String cargo) {
        boolean toReturn;
        toReturn = this.cargo.equalsIgnoreCase(cargo);
        return toReturn;
    }


}