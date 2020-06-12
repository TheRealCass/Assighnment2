public class Train {
    
    private static final boolean DEBUG = true;
    private TrainCart head;
    private TrainCart tail;
    private int length;

    /**
     * constructor
     */
    public Train() {
        this.length = 0;
        TrainCart engine = new TrainCart("engine", 0);
        this.head = engine;
        this.tail = engine;
    }

    
    public TrainCart getHead() {
        return this.head;
    }

    public void setHead(TrainCart head) {
        this.head = head;
    }

    public TrainCart getTail() {
        return this.tail;
    }

    public void setTail(TrainCart tail) {
        this.tail = tail;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public void addFirst (String cargo, int price) {
        
        TrainCart toAdd = new TrainCart(cargo, price);
        
        if (head.getNext() == null) {
            head.setNext(toAdd);
            toAdd.setPrivious(head);
            tail = toAdd;
            length++;
        } else {
            TrainCart temp = head.getNext();
            temp.setPrivious(toAdd);
            toAdd.setNext(temp);
            toAdd.setPrivious(head);
            head.setNext(toAdd);
            length++;
        }
    }

    public void addLast (String cargo, int price) {
        
        TrainCart toAdd = new TrainCart(cargo, price);

        //if empty list
        if (head.getNext() == null){
            addFirst(cargo, price);
            return;
        } else {
            tail.setNext(toAdd);
            toAdd.setPrivious(tail);
            tail = toAdd;
            length++;
        }
    }

    public String toString () {
        TrainCart cart = head;
        String toReturn = "[";
        if (cart == null) {
            toReturn += "Empty list!";
        } else {
            toReturn += cart.toString() + ", ";
            while (cart.getNext() != null) {
                cart = cart.getNext();
                toReturn += cart.toString() + ", ";
            }
            toReturn += "]";
        }
        return toReturn;
    }

    public void removelast() {
        if (head.getNext() == null) return;

        TrainCart priv = tail.getPrivious();
        priv.setNext(null);
        tail.setPrivious(null);
        tail = priv;
        length--;
    }

    public void removeFirst() {
        TrainCart temp = head;
        if(temp.getNext() == null) return; //only 1 element present
        temp = temp.getNext();
        if(temp.getNext() == null) {  //2 element present
            removelast();
        } else {  //2 or more elements
            temp = temp.getNext();
            head.setNext(temp);
            temp.setPrivious(head);
            length--;
        }        
    }

    public void remove(String cargo) {
        TrainCart temp = head;
        if(temp.getNext() == null) return;
        temp = temp.getNext();
        int index = 1;
        while (temp.getNext() != null) {
            if(temp.isSame(cargo)) {
                remove(index);
                return;
            }
            temp = temp.getNext();
            index++;
        }
        
    }

    private void remove(int index) {
        if(index == 0) return;
        else if(index == 1) removeFirst();
        else if (index == length - 1) removelast();
        else {
            TrainCart priv = head;
            TrainCart next = null;
            for (int i = 0; i < index - 1; i++) {
                priv = priv.getNext();
            }
            next = priv.getNext();
            next = next.getNext();
            priv.setNext(next);
            next.setPrivious(priv);
            length--;
        }

    }

}