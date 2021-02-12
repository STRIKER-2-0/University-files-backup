package task1;

import java.util.Random;

public class Main {
    private static final String [] names = {"Francesco", "Pavel", "Gracia", "Abraham", "Rik", "Rico"};
    private static final String [] surnames = {"Graims", "Kadler", "Gurira", "Ricks", "Alavar", "Kadrow"};
    private static final String [] subjects = {"Drama", "History", "Adventure"};
    private static final String [] bookNames = {"Little ponies", "S.T.A.L.K.E.R. 2",
            "Life and illusion", "All about healthy food", "Ukraine and History"};

    public static Random random = new Random();

    public static void main(String[] args) {
        Library library = new Library("Saint Lucie public library");

        for (int i = 0; i < subjects.length; i++) {
            BookStore bookStore = new BookStore(subjects[i]);

            int bookCount = random.nextInt(2) + 2;
            for (int j = 0; j < bookCount; j++) {
                String name = names[random.nextInt(names.length)];
                String surname = names[random.nextInt(surnames.length)];
                Author author = new Author(name, surname);
                String bookName = bookNames[random.nextInt(bookNames.length)];
                int year = random.nextInt(100) + 1916;
                int series = random.nextInt(100);
                Book book = new Book(bookName, author, year, series);
                bookStore.addBook(book);
            }

            library.addBookStore(bookStore);
        }

        for (int i = 0; i < 3; i++) {
            String name = names[random.nextInt(names.length)];
            String surname = names[random.nextInt(surnames.length)];
            int readerID = random.nextInt(10000000);
            BookReader reader = new BookReader(name, surname, readerID);
            reader.takeBook(library.giveBook());
            library.registerReader(reader);
        }
        System.out.println("******************* Before: ******************* ");
        System.out.println(library);

        System.out.println("******************* After: ******************* ");
        Serializer.serializeObject(library);
        System.out.println(Serializer.deserializeObject());
    }
}
