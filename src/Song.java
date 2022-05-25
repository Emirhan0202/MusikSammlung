/**
 * Author: Emirhan Bekmez
 * Date: 28.04.2022
 * Version: 0.1
 **/


public class Song {
    // Create a class attribute
    public String Titel;
    public String Interpret;


    // Creating a class constructor for the Song class
    public Song(String interpret, String titel){
        this.Interpret = interpret;
        this.Titel = titel;
    }


    // The getMethods return the variable values
    public String getTitel() {
        return Titel;
    }
    public String getInterpret() {
        return Interpret;
    }
}
