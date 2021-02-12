import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private String name;
    private ArrayList<Author> authors;
    private int year;
    private int issueNumber;

    public Book(){
        name=new String();
        authors=new ArrayList<>();
    }

    public Book(String name, ArrayList<Author> authors, int year, int issueNumber) {
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.issueNumber = issueNumber;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("Книга: "+name+"\nАвторы: ");
        for(Author a:authors)
            str.append(a+"; ");
        str.append("\nГод издания: "+year+"\nНомер издания: "+issueNumber);

        return str.toString();
    }
}
