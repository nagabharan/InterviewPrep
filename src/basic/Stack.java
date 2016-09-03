package basic; /**
 * Created by nagabharan on 30-Aug-16.
 */
// Arrays, linked lists, trees, etc. are best for
// data that represents real objects.

// Stacks & Queues are instead used to complete a
// task and are soon after discarded.

// Stacks & Queues
// 1. Allow only a single item to be added or removed at a time
// 2. Stacks allow access to the last item inserted (LIFO)
// 3. Queues allow access to the first item inserted (FIFO)

import java.util.Arrays;

public class Stack {

    private String[] stackArray;
    private int stackSize;

    // Sets stack as empty

    private int topOfStack = -1;

    Stack(int size) {

        stackSize = size;

        stackArray = new String[size];

        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen

        Arrays.fill(stackArray, "-1");

    }

    public static void main(String[] args) {

        Stack Stack = new Stack(10);

        Stack.push("10");
        Stack.push("17");
        Stack.push("13");

        // Look at the top value on the stack

        Stack.peek();

        // Remove values from the stack (LIFO)

        Stack.pop();
        Stack.pop();
        Stack.pop();

        // Add many to the stack

        Stack.pushMany("R E D R U M");

        // Remove all from the stack

        // basic.Stack.popAll();

        // Remove all from the stack and print them

        Stack.popDisplayAll();

        Stack.displayStack();


    }

    public void push(String input) {

        if (topOfStack + 1 < stackSize) {

            topOfStack++;

            stackArray[topOfStack] = input;

        } else System.out.println("Sorry But the basic.Stack is Full");

        displayStack();

        System.out.println("PUSH " + input + " Was Added to the basic.Stack\n");

    }

    public String pop() {

        if (topOfStack >= 0) {

            displayStack();

            System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the basic.Stack\n");

            // Just like in memory an item isn't deleted, but instead is just not available

            stackArray[topOfStack] = "-1"; // Assigns -1 so the value won't appear

            return stackArray[topOfStack--];


        } else {

            displayStack();

            System.out.println("Sorry But the basic.Stack is Empty");

            return "-1";
        }


    }

    public String peek() {

        displayStack();

        System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the basic.Stack\n");

        return stackArray[topOfStack];

    }

    public void pushMany(String multipleValues) {

        String[] tempString = multipleValues.split(" ");

        for (int i = 0; i < tempString.length; i++) {

            push(tempString[i]);

        }

    }

    public void popAll() {

        for (int i = topOfStack; i >= 0; i--) {

            pop();

        }

    }

    public void popDisplayAll() {

        String theReverse = "";

        for (int i = topOfStack; i >= 0; i--) {

            theReverse += stackArray[i];

        }

        System.out.println("The Reverse: " + theReverse);

        popAll();

    }

    public void displayStack() {

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < stackSize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < stackSize; n++) {


            if (stackArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s " + " ", stackArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

    }

}
