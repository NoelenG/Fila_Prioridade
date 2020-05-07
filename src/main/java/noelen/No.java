package noelen;

public class No {
    //tirei o tell para os testes funcionar
    private No next;
    private String name;
    private int priority;
    //private int tel;

    public No(String name, int priority){
        this.name = name;
        this.priority = priority;
       // this.tel = tel;
        next = null;
    }

    public String getName(){
        return name;
    }
    public int getPriority(){
        return priority;
    }
    /*public int getTel() {
		return tel;
    }*/
    
    public No getNext(){
        return next;
    }

    public void setNext(No next){
        this.next = next;
    }
}

