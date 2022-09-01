package Nobilities.ex13;

//Implement data type Stack of maximum depth of 10 elements with two operations: push() and pop().
public class StackMain {

    public static void doSomething(Stack storage) {


        storage.push("ala");
        storage.push("ma");
        storage.push("kota");
        storage.push("kota");
        storage.push("kota");

        System.out.println("element = " + storage.pop());
        System.out.println("element = " + storage.pop());
        System.out.println("element = " + storage.pop());
        System.out.println("element = " + storage.pop());
        System.out.println("element = " + storage.pop());
    }
        public static void main(String[] args){
            doSomething(new ArrayStack());
            System.out.println("--------------------");
            doSomething(new OneElementStack());


        }

    public static class ArrayStack implements Stack {
        private String [] storage = new String[10];
        private int counter = 0;

        @Override
        public void push(String element) {
        storage[counter] = element;
        counter += 1;
        }

        @Override
        public String pop() {
            counter -= 1;
            String element = storage[counter];
            storage[counter] = null;
            return element;
        }
    }

    public static class OneElementStack implements Stack {
        String element;

        @Override
        public void push(String element) {
            this.element = element;
        }

        @Override
        public String pop() {
            String element = this.element;
            this.element = null;
            return element;
        }
    }

    public static interface Stack {

      void push(String element);
         String pop();
        }
}

