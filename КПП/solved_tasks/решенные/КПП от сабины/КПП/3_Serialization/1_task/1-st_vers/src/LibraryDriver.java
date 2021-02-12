import java.io.*;
import java.util.ArrayList;

public class LibraryDriver {
    public static void main(String[] args) {
        Library library=new Library("MyLib");

        Book book1=new Book();
        book1.addAuthor(new Author("Autor","ofMathBook"));
        book1.setName("MathBook");
        book1.setIssueNumber(8);
        book1.setYear(1998);

        Book book2=new Book();
        book2.addAuthor(new Author("Autor","ofChemistryBook"));
        book2.setName("ChemistryBook");
        book2.setIssueNumber(3);
        book2.setYear(1990);

        Book book3=new Book();
        book3.addAuthor(new Author("Autor","ofPhisicsBook"));
        book3.setName("PhisicsBook");
        book3.setIssueNumber(1);
        book3.setYear(1996);

        ArrayList<BookReader> bookReaders=new ArrayList();
        bookReaders.add(new BookReader("Ivan","Ivanov",1));
        bookReaders.get(0).addBook(book1);bookReaders.get(0).addBook(book3);
        bookReaders.add(new BookReader("Sidor","Sidorov",2));
        bookReaders.get(1).addBook(book3);bookReaders.get(1).addBook(book2);
        bookReaders.add(new BookReader("Vasya","Petrow",3));
        bookReaders.get(2).addBook(book3);bookReaders.get(2).addBook(book2);bookReaders.get(2).addBook(book1);


        ArrayList<BookStore> bookStores=new ArrayList();
        bookStores.add(new BookStore("Math"));
        bookStores.get(0).addBook(book1);
        bookStores.add(new BookStore("Chemistry"));
        bookStores.get(1).addBook(book2);
        bookStores.add(new BookStore("Phisics"));
        bookStores.get(2).addBook(book3);

        library.setBookReaders(bookReaders);
        library.setBookStores(bookStores);

        String strLib1=library.toString(),strLib2;

        System.out.println(library+"\n\n");
        System.out.println("Ser");
        serObj("lib.ser",library);
        System.out.println("Deser");
        library=(Library) deserObj("lib.ser");

        strLib2=library.toString();
        System.out.println(library);

        if(strLib1.equals(strLib2)) System.out.println("Сериализ/десериал прошла успешно");
    }
    public static void serObj(String fileName,Object obj){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(obj);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object deserObj(String fileName){
        Object obj=null;
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
            obj=ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
