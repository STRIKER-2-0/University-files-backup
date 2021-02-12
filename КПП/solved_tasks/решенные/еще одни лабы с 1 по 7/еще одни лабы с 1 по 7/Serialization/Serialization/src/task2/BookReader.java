package task2;

import java.util.ArrayList;

public class BookReader extends Human{
    private int bookReaderNumber;
    private ArrayList<Book> takenBooks;

    public BookReader(String name, String surname, int bookReaderNumber){
        setName(name);
        setSurname(surname);
        this.bookReaderNumber = bookReaderNumber;
        this.takenBooks = new ArrayList<>();
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
}
