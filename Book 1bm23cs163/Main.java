import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private int price;
    private int numPages;

    public Book(String name, String author, int price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book name: " + name + "\nAuthor: " + author + "\nPrice: " + price + "\nPages: " + numPages + "\n";
    }
}

class Main { // Removed the public access modifier
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Price: ");
            int price = scanner.nextInt();
            System.out.print("Number of pages: ");
            int numPages = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            books[i] = new Book(name, author, price, numPages);
        }

        System.out.println("\nBook Details:");
        for (Book book : books) {
            System.out.println(book);
        }

        scanner.close();
    }
}