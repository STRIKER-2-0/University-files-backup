import java.io.*;
import java.util.ArrayList;

public class Book implements Externalizable {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(year);
        out.writeInt(issueNumber);

        out.writeInt(authors.size());
        for(Externalizable ex:authors)
            ex.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String)in.readObject();
        year=in.readInt();
        issueNumber=in.readInt();

        int sizeAuthors=in.readInt();
        for(int i=0;i<sizeAuthors;i++){
            Author author=new Author();
            author.readExternal(in);
            authors.add(author);
        }
    }
}
