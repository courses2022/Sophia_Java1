import java.util.ArrayList;

class Main{

    public static void main(String[] args){
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", 1972);
        System.out.println(movie);
        System.out.println("Movie name: " + movie.getMovieName());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Year: " + movie.getYear());

        movie.setBorrower("John Doe");
        movie.setBorrowedDate("01/01/2000");
        System.out.println("Borrower: " + movie.getBorrower());
        System.out.println("Borrowed date: " + movie.getBorrowedDate());

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", 2008));
        movies.add(new Movie("12 Angry Men", "Sidney Lumet", 1957));
        movies.add(new Movie("Schindler's List", "Steven Spielberg", 1993));
        movies.add(new Movie("Pulp Fiction", "Quentin Tarantino", 1994));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003));
        movies.add(new Movie("The Good, the Bad and the Ugly", "Sergio Leone", 1966));
        movies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2001));
        movies.add(new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002));
        movies.add(new Movie("Forrest Gump", "Robert Zemeckis", 1994));
        movies.add(new Movie("Inception", "Christopher Nolan", 2010));
        movies.add(new Movie("Fight Club", "David Fincher", 1999));
        movies.add(new Movie("The Matrix", "The Wachowskis", 1999));
        movies.add(new Movie("Star Wars: Episode V - The Empire Strikes Back", "Irvin Kershner", 1980));
        movies.add(new Movie("Star Wars: Episode IV - A New Hope", "George Lucas", 1977));
        movies.add(new Movie("Star Wars: Episode VI - Return of the Jedi", "Richard Marquand", 1983));
        movies.add(new Movie("Star Wars: Episode I - The Phantom Menace", "George Lucas", 1999));
        movies.add(new Movie("Star Wars: Episode III - Revenge of the Sith", "George Lucas", 2005));
        movies.add(new Movie("Star Wars: Episode II - Attack of the Clones", "George Lucas", 2002));
        movies.add(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
        movies.add(new Movie("Star Wars: The Last Jedi", "Rian Johnson", 2017));
        movies.add(new Movie("Star Wars: The Rise of Skywalker", "J. J. Abrams", 2019));
        movies.add(new Movie("Star Wars: The Force Awakens", "J. J. Abrams", 2015));
        movies.add(new Movie("Star Wars: The Last Jedi", "Rian Johnson", 2017));
        movies.add(new Movie("Star Wars: The Rise of Skywalker", "J. J. Abrams", 2019));
        movies.add(new Movie("Dune: Part One", "Denis Villeneuve", 2021));
        movies.add(new Movie("Dune: Part Two", "Denis Villeneuve", 2024));

        System.out.println(movies);
    }
}