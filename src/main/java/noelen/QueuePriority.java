package noelen;

public class QueuePriority {
    private No first;
    private No last; 

    public QueuePriority(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void add(String name, int priority){
        No newNode = new No(name, priority); 
        if(isEmpty()){
            first = newNode;             
            last = newNode;
        }else{
            No aux = first;
            No previous = first;
            while(aux != null && aux.getPriority() >= newNode.getPriority()){
                previous = aux;
                aux = aux.getNext();
            }
            if(aux == first){
                newNode.setNext(first);
                first = newNode;
            }else if(aux == null){
                previous.setNext(newNode);
            }else{
                newNode.setNext(aux);
                previous.setNext(newNode);
            }
        }
    }

    /*public void addStart(String name, int priority){
        if(isEmpty()){
            add(name, priority);
        }else{
            No newNode = new No(name, priority);
            newNode.setNext(first);
            first = newNode;
        }
    }*/

    public No remove(){
        if(isEmpty()){
            return null;
        }
        No aux = first;
        first = first.getNext();
        if(first == null){
            last = null;
        }
        return aux;
    }

    /*public No removeEnd(){
        if(isEmpty()){
            return null;
        }
        No aux = first;
        No previous = null;

        while(aux.getNext() != null){
            previous = aux;
            aux = aux.getNext();
        }
        
        if(previous == null){
            first = null;
        }else{
            previous.setNext(null);
        }
        return aux;
    }
*/
    public boolean exist(String name){
        if(!isEmpty()){
            No aux = first;
            while(aux != null){
                if(aux.getName().equals(name)){
                    return true;
                }
                aux = aux.getNext();
            }          
        }
        return false;
    }


    /*public No removeName(String name){
        if(!isEmpty()){
            No aux = first;
            No previous = aux;
            while(aux != null){
                if(aux.getName().equals(name)){
                    if(aux == first){
                        return remove();
                    }
                    if(aux.getNext() == null){
                        return removeEnd();
                    }
                    previous.setNext(aux.getNext());
                    return aux;
                }
                previous = aux;
                aux = aux.getNext();
            }          
        }
        return null;        
    }*/
    public String show(){
        String out = "";
        No aux = first;
        while(aux != null){
            out += aux.getName() + "(" 
            + aux.getPriority() + ")" + ";" ;
            aux = aux.getNext();
        }
        return out;
    }

    public No peek(){
        if(isEmpty()){
            return null;
        }
        return first;
    }
}