package Nobilities.ex14;

public class SetMain {
    public static void doSomething(MySet storage) {


        storage.add("ala");
        storage.add("ma");
        storage.add("kota");
        storage.add("kota");


        System.out.println("element = " + storage.contains("afla"));
        System.out.println("element = " + storage.contains("ma"));
        System.out.println("element = " + storage.contains("kota"));

        System.out.println("size = " + storage.size());
    }

    public static void main(String[] args) {
        doSomething(new ArraSet());


    }
}
interface  MySet{
    void add (String element);
    boolean contains(String element);

    int size();

}
class ArraSet implements MySet {
    private String[] storage = new String[100];
    private int counter = 0;

    @Override
    public int size(){
        return counter;
    }

    @Override
    public void add(String element) {
        if (!this.contains(element)) {
            storage[counter] = element;
            counter += 1;
        }
    }
    @Override
    public boolean contains(String element) {
        for (int i = 0; i < counter; i++) {
            String stored = storage[i];
            if (stored.equals(element)) {
                return true;
            }

        }
        return false;

    }
}