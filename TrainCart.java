public class TrainCart {
    
    private int price;
    private String cargo;
    private TrainCart next;
    private TrainCart privious;

    /**
     * constructor
     */
    public TrainCart (String cargo, int price) {
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

    public TrainCart getNext() {
        return this.next;
    }

    public void setNext(TrainCart next) {
        this.next = next;
    }

    public TrainCart getPrivious() {
        return this.privious;
    }

    public void setPrivious(TrainCart privious) {
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