package noelen;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        QueuePriority lista = new QueuePriority();

        lista.add("noelen", 1);
        lista.add("agata", 2);
        lista.add("joao", 3);
        lista.add("tata", 2);
        lista.add("Sara", 4);
        lista.add("lola", 5);

        System.out.println(lista.show());

        No temp = lista.remove();
        System.out.println("Removeu " + temp.getName());

        System.out.println(lista.show());

    }
}
