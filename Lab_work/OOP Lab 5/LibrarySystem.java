import java.util.Arrays;

class Publication {
    private String bookCode;
    private String bookTitle;
    private String writer;
    private int availableStock;
    private double[] reviews;

    Publication() {
        bookCode = "----";
        bookTitle = "----";
        writer = "----";
        availableStock = 0;
        reviews = new double[5];
    }

    public Publication(String code, String title, String author, int stock, double[] ratings) {
        this.bookCode = code;
        this.bookTitle = title;
        this.writer = author;
        this.availableStock = stock;
        this.reviews = ratings;
    }

    public Publication(Publication otherPublication) {
        this.bookCode = otherPublication.bookCode;
        this.bookTitle = otherPublication.bookTitle;
        this.writer = otherPublication.writer;
        this.availableStock = otherPublication.availableStock;
        this.reviews = otherPublication.reviews;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriter() {
        return writer;
    }

    public void setAvailableStock(int availableStock) {
        if (availableStock > 0) {
            this.availableStock = availableStock;
        } else {
            System.out.println("Available stock cannot be negative...");
        }
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setReviews(double[] reviews) {
        int count = 0;
        while (count < 5) {
            if (reviews[count] >= 0.0 && reviews[count] <= 5.0) {
                this.reviews = reviews;
                count++;
            }
        }
    }

    public double computeAverageRating() {
        double sum = 0.0;
        for (double review : reviews) {
            sum += review;
        }
        return sum / reviews.length;
    }

    public Publication createDeepCopy() {
        return new Publication(this);
    }

    public boolean isEqual(Publication otherPublication) {
        return this.bookCode.equals(otherPublication.bookCode) &&
                this.bookTitle.equals(otherPublication.bookTitle) &&
                this.writer.equals(otherPublication.writer) &&
                Arrays.equals(this.reviews, otherPublication.reviews);
    }

    public static Publication findHighestRated(Publication[] publications) {
        Publication highestRated = publications[0];
        for (Publication pub : publications) {
            if (pub.computeAverageRating() > highestRated.computeAverageRating()) {
                highestRated = pub;
            }
        }
        return highestRated;
    }

    public String toString() {
        return "Book Code: " + bookCode +
                "\nBook Title: " + bookTitle +
                "\nWriter: " + writer +
                "\nAvailable Stock: " + availableStock +
                "\nReviews: " + Arrays.toString(reviews) +
                "\nAverage Rating: " + computeAverageRating();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Publication pub1 = new Publication();
        System.out.println("Default Constructor...\n");
        
        Publication pub2 = new Publication("978-92-95055-02-5", "OOP Concepts", "Ali Hassan", 5, new double[]{1.5, 1.6, 1.8, 1.7, 1.5});
        System.out.println(pub2);
        
        Publication pub3 = new Publication("928-569-56943-9393-79", "Database Systems", "Ali Hassan", 5, new double[]{1.6, 1.7, 1.8, 1.9, 1.8});
        System.out.println("\nAnother Book Data (Parameterized Constructor)...\n");
        System.out.println(pub3);
        
        Publication pub4 = new Publication(pub2);
        System.out.println("\nCopy Constructor...\n");
        System.out.println(pub4);
        
        System.out.println("\nDeep Copy Method...\n");
        Publication pub5 = pub2.createDeepCopy();
        System.out.println(pub5);
        
        Publication[] publications = {pub1, pub3, pub2, pub4};
        Publication highestRated = Publication.findHighestRated(publications);
        System.out.println("\nHighest Rated Book...");
        System.out.println(highestRated);
    }
}
