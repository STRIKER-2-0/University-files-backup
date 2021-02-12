package copy;

import java.util.ArrayList;
import java.util.Random;

public class Library{
    private static final long serialVersionUID = 1;
    private Random random = new Random();

    private ArrayList <BookStore> bookStores;
    private ArrayList <BookReader> registeredReaders;
    private String name;

    public Library(String name){
        this.name = name;
        this.bookStores = new ArrayList<>();
        this.registeredReaders = new ArrayList<>();
    }

    public Library(String name, ArrayList <BookStore> bookStores){
        this.bookStores = bookStores;
        this.name = name;
        this.registeredReaders = new ArrayList<>();
    }

    public void addBookStore(BookStore bookStore){
        bookStores.add(bookStore);
    }

    public Book giveBook(){
        int bookStore = random.nextInt(bookStores.size());
        return bookStores.get(bookStore).getBook();
    }

    public void registerReader(BookReader bookReader){
        registeredReaders.add(bookReader);
    }

    public String getName(){
        return name;
    }

    public String toString(){
        String libraryString = "===== Library =====\n";
        libraryString += "Name: " + name + "\n\n";

        libraryString += "===== Book Stores: =====\n";
        int i = 0;
        for (BookStore bookStore: bookStores)
            libraryString += (++i) + ") " + bookStore.toString() + "\n";

        libraryString += "\n===== Registered readers: =====\n";
        i = 0;
        for (BookReader bookReader : registeredReaders)
            libraryString += (++i) +") " + bookReader.toString() + "\n\n";

        return libraryString;
    }
}
