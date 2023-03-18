import java.awt.print.Book;

public class Books {
        private String author;
        private String genre;
        private Double price;
        private String publisher;
        private Double rating;
        private String title;

    public Books(String author, String genre, Double price, String publisher, Double rating, String title) {
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.publisher = publisher;
        this.rating = rating;
        this.title = title;
    }
    public Books() {
        this.author = "Jk Rowling";
        this.genre = "Fantasy";
        this.price = 19.99;
        this.publisher = "Penguin Publishing";
        this.rating = 60.50;
        this.title = "HP";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "The Book is " + title + " The author is " + author;
    }
}
