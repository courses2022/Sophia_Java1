//  Movies DB
//  The purpose of this application is to help me to record the movies that I own.
//  Secondly whenever I lend the movie I want to record the name of the friend who borrowed the movie and on which date.
//  This is so that I know who borrowed the movie and on which date.

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main{

    public static void main(String[] args){
        // Create an ArrayList of Movies
        ArrayList<Movie> movies = new ArrayList<>();
        // Read data from the local file system and store data to Movies list
        readDataFile(movies, "movies.txt");

        // Display main menu
        System.out.println("Movies DB");
        System.out.println("1. Add a movie");
        System.out.println("2. Lend a movie");
        System.out.println("3. Return a movie");
        System.out.println("4. Display all movies");
        System.out.println("5. Display borrowed movies");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");

        // Setup scanner for user input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        // Handle user input
        while(choice != 6){
        // Display main menu
        System.out.println("Movies DB");
        System.out.println("1. Add a movie");
        System.out.println("2. Lend a movie");
        System.out.println("3. Return a movie");
        System.out.println("4. Display all movies");
        System.out.println("5. Display borrowed movies");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");

        // Read user input
        choice = scanner.nextInt();
        scanner.nextLine();
            switch(choice){
                case 1:
                    addMovie(movies, scanner);
                    break;
                case 2:
                    lendMovie(movies, scanner);
                    break;
                case 3:
                    returnMovie(movies, scanner);
                    break;
                case 4:
                    displayAllMovies(movies);
                    break;
                case 5:
                    displayBorrowedMovies(movies);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

        //System.out.println(movies);
        // Save updated data to the file system
        writeDataFile(movies);

        


    }
    // Displys borrowed movies
    private static void displayBorrowedMovies(ArrayList<Movie> movies) {
        System.out.println("Movies currently lent to friends: ");
       for(Movie movie : movies){
           if(movie.getBorrower() != null){
               System.out.println(movie);
           }
       }
    }

    // Displys all movies including those that are currently borrowed
    private static void displayAllMovies(ArrayList<Movie> movies) {
        for(Movie movie : movies){
            System.out.println(movie);
        }
    }

    // This method is used to return a movie
    private static void returnMovie(ArrayList<Movie> movies, Scanner scanner) {
        System.out.println("Enter the name of the movie: ");
        String movieName = scanner.nextLine();
        for(Movie movie : movies){
            if(movie.getMovieName().equals(movieName)){
                movie.setBorrower(null);
                movie.setBorrowedDate(null);
            }
        }

    }

    // This method is used to lend a movie. The person to whom the movie is lended is stored in the Movie object
    private static void lendMovie(ArrayList<Movie> movies, Scanner scanner) {
        System.out.println("Enter the name of the movie: ");
        String movieName = scanner.nextLine();
        ArrayList<Movie> matchingMovies = movies.stream().filter(movie -> movie.getMovieName().equals(movieName)).collect(Collectors.toCollection(ArrayList::new));
        if(matchingMovies.size() == 0){
            System.out.println("No movies found");
            return;
        }
        System.out.println("The following movies match your search: ");
        for(Movie movie : matchingMovies){
            System.out.println(movie);
        }
        System.out.println("Enter the name of the person who borrowed the movie: ");
        String borrower = scanner.nextLine();
        System.out.println("Enter the date on which the movie was borrowed: (dd/mm/yyyy) (T=Today) ");
        String borrowedDate = scanner.nextLine();
        if(borrowedDate.equals("T")){
            borrowedDate = java.time.LocalDate.now().toString();
        }
        for(Movie movie : movies){
            if(movie.getMovieName().equals(movieName)){
                movie.setBorrower(borrower);
                movie.setBorrowedDate(borrowedDate);
            }
        }
    }

    // Add a new movie to the movies list
    private static void addMovie(ArrayList<Movie> movies, Scanner scanner) {
        System.out.println("Enter the name of the movie: ");
        String movieName = scanner.nextLine();
        System.out.println("Enter the name of the director: ");
        String director = scanner.nextLine();
        System.out.println("Enter the year of release: ");
        int year = scanner.nextInt();   
        scanner.nextLine();
        movies.add(new Movie(movieName, director, year));
    }

    // Helper method to read to the local file system and to deal with error handling
    private static void writeDataFile(ArrayList<Movie> movies) {
        try{
            FileWriter writer = new FileWriter("movies.txt");
            for(Movie movie : movies){
                writer.write(movie.toString() + "\n");
            }
            writer.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    // Helper method to from the local file system, store data to Movies list and to deal with error handling
    private static void readDataFile(ArrayList<Movie> movies, String pathName) {
        try{
            File file = new File(pathName);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(", ");
                String movieName = parts[0];
                String director = parts[1];
                int year = Integer.parseInt(parts[2]);
                movies.add(new Movie(movieName, director, year));
            }
            reader.close();
        }catch(Exception e){
            System.out.println("There was an error reading the file.");
            e.printStackTrace();
        }
    }
}