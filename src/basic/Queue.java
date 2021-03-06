package basic; /**
 * Created by nagabharan on 30-Aug-16.
 */

import java.util.Arrays;


public class Queue {

    private String[] queueArray;
    private int queueSize;

    // Sets stack as empty

    private int front, numberOfItems, rear = 0;

    Queue(int size) {

        queueSize = size;

        queueArray = new String[size];

        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen

        Arrays.fill(queueArray, "-1");

    }

    public static void main(String[] args) {

        Queue Queue = new Queue(10);

        Queue.priorityInsert("16");

        Queue.priorityInsert("25");

        Queue.priorityInsert("10");

		/*
        basic.Queue.insert("10");

		basic.Queue.displayQueue();

		basic.Queue.insert("15");

		basic.Queue.displayQueue();

		basic.Queue.insert("25");

		basic.Queue.displayQueue();

		basic.Queue.insert("25");

		basic.Queue.displayQueue();

		basic.Queue.insert("25");
		*/

        Queue.displayQueue();

        Queue.remove();

        Queue.displayQueue();

        Queue.remove();

        Queue.displayQueue();

        Queue.peek();

    }

    // This priority insert will add items in order from high to low

    public void insert(String input) {

        if (numberOfItems + 1 <= queueSize) {

            queueArray[rear] = input;

            rear++;

            numberOfItems++;

            System.out.println("INSERT " + input + " Was Added to the basic.Stack\n");

        } else {

            System.out.println("Sorry But the basic.Queue is Full");

        }

    }

    public void priorityInsert(String input) {

        int i;

        if (numberOfItems == 0) {

            insert(input);

        } else {

            for (i = numberOfItems - 1; i >= 0; i--) {

                if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {

                    queueArray[i + 1] = queueArray[i];

                } else break; // Done shifting items in queue

            }

            queueArray[i + 1] = input;

            rear++;

            numberOfItems++;

        }

    }

    public void remove() {

        if (numberOfItems > 0) {

            System.out.println("REMOVE " + queueArray[front] + " Was Removed From the basic.Queue\n");

            // Just like in memory an item isn't deleted, but instead is just not available

            queueArray[front] = "-1";

            front++;

            numberOfItems--;

        } else {

            System.out.println("Sorry But the basic.Queue is Empty");


        }

    }

    public void peek() {

        System.out.println("The First Element is " + queueArray[front]);

    }

    public void displayQueue() {

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {


            if (queueArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s " + " ", queueArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        // Number of spaces to put before the F

        int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

        for (int k = 1; k < spacesBeforeFront; k++) System.out.print(" ");

        System.out.print("F");

        // Number of spaces to put before the R

        int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

        for (int l = 0; l < spacesBeforeRear; l++) System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }

}
