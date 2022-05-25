/**
 * Author: Emirhan Bekmez
 * Date: 28.04.2022
 * Version: 0.1
 **/


import java.util.ArrayList;
import java.util.Scanner;


/* Creating a music collection class
 * Creating an arrayList with content Object song
 * Creating a scanner object */
public class MusicCollection {
    static ArrayList<Song> musicCollection = new ArrayList<>();
    static Scanner sc1 = new Scanner(System.in);


    public static void main(String[] args) throws Exception {


        /* Here methods are called where it is checked if there is already a file, if not, it is created
         * a new one and read into the arraylist */
        System.out.println("File information: ");
        ReadFile.checkFileExist();
        ReadFile.readFile();
        CreateFile.dateiErstellen();


        /* Query on selection options (add, delete, print, search, save) */
        System.out.println("    ********** Welcome to the music collection **********");
        while (true) {
            System.out.println(
                    """
                            -------------------------------------------------------------
                            Please select an operation :
                            (add) --> for add Song
                            (delete) --> for delete Song
                            (print) --> for show all Songs\s
                            (search) --> for search song in the list
                            (save) --> for saving the list in file and exit the programm
                            -------------------------------------------------------------""");


            /* A switch with method call in the cases */
            String x = sc1.nextLine();
            switch (x) {
                case "add" -> addSong();
                case "delete" -> deleteSong();
                case "print" -> allSongPrint();
                case "search" -> {
                    System.out.println("""
                            What do you want to search?
                            (i) --> for interpret
                            (t) --> for titel
                            (exit) --> for return to the main menu)""");
                    String find = sc1.nextLine();
                    switch (find) {
                        case "i":
                            searchSongInterpret();
                            break;
                        case "t":
                            searchSongTitel();
                            break;
                        case "exit":
                            break;
                        default:
                            System.out.println("invalid input");
                    }
                }
                case "save" -> {
                    CreateFile.dateiSchreiben();
                    System.exit(0);
                }
                default -> System.out.println("invalid input !");
            }
        }
    }


    /* In this method a scanner is created which reads the interpreter and title name
     * and inserts them into the array list musicCollection */
    public static void addSong(){
        System.out.println("Please enter the interpreter : ");
        String interpret = sc1.nextLine();

        System.out.println("Please enter the title : ");
        String titel = sc1.nextLine();

        Song song = new Song(interpret, titel);
        musicCollection.add(song);
        System.out.println("Song added successfully to the list ! ");
    }


    /* Here you are asked which songs you want to delete from Arraylist, these are displayed in index order,
     * which must then be selected numerically. If no songs are entered, it outputs "empty" in the console */
    public static void deleteSong(){
        System.out.println("If you want to delete a song enter (d) or return to the main menu by entering (exit).");
        String exitOrDelete = sc1.nextLine();
        switch (exitOrDelete) {
            case "d":
                if (musicCollection.size() != 0){
                    for (int i = 0; i < musicCollection.size(); i++) {
                    System.out.println(i + 1  + " - " + musicCollection.get(i).getInterpret() + " " + musicCollection.get(i).getTitel());
                    }
                    System.out.println("What do you want to delete enter the (index) : ");
                    int index = sc1.nextInt();
                    musicCollection.remove(index - 1);
                    sc1.nextLine();
                }
                else {
                    System.err.println("empty!");
                    System.out.println("You must have added a song!");
                }
                break;

            case "exit":
                return;
            default:
                System.err.println("invalid input!");
        }
    }


    /* Here all elements of the musicCollection are displayed on the console */
    public static void allSongPrint(){
        if (musicCollection.size() != 0){
            for (int i = 0; i < musicCollection.size(); i++) {
                System.out.println(i + 1  + " - " + musicCollection.get(i).getInterpret() + " " + musicCollection.get(i).getTitel());
            }
        }else{
            System.err.println("empty!");
            System.out.println("You must have added a song!");
        }
    }


    /* Here you can search in the arraylist for a title, where it is then output in the console with the associated
     * index, if not exist any song, it gives "No song found" */
    private static void searchSongTitel() {

        int count = 0;
        System.out.println("Please enter the title you would like to search for: ");
        String sTitel = sc1.nextLine();

            for (int i = 0; i < musicCollection.size(); i++){
                if(musicCollection.get(i).getTitel().equals(sTitel)) {
                    System.out.println((i + 1) + ": " + musicCollection.get(i).getInterpret() + " - " + musicCollection.get(i).getTitel());
                    count++;
                }
            }
        if(count == 0){
            System.out.println("No songs found with the title " + sTitel + "!");
        } else {
            System.out.println(count + " song(s) were found with title " + sTitel);
        }
    }


    /* Here can search in the Arraylist for an interpreter, where it is then output in the console with the
     * associated index, if not exist any song, it gives "No song found" */
    public static void searchSongInterpret() {
        Scanner sc2 = new Scanner(System.in);
        int count = 0;

        System.out.println("Please enter the interpreter you would like to search for: ");
        String sInterpret = sc2.nextLine();

        for (int i = 0; i < musicCollection.size(); i++){
            if(musicCollection.get(i).getInterpret().equals(sInterpret)) {
                System.out.println((i + 1) + ": " + musicCollection.get(i).getInterpret() + " - "
                        + musicCollection.get(i).getTitel());
                count++;
            }
        }
        if(count == 0){
            System.out.println("No songs found with the interpreter " + sInterpret + "!");
        }
        else {
            System.out.println(count + " song(s) were found with interpreter " + sInterpret );
        }
    }
}


