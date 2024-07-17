//  Movies DB
//  The purpose of this application is to help me to record the movies that I own.
//  Secondly whenever I lend the movie I want to record the name of the friend who borrowed the movie and on which date.
//  This is so that I know who borrowed the movie and on which date.

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

        // Read user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Handle user input
        while(choice != 6){
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
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        //System.out.println(movies);

        writeDataFile(movies);

        


    }
    // Displys borrowed movies
    private static void displayBorrowedMovies(ArrayList<Movie> movies) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayBorrowedMovies'");
    }

    // Displys all movies including those that are currently borrowed
    private static void displayAllMovies(ArrayList<Movie> movies) {
        for(Movie movie : movies){
            System.out.println(movie);
        }
    }

    private static void returnMovie(ArrayList<Movie> movies, Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnMovie'");
    }

    // This method is used to lend a movie. The person to whom the movie is lended is stored in the Movie object
    private static void lendMovie(ArrayList<Movie> movies, Scanner scanner) {
        System.out.println("Enter the name of the movie: ");
        String movieName = scanner.nextLine();
        System.out.println("Enter the name of the person who borrowed the movie: ");
        String borrower = scanner.nextLine();
        System.out.println("Enter the date on which the movie was borrowed: ");
        String borrowedDate = scanner.nextLine();
        for(Movie movie : movies){
            if(movie.getMovieName().equals(movieName)){
                movie.setBorrower(borrower);
                movie.setBorrowedDate(borrowedDate);
            }
        }
    }

    private static void addMovie(ArrayList<Movie> movies, Scanner scanner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMovie'");
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