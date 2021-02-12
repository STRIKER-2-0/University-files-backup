import java.io.Serializable;
import java.util.ArrayList;

public class BookStore implements Serializable {
    private ArrayList<Book> books;
    private String name;

    public BookStore(){
        books=new ArrayList<>();
        name=new String();
    }

    public BookStore(String name){
        books=new ArrayList<>();
        this.name=name;
    }

    public BookStore(ArrayList<Book> books, String name) {
        this.books = books;
        this.name = name;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("Книжная полка: "+name+"\n");
        for (Book book:books)
            str.append(book);
        return str.toString();
    }
}
