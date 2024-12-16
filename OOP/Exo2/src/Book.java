import java.util.ArrayList;

public class Book extends  LibraryItem  {
     private String author;
     private String gender;
     private ArrayList<LibraryItem> collections;

    public Book(int id, String title, int publicationYear, String author, String gender) {
        super(id, title, publicationYear);
        this.author = author;
        this.gender = gender;
    }

    public String getAuthor() {
        return author;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String getDetail(){
        return "Livre : [ " + "Title :"  + title + ",Auteur :" + author+ ",Genre: " + gender + "Année : "+ publicationYear + "]";
    }

    public void displayCollection() {
    for (LibraryItem item : collections) {
        System.out.println(item);
    }
    }
}
