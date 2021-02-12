package task3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Random;

public class Library implements Externalizable{
    private Random random = new Random();

    private ArrayList <BookStore> bookStores;
    private ArrayList <BookReader> registeredReaders;
    private String name;

    public Library(String name){
        this.name = name;
        this.bookStores = new ArrayList<>();
        this.registeredReaders = new ArrayList<>();
    }

    public Library(){
        this("No name");
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);

        out.writeInt(bookStores.size());
        for(BookStore bookStore : bookStores)
            bookStore.writeExternal(out);

        out.writeInt(registeredReaders.size());
        for (BookReader bookReader : registeredReaders)
            bookReader.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();

        int bookStoreCount = in.readInt();
        bookStores = new ArrayList<>();
        for (int i = 0; i < bookStoreCount; i++) {
            BookStore bookStore = new BookStore();
            bookStore.readExternal(in);

            bookStores.add(bookStore);
        }

        int registeredReadersCount = in.readInt();
        registeredReaders = new ArrayList<>();
        for (int i = 0; i < registeredReadersCount; i++) {
            BookReader bookReader = new BookReader();
            bookReader.readExternal(in);

            registeredReaders.add(bookReader);
        }
    }
}
