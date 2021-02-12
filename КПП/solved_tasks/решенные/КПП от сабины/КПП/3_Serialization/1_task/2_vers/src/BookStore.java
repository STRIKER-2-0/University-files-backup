import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BookStore implements Serializable {
    transient private ArrayList<Book> books;
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
    private void writeObject(ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeInt(books.size());

            for(Book b:books){
                out.writeObject(b.getName());
                out.writeInt(b.getYear());
                out.writeInt(b.getIssueNumber());

                out.writeInt(b.getAuthors().size());
                for(Author a:b.getAuthors()) {
                    out.writeObject(a.getFirstName());
                    out.writeObject(a.getSurname());
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in){
        try {
            in.defaultReadObject();
            books=new ArrayList<>();

            int size=in.readInt();

            for(int i=0;i<size;i++){
                books.add(new Book((String)in.readObject(),in.readInt(),in.readInt()));

                ArrayList<Author> authors=new ArrayList<>();
                int sizeAuthors=in.readInt();
                for(int j=0;j<sizeAuthors;j++)
                    authors.add(new Author((String)in.readObject(),(String) in.readObject()));
                books.get(i).setAuthors(authors);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
