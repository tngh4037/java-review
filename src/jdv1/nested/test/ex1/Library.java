package jdv1.nested.test.ex1;

public class Library {

    private Book[] books;
    private int bookCount;

    public Library(int size) {
        books = new Book[size];
        this.bookCount = 0;
    }

    public void addBook(String bookName, String author) {
        if (bookCount >= books.length) {
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }

        books[bookCount] = new Book(bookName, author);
        bookCount++;
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("도서 제목: " + books[i].bookName + ", 저자: " + books[i].author);
        }
    }

    private static class Book {
        private final String bookName;
        private final String author;

        public Book(String bookName, String author) {
            this.bookName = bookName;
            this.author = author;
        }
    }
}