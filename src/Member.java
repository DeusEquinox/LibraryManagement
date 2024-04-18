import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Member {
    String Name;
    String Email;
    List<Book> BorrowedBooks = new ArrayList<>();

    public Member(String name, String email, Book book) {
        this.Name = name;
        this.BorrowedBooks.add(book);
        emailCheck(email);
        this.Email = email;
    }

    public Member(String name, String email) {
        this.Name = name;
        this.Email = email;
    }

    public static void emailCheck(String email){
        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            while (!matcher.matches()) {
                System.out.print("Please enter a valid email: ");
                Scanner Input = new Scanner(System.in);
                email = Input.nextLine();
                matcher = pattern.matcher(email);
            }
        }
    }
}
