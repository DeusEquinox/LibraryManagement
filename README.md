Library Management System

A Simple Library Management System in Java. 
It allows users to add and remove members and books, searching for books, and checking out books to members.

Two main classes: Book and Member. Allowing for better organization, encapsulation, and reusability of code.
Lists are used to store books and members. Lists provide dynamic resizing, efficient random access, and convenient methods for adding and removing elements.
The MainMenu method displays a menu of options for users to choose from. A switch statement is used to execute the corresponding function based on user input.

The code handles invalid inputs gracefully by prompting users to re-enter valid data.
The code checks if the member or book exists in the respective lists Before performing operations.

The Book Class represents a book with attributes such as title, author, and ISBN. It also includes a boolean attribute IsAvailable to track whether the book is currently available for checkout.
Member Class represents a library member with attributes like name and email. It maintains a list of borrowed books.
Main Class contains the main method to start the program execution.
Helper Methods are defined to perform specific tasks such as adding/removing members/books, checking book/member existence, and handling checkout operations.

Users can add a new member by providing their name and email address.
Members can be removed from the system by specifying their name.
New books can be added with details such as title, author, and ISBN.
Books can be removed from the library by specifying their title.
Users can search for books by title or author.
Members can check out books if they are available in the library.

Recursion
The MainMenu method uses recursion to continuously display the menu after each operation until the user chooses to exit the program.
