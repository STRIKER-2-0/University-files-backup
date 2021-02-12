package task3;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

public class BookReader extends Human {
    private int bookReaderNumber;
    private ArrayList<Book> takenBooks;

    public BookReader(String name, String surname, int bookReaderNumber){
        setName(name);
        setSurname(surname);
        this.bookReaderNumber = bookReaderNumber;
        this.takenBooks = new ArrayList<>();
    }

    public BookReader(){
        this("No name", "No surname", 0);
    }

    public void takeBook(Book book){
        takenBooks.add(book);
    }

    public ArrayList<Book> getTakenBooks(){
        return takenBooks;
    }

    public int getBookReaderNumber() {
        return bookReaderNumber;
    }

    public void setBookReaderNumber(int bookReaderNumber) {
        this.bookReaderNumber = bookReaderNumber;
    }

    public String toString(){
        String bookReaderString = "";
        bookReaderString += "Reader number: " + bookReaderNumber +"\n";
        bookReaderString += super.toString() + "\n";
        bookReaderString += "Taken books:\n";
        for(Book book: takenBooks)
            bookReaderString += book.toString();

        return bookReaderString;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(bookReaderNumber);

        out.writeInt(takenBooks.size());
        for (Book book : takenBooks)
            book.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        bookReaderNumber = in.readInt();

        int booksCount = in.readInt();
        takenBooks = new ArrayList<>();
        for (int i = 0; i < booksCount; i++) {
            Book takenBook = new Book();
            takenBook.readExternal(in);

            takenBooks.add(takenBook);
        }
    }
}
