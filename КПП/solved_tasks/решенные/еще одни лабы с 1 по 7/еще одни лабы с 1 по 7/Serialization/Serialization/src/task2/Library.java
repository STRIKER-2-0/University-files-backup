package task2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Library implements Serializable{
    private static final long serialVersionUID = 1;
    private Random random = new Random();

    private ArrayList <BookStore> bookStores;
    private transient ArrayList <BookReader> registeredReaders;
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeInt(registeredReaders.size());
        for(BookReader bookReader : registeredReaders){
            out.writeObject(bookReader.getName());
            out.writeObject(bookReader.getSurname());
            out.writeInt(bookReader.getBookReaderNumber());
            out.writeInt(bookReader.getTakenBooks().size());

            for (Book book : bookReader.getTakenBooks()) {
                out.writeObject(book.getName());

                out.writeInt(book.getAuthors().size());
                for (Author author : book.getAuthors()) {
                    out.writeObject(author.getName());
                    out.writeObject(author.getSurname());
                }

                out.writeInt(book.getYearOfWriting());
                out.writeInt(book.getSeries());
            }
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();

        int readersCount = in.readInt();
        registeredReaders = new ArrayList<>();
        for (int i = 0; i < readersCount; i++) {
            String name = (String)in.readObject();
            String surname = (String)in.readObject();
            int bookReaderNumber = in.readInt();
            BookReader bookReader = new BookReader(name, surname, bookReaderNumber);

            int takenBooksCount = in.readInt();
            for (int j = 0; j < takenBooksCount; j++) {
                String bookName = (String)in.readObject();
                int authorsCount = in.readInt();

                ArrayList <Author> authors = new ArrayList<>();
                for (int k = 0; k < authorsCount; k++) {
                    String authorName = (String)in.readObject();
                    String authorSurname = (String)in.readObject();
                    Author author = new Author(authorName, authorSurname);

                    authors.add(author);
                }

                int yearOfWriting = in.readInt();
                int series = in.readInt();

                Book book = new Book(bookName, authors, yearOfWriting, series);
                bookReader.takeBook(book);
            }

            registeredReaders.add(bookReader);
        }
    }
}
