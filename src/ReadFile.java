/**
 * Author: Emirhan Bekmez
 * Date: 28.04.2022
 * Version: 0.1
 **/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {


    /* This method reads string from the .txt file and stores it in the arraylist */
    public static void readFile() throws FileNotFoundException {
        File text = new File ("C:\\Users\\BBRZ\\Codersbay\\IdeaProjetcs\\Musiksammlung\\filename.txt");
        Scanner reader = new Scanner(text);
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            String[] parts = line.split(":");
            String interpret = parts[0];
            String titel = parts[1];
            Song song = new Song(interpret, titel);
            MusicCollection.musicCollection.add(song);
        }
    }


    /* This method checks if a file already exists, if not, it outputs that "File does not exist" */
    public static void checkFileExist(){
        File f = new File("C:\\Users\\BBRZ\\Codersbay\\IdeaProjetcs\\MusikSammlung\\filename.txt");

        // Checking if the specified file exists or not
        if (f.exists())

            // Show if the file exists
            System.out.println("~There exists a .txt file~");
        else

            // Show if the file does not exist
            System.err.println("~File does not exists!~");
    }
}
