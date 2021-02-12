import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private String name;
    private ArrayList<BookStore> bookStores;
    private ArrayList<BookReader> bookReaders;

    public Library(){
        name=new String();
        bookStores=new ArrayList<>();
        bookReaders=new ArrayList<>();
    }

    public Library(String name){
        this.name=name;
        bookStores=new ArrayList<>();
        bookReaders=new ArrayList<>();
    }

    public void addBookReader(BookReader bookReader){
        bookReaders.add(bookReader);
    }
    public void addBookStore(BookStore bookStore){
        bookStores.add(bookStore);
    }

    public String getName() {
        return name;
    }

    public ArrayList<BookStore> getBookStores() {
        return bookStores;
    }

    public ArrayList<BookReader> getBookReaders() {
        return bookReaders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookStores(ArrayList<BookStore> bookStores) {
        this.bookStores = bookStores;
    }

    public void setBookReaders(ArrayList<BookReader> bookReaders) {
        this.bookReaders = bookReaders;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("Библиотека: "+name+"\n");
        str.append("Книжные полки:\n");
        for(BookStore bookStore:bookStores)
            str.append(bookStore+"\n");
        str.append("\nЧитатели:\n");
        for(BookReader bookReader:bookReaders)
            str.append(bookReader+"\n");
        return str.toString();
    }
}
