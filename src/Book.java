public class Book {
    String Title;
    String Author;
    Long ISBN;
    Boolean IsAvailable;

    public Book(String title, String author, Long isbn){
        this.Title = title;
        this.Author = author;
        this.ISBN = isbn;
        this.IsAvailable = true;
    }
}
