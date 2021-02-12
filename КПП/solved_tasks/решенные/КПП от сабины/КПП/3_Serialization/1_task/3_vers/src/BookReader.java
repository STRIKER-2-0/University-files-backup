import java.io.*;
import java.util.ArrayList;

public class BookReader extends Human implements Externalizable {
    private int regNumber;
    private ArrayList<Book> books;

    public BookReader(){
        super();
        books=new ArrayList<>();
    }

    public BookReader(String firstName, String surname,int regNumber) {
        super(firstName, surname);
        this.regNumber=regNumber;
        books=new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public int getRegNumber() {
        return regNumber;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("Читатель с рег.номером: "+regNumber+"\nЧитает: ");
        for(Book b:books)
            str.append(b+"\n");
        return str.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getFirstName());
        out.writeObject(getSurname());
        out.writeInt(regNumber);

        out.writeInt(books.size());
        for(Externalizable ext:books)
            ext.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setFirstName((String)in.readObject());
        setSurname((String)in.readObject());
        setRegNumber(in.readInt());

        int sizeBooks=in.readInt();
        for(int i=0;i<sizeBooks;i++){
            Book book=new Book();
            book.readExternal(in);
            books.add(book);
        }
    }
}
