package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Container<Double> doubleContainer = new Container<>(3.14);
        System.out.println("Valoare container: " + doubleContainer.getValue());
        doubleContainer.setValue(2.71);
        System.out.println("Valoare actualizata: " + doubleContainer.getValue());

        printTwice("77777");
        printTwice(7);

        System.out.println("Maximul dintre 42 si 17: " + max(42, 17));
        System.out.println("Maximul dintre Zebra si Mango: " + max("Zebra", "Mango"));

        List<String> names = Arrays.asList("Hagi", "Ronaldo", "Mesi");
        System.out.println("Elemente: " + countElements(names));

        List<Integer> source = Arrays.asList(9, 5, 1);
        List<Number> destination = new ArrayList<>();
        copy(source, destination);
        System.out.println("Destinatie: " + destination);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("Ananas");
        stack.push("Cocos");
        System.out.println("Peek top: " + stack.peek());
        System.out.println("Pop top: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }

    static class Container<T> {
        private T value;

        public Container(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    public static int countElements(List<?> list) {
        return list.size();
    }

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
    }

    static class GenericStack<T> {
        private List<T> elements;

        public GenericStack() {
            this.elements = new ArrayList<>();
        }

        public void push(T item) {
            elements.add(item);
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            return elements.remove(elements.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return elements.get(elements.size() - 1);
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }
}