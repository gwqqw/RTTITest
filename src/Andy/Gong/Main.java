package Andy.Gong;

import java.util.ArrayList;
import java.util.List;

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class CountedInteger{
    private static long counter;
    private final long id = counter++;
    public String toString() {return Long.toString(id);}
}

class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {this.type = type;}
    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; ++i)
                result.add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        testTypeCounter();
    }
    static void TestClassForName()
    {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }

    static void testTypeCounter()
    {
        FilledList<CountedInteger> f1 = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(f1.create(15));
    }
}
