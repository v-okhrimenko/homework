package ua.ithillel.task12;

public class Runner {
    public void run() {
        MyPhoneBook myPhoneBook = new MyPhoneBook();

        myPhoneBook.addPhoneNumber("Sergiy", "+380984387623");
        myPhoneBook.addPhoneNumber("Kolya", "+380661234503");
        myPhoneBook.addPhoneNumber("Masha", "+380674325698");
        myPhoneBook.addPhoneNumber("Alex", "+380678629998");
        myPhoneBook.addPhoneNumber("Zoryzn", "+380683245321");

        myPhoneBook.printPhoneBook();

        System.out.println();
        System.out.println("Sort by name");
        myPhoneBook.sortByName();

        System.out.println();
        System.out.println("Sort by PhoneNumber");
        myPhoneBook.sortByPhoneNumber();
    }
}
