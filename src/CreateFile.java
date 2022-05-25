/**
 * Author: Emirhan Bekmez
 * Date: 28.04.2022
 * Version: 0.1
 **/


import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class CreateFile {


    /* This method creates a .txt file for the musicCollection, if there is already one created it will output
    that there is already one exist. */
    static void dateiErstellen(){
        try {
            File myObj = new File("C:\\Users\\BBRZ\\Codersbay\\IdeaProjetcs\\MusikSammlung\\filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("~A file has already been created!~\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred!");
            e.printStackTrace();
        }
    }


    /* This method saves the contents of the musicCollection to the .txt file */
    static void dateiSchreiben() {
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\BBRZ\\Codersbay\\IdeaProjetcs\\MusikSammlung\\filename.txt");
            for(Song song : MusicCollection.musicCollection)
                myWriter.write(song.getInterpret() + ":" + song.getTitel() + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }
}