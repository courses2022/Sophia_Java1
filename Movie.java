// Class Movie stores information about movie such as movie name, director, year.
// Also it has information about who borrowed the movie and on which date
public class Movie {
    private String movieName;
    private String director;
    private int year;
    private String borrower;
    private String borrowedDate;

    public Movie(String movieName, String director, int year) {
        this.movieName = movieName;
        this.director = director;
        this.year = year;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Override
    public String toString() {
        return movieName + ", " + director + ", " + year;
    }   

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Movie)) {
            return false;
        } else {
            Movie movie = (Movie) obj;
            return movieName.equals(movie.movieName) && director.equals(movie.director) && year == movie.year;
        }
    }

}
