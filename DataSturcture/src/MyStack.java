import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    private List<T> inner = new ArrayList<>();
    private String name;

    public MyStack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void push(T e) {
        inner.add(e);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        return inner.remove(inner.size() - 1);
    }

    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek at an empty stack.");
        }
        return inner.get(inner.size() - 1);
    }

    public boolean isEmpty() {
        return inner.isEmpty();
    }

    public void printStack() {
        System.out.print(name + "|- ");
        if (inner.isEmpty()) {
            System.out.print("(empty)");
        } else {
            for (T element : inner) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }
}
