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

    public Movie(String movieName, String director, int year, String borrower, String borrowedDate) {
        this.movieName = movieName;
        this.director = director;
        this.year = year;
        this.borrower = borrower;
        this.borrowedDate = borrowedDate;
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

    public String toCSV() {
        if(borrower == null) {
            return movieName + ", " + director + ", " + year;
        }else{
            return movieName + ", " + director + ", " + year + ", " + borrower + ", " + borrowedDate;
        }
    }   

    // Override toString method
    @Override
    public String toString() {
        if(borrower == null) {
            return movieName + ", " + director + ", " + year;
        }else{
            return movieName + ", " + director + ", " + year + ", (Borrower: " + borrower + ", " + borrowedDate+")";
        }
    }   
    
    // Override equals method
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
