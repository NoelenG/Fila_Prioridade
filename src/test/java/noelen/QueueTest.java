package noelen;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class QueueTest {

    private QueuePriority fila;

    private final String name1 = "Nome1";
    private final String name2 = "Nome2";
    private final String name3 = "Nome3";

    private final int priority1 = 1;
    private final int priority2 = 2;
    private final int priority3 = 3;

    @Before
    public void setup() {
        fila = new QueuePriority();
    }

    @Test
    public void testIsEmpty() {
        boolean vazia = fila.isEmpty();

        assertTrue("Uma fila nova deve iniciar vazia.", vazia);
    }

    @Test
    public void testNotEmpty() {

        fila.add(name1, priority1);
        boolean vazia = fila.isEmpty();

        assertFalse("Uma fila com um elemento não deve estar vazia.", vazia);
    }

    @Test
    public void testAddEndOnEmptyList() {

        fila.add(name1, priority1);
        String out = fila.show();

        String expected = name1 + "(" + priority1 + ")" + ";";

        assertEquals("Após inserção deve ser exibido o nome " + name1, expected, out);
    }

    @Test
    public void testAddHighestPriority() {

        fila.add(name1, priority1);
        fila.add(name2, priority2);
        String out = fila.show();

        String expected = name2 + "(" + priority2 + ")" + ";" + name1 + "(" + priority1 + ")" + ";";

        assertEquals("Após inserção de dois nomes amobos deve ser exibidos respeitando a ordem", expected, out);
    }

    @Test
    public void testLowestPriority() {

        fila.add(name2, priority2);
        fila.add(name1, priority1);
        String out = fila.show();

        String expected = name2 + "(" + priority2 + ")" + ";" + name1 + "(" + priority1 + ")" + ";";

        assertEquals("Após inserção de dois nomes amobos deve ser exibidos respeitando a ordem", expected, out);
    }

    @Test
    public void testAddMiddlePriority() {

        fila.add(name1, priority1);
        fila.add(name3, priority3);
        fila.add(name2, priority2);
        String out = fila.show();

        String expected = name3 + "(" + priority3 + ")" + ";" + name2 + "(" + priority2 + ")" + ";" + name1 + "("
                + priority1 + ")" + ";";

        assertEquals("Após inserção de dois nomes amobos deve ser exibidos respeitando a ordem", expected, out);
    }

    @Test
    public void testAddRepeatedPriorityOnStart() {

        fila.add(name1, priority1);
        fila.add(name3, priority3);
        fila.add(name2, priority2);
        fila.add(name3, priority3);
        String out = fila.show();

        String expected = name3 + "(" + priority3 + ")" + ";" + name3 + "(" + priority3 + ")" + ";" + name2 + "("
                + priority2 + ")" + ";" + name1 + "(" + priority1 + ")" + ";";

        assertEquals("Após inserção de dois nomes amobos deve ser exibidos respeitando a ordem", expected, out);
    }

    @Test
    public void testAddRepeatedPriorityOnEnd() {

        fila.add(name1, priority1);
        fila.add(name3, priority3);
        fila.add(name2, priority2);
        fila.add(name1, priority1);
        String out = fila.show();

        String expected = name3 + "(" + priority3 + ")" + ";" + name2 + "(" + priority2 + ")" + ";" + name1 + "("
                + priority1 + ")" + ";" + name1 + "(" + priority1 + ")" + ";";

        assertEquals("Após inserção de dois nomes amobos deve ser exibidos respeitando a ordem", expected, out);
    }

    @Test
    public void testAddRepeatedPriorityOnMiddle() {

        fila.add(name1, priority1);
        fila.add(name2, priority2);
        fila.add(name3, priority3);
        fila.add(name2, priority2);
        String out = fila.show();

        String expected = name3 + "(" + priority3 + ")" + ";" + name2 + "(" + priority2 + ")" + ";" + name2 + "("
                + priority2 + ")" + ";" + name1 + "(" + priority1 + ")" + ";";

        assertEquals("Após inserção de dois nomes amobos deve ser exibidos respeitando a ordem", expected, out);
    }

    @Test
    public void testRemoveOnEmptyList() {

        No removido = fila.remove();

        assertEquals("Remoção de uma fila vazia deve retornar null", null, removido);
    }

    @Test
    public void testRemoveLastItem() {

        fila.add(name1, priority1);

        String nome = fila.remove().getName();
        boolean vazia = fila.isEmpty();

        assertEquals("Deve ser removido o nome que estava no início da fila", name1, nome);
        assertTrue("A Fila ficou fazia", vazia);
    }

    @Test
    public void testRemoveStart() {

        fila.add(name1, priority1);
        fila.add(name2, priority2);

        String nome = fila.remove().getName();

        assertEquals("Deve ser removido o nome que estava no início da fila", name2, nome);
    }

    @Test
    public void testPeekOnEmptyQueue(){
        No primeiro = fila.peek();

        assertEquals("Se a fila está fazia o primeiro elemento é null", null, primeiro);
    }

    @Test
    public void testPeek(){
        fila.add(name1, priority1);

        No primeiro = fila.peek();

        assertEquals("Validando o primeiro elmento da fila", name1, primeiro.getName());
    }

}