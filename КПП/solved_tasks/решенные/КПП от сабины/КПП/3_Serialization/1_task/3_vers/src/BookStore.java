import java.io.*;
import java.util.ArrayList;

public class BookStore implements Externalizable {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);

        out.writeInt(books.size());
        for(Externalizable ex:books)
            ex.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String) in.readObject();

        int sizeBooks=in.readInt();
        for(int i=0;i<sizeBooks;i++){
            Book book=new Book();
            book.readExternal(in);
            books.add(book);
        }
    }
}
