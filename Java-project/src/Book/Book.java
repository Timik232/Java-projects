package Book;

public class Book {
    String author;
    int year;
    String name;
    Book(String author, int year, String name){
        this.author = author;
        this.year = year;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", year=" + year +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
