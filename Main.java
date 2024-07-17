import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Main{

    public static void main(String[] args){
        // Create an ArrayList of Movies
        ArrayList<Movie> movies = new ArrayList<>();
        
        readDataFile(movies, "movies.txt");

        System.out.println(movies);

        writeDataFile(movies);

        


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