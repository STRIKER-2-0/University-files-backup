import java.io.*;
import java.util.ArrayList;

public class Library implements Externalizable {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);

        out.writeInt(bookStores.size());
        for(Externalizable ex:bookStores)
            ex.writeExternal(out);

        out.writeInt(bookReaders.size());
        for(Externalizable ex:bookReaders)
            ex.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String) in.readObject();

        int size=in.readInt();
        for(int i=0;i<size;i++){
            BookStore bookStore=new BookStore();
            bookStore.readExternal(in);
            bookStores.add(bookStore);
        }

        size=in.readInt();
        for(int i=0;i<size;i++){
            BookReader bookReader=new BookReader();
            bookReader.readExternal(in);
            bookReaders.add(bookReader);
        }
    }
}
