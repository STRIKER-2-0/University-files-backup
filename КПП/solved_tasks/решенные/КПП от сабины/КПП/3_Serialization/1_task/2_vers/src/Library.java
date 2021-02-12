import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private String name;
    private ArrayList<BookStore> bookStores;
    transient private ArrayList<BookReader> bookReaders;

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
    private void writeObject(ObjectOutputStream out) {
        try {
            out.defaultWriteObject();
            out.writeInt(bookReaders.size());

            for(BookReader b:bookReaders){
                out.writeObject(b.getFirstName());
                out.writeObject(b.getSurname());
                out.writeInt(b.getRegNumber());

                out.writeInt(b.getBooks().size());
                for(Book book:b.getBooks()){
                    out.writeObject(book.getName());
                    out.writeInt(book.getYear());
                    out.writeInt(book.getIssueNumber());

                    out.writeInt(book.getAuthors().size());
                    for(Author a:book.getAuthors()) {
                        out.writeObject(a.getFirstName());
                        out.writeObject(a.getSurname());
                    }
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
            bookReaders=new ArrayList<>();

            int size=in.readInt();

            for(int i=0;i<size;i++){
                bookReaders.add(new BookReader((String)in.readObject(),(String)in.readObject(),in.readInt()));

                int sizeBooks=in.readInt();


                for(int j=0;j<sizeBooks;j++){
                    bookReaders.get(i).getBooks().add(new Book((String)in.readObject(),in.readInt(),in.readInt()));

                    ArrayList<Author> authors=new ArrayList<>();
                    int sizeAuthors=in.readInt();
                    for(int k=0;k<sizeAuthors;k++)
                        authors.add(new Author((String)in.readObject(),(String) in.readObject()));
                    bookReaders.get(i).getBooks().get(j).setAuthors(authors);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
