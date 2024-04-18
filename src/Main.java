import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Book> Books = new ArrayList<>();
        List<Member> Members = new ArrayList<>();

        Book book1 = new Book("Batman: My one true love", "Yandisa Mdoda", 1234579L);
        Book book2 = new Book("Honey, I scammed the kids", "Junior Mosupye", 12345678L);
        Book book3 = new Book("How I became Galaxy Boy", "Uyathandwa", 286545367L);
        Book book4 = new Book("Bunny Hopping: The Snowstorm", "Andziso Mdaka", 5455677L);
        Book book5 = new Book("Scam Scam Redemption 2", "Asher Van Vrede", 28397485L);
        Book book6 = new Book("Bill Cosby", "Martin Macharaga", 82339352L);
        Book book7 = new Book("Billions with a B", "Uyathandwa", 759278572L);
        Book book8 = new Book("Suffering from success", "Mpho", 1010101L);

        Collections.addAll(Books, book1, book2, book3, book4, book5, book6, book7, book8);

        Member member1 = new Member("Mpho", "mphomachailo@gmail.com");
        Member member2 = new Member("Andzi", "junior@gmail.com");
        Member member3 = new Member("Martin", "Martin@gmail.com");
        Member member4 = new Member("Yandi", "Yandi@gmail.com");

        Collections.addAll(Members, member1, member2, member3, member4);

        MainMenu(Books, Members);
    }

    @SuppressWarnings("InfiniteRecursion")
    public static void MainMenu(List<Book> Books, List<Member> MemberList){

        System.out.print("""
                Welcome to the Library Management System
                (1) Add Member
                (2) Remove Member
                (3) Add Book
                (4) Remove Book
                (5) Search
                (6) Checkout
                (7) Close
                Please select one of the following options:""");

        Scanner Input = new Scanner(System.in);
        String choice = Input.nextLine();

        switch (choice) {
            case "1":
                AddMember(Books, MemberList);
                break;
            case "2":
                RemoveMember(MemberList);
                break;
            case "3":
                AddBook(Books);
                break;
            case "4":
                RemoveBook(Books);
                break;
            case "5":
                Search(Books);
            case "6":
                Checkout(Books, MemberList);
                break;
            case "7": System.exit(0);
            default: MainMenu(Books, MemberList);
        }
        MainMenu(Books, MemberList);
    }

    public static boolean CheckBook(String string, List<Book> Books) {
        for (Book book : Books) {
            if (Objects.equals(book.Title, string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckMember(String string, List<Member> MemberList) {
        for (Member member : MemberList) {
            if (Objects.equals(member.Name, string)) {
                return true;
            }
        }
        return false;
    }

    public static void AddMember(List<Book> Books, List<Member> MemberList) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter new member Name: ");
        String Name = Input.nextLine();

        System.out.println("Enter new member email address: ");
        String Email = Input.nextLine();
        Member.emailCheck(Email);

        System.out.println("Enter a book assigned to (N for No book): ");
        String NewBooks = Input.nextLine();

        int itemIndex;
        if (CheckBook(NewBooks, Books)) {
            for (itemIndex = 0; itemIndex < Books.size(); itemIndex++){
                if (Objects.equals(Books.get(itemIndex).Title, NewBooks)){
                    Member member5 = new Member(Name, Email, Books.get(itemIndex));
                    MemberList.addLast(member5);
                    break;
                }
            }
        } else if (Objects.equals(NewBooks, "N")) {
            Member member5 = new Member(Name, Email);
            MemberList.addLast(member5);
        } else {
            System.out.println("Please enter the right book name or N for no book.");
            AddMember(Books, MemberList);
        }
    }

    public static void RemoveMember(List<Member> MemberList){
        Scanner Input = new Scanner(System.in);
        System.out.println("Which member do you want to remove: ");
        String Name = Input.nextLine();

        while (!CheckMember(Name, MemberList)){
            System.out.println("We don't have that member. Please try again");
            Name = Input.nextLine();
        }

        for (int i = 0; i < MemberList.size(); i++){
                if (Objects.equals(MemberList.get(i).Name, Name)){
                    System.out.println(MemberList.get(i).Name + " has been removed");
                    MemberList.remove(i);
                    break;
                }
        }
    }

    public static void AddBook(List<Book> Books){
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter new book title: ");
        String BookTitle = Input.nextLine();

        System.out.println("Enter new book author: ");
        String BookAuthor = Input.nextLine();

        System.out.println("Type in the new book's ISBN: ");
        String isbn = Input.nextLine();
        long NewISBN = 0;
        while (NewISBN == 0){
            try {
                NewISBN = Long.parseLong(isbn);
            } catch(NumberFormatException ex){
                System.out.println("Enter a valid ISBN");
                isbn = Input.nextLine();
            }
        }
        Book book9 = new Book(BookTitle, BookAuthor, NewISBN);
        Books.add(book9);
    }

    public static void RemoveBook(List<Book> Books){
        System.out.println("List of Books");
        for (int b = 0; b < Books.size(); b++){
            int num = b + 1;
            System.out.println("(" + num + ") "+ Books.get(b).Title + " by " + Books.get(b).Author);
        }

        Scanner Input = new Scanner(System.in);
        System.out.print("Enter the name of the book you want to remove: ");
        String bookToRemove = Input.nextLine();

        while (!CheckBook(bookToRemove, Books)){
            System.out.println("That book is not in library. Please try again");
            bookToRemove = Input.nextLine();
        }

        for (int i = 0; i < Books.size(); i++){
            if (Objects.equals(Books.get(i).Title, bookToRemove)){
                System.out.println(Books.get(i).Title + " has been removed");
                Books.remove(i);
                break;
            }
        }
    }
    public static void Search(List<Book> Books){
        System.out.println("Enter the Title or Author of the book you're looking for");
        Scanner Input = new Scanner(System.in);
        String search = Input.nextLine();

        for (Book book : Books) {
            if ((Objects.equals(book.Title, search)) || (Objects.equals(book.Author, search))) {
                System.out.println(book.Title + " by " + book.Author + " is in the library.");
                return;
            }
        }
        System.out.println("We don't have a book by that name. Please try again");
    }



    public static void Checkout(List<Book> BookList, List<Member> MemberList){
        System.out.print("Enter the Title or Author of the book being checked out: ");
        Scanner Input = new Scanner(System.in);
        String search = Input.nextLine();

        System.out.print("Enter the name of the member checking out the book: ");
        String member = Input.nextLine();

        for (Book book : BookList) {
            if ((Objects.equals(book.Title, search)) && (book.IsAvailable)) {
                for (Member value : MemberList) {
                    if (Objects.equals(value.Name, member)) {
                        book.IsAvailable = false;
                        value.BorrowedBooks.add(book);
                        System.out.println(book.Title + " by " + book.Author + " has been checked out by " + value.Name);
                        return;
                    }
                }
            }
        }
        System.out.println("The book you've entered is unavailable or the member you've entered doesn't exist");
    }
}