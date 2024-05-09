import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Main{

    public static void main(String[] args){
        
        ArrayList<Movie> movies = new ArrayList<>();
        
        readDataFile(movies);

        System.out.println(movies);

        writeDataFile(movies);

        


    }

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

    private static void readDataFile(ArrayList<Movie> movies) {
        try{
            File file = new File("movies.txt");
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