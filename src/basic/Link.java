package basic;

/**
 * Created by nagabharan on 30-Aug-16.
 */
public class Link {

    // Set to public so getters & setters aren't needed

    public String bookName;
    public int millionsSold;

    // Reference to next link made in the basic.LinkList
    // Holds the reference to the basic.Link that was created before it
    // Set to null until it is connected to other links

    public Link next;

    public Link(String bookName, int millionsSold) {

        this.bookName = bookName;
        this.millionsSold = millionsSold;

    }

    public static void main(String[] args) {

        LinkList theLinkedList = new LinkList();

        // Insert basic.Link and add a reference to the book basic.Link added just prior
        // to the field next

        theLinkedList.insertFirstLink("Don Quixote", 500);
        theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
        theLinkedList.insertFirstLink("The Lord of the Rings", 150);
        theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);

        theLinkedList.display();

        System.out.println("Value of first in basic.LinkedList " + theLinkedList.firstLink + "\n");

        // Removes the last basic.Link entered

        theLinkedList.removeFirst();

        theLinkedList.display();

        System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " Was Found");

        theLinkedList.removeLink("A Tale of Two Cities");

        System.out.println("\nA Tale of Two Cities Removed\n");

        theLinkedList.display();

    }

    public void display() {

        System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");

    }

    public String toString() {

        return bookName;

    }

}

class LinkList {

    // Reference to first basic.Link in list
    // The last basic.Link added to the basic.LinkedList

    public Link firstLink;

    LinkList() {

        // Here to show the first basic.Link always starts as null

        firstLink = null;

    }

    // Returns true if basic.LinkList is empty

    public boolean isEmpty() {

        return (firstLink == null);

    }

    public void insertFirstLink(String bookName, int millionsSold) {

        Link newLink = new Link(bookName, millionsSold);

        // Connects the firstLink field to the new basic.Link

        newLink.next = firstLink;

        firstLink = newLink;

    }

    public Link removeFirst() {

        Link linkReference = firstLink;

        if (!isEmpty()) {

            // Removes the basic.Link from the List

            firstLink = firstLink.next;

        } else {

            System.out.println("Empty basic.LinkedList");

        }

        return linkReference;

    }

    public void display() {

        Link theLink = firstLink;

        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every basic.Link until next returns null

        while (theLink != null) {

            theLink.display();

            System.out.println("Next basic.Link: " + theLink.next);

            theLink = theLink.next;

            System.out.println();

        }

    }

    public Link find(String bookName) {

        Link theLink = firstLink;

        if (!isEmpty()) {

            while (theLink.bookName != bookName) {

                // Checks if at the end of the basic.LinkedList

                if (theLink.next == null) {

                    // Got to the end of the Links in basic.LinkedList
                    // without finding a match

                    return null;

                } else {

                    // Found a matching basic.Link in the basic.LinkedList

                    theLink = theLink.next;

                }

            }

        } else {

            System.out.println("Empty basic.LinkedList");

        }

        return theLink;

    }

    public Link removeLink(String bookName) {

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        // Keep searching as long as a match isn't made

        while (currentLink.bookName != bookName) {

            // Check if at the last basic.Link in the basic.LinkedList

            if (currentLink.next == null) {

                // bookName not found so leave the method

                return null;

            } else {

                // We checked here so let's look in the
                // next basic.Link on the list

                previousLink = currentLink;

                currentLink = currentLink.next;

            }

        }

        if (currentLink == firstLink) {

            // If you are here that means there was a match
            // in the reference stored in firstLink in the
            // basic.LinkedList so just assign next to firstLink

            firstLink = firstLink.next;

        } else {

            // If you are here there was a match in a basic.Link other
            // than the firstLink. Assign the value of next for
            // the basic.Link you want to delete to the basic.Link that's
            // next previously pointed to the reference to remove

            System.out.println("FOUND A MATCH");
            System.out.println("currentLink: " + currentLink);
            System.out.println("firstLink: " + firstLink);

            previousLink.next = currentLink.next;

        }

        return currentLink;

    }

}