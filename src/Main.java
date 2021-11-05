import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    //This method prints "Hello Hashcode!" on the screen and tests new methods
    public static void main(String[] args) {
        System.out.println("Hello Hashcode!");

        //start IO
        try(var ioHandler = new IOHandler(Constants.PATH_TO_INPUT_FILE, Constants.PATH_TO_OUTPUT_FILE)){
            ReturnType line1 = ioHandler.readLine(); //used to store data
            ReturnType line2 = ioHandler.readLine();

            /**
             *
             *
             *
             */
            int nBooks=line1.values[0];
            int nLibraries=line1.values[1];
            int nDays=line1.values[2];

            /**
             *
             *
             *
             */
            HashMap<Integer,Book> books = new HashMap<>();

            for (int i=0; i<nBooks;i++){
                books.put(i,new Book(line2.values[i]));
            }

            /**
             *
             *
             *
             */

            Library[] libraries=new Library[nLibraries];

            for(int i = 0; i< nLibraries; i++){
                ReturnType line3 = ioHandler.readLine();
                ReturnType line4 = ioHandler.readLine();

                /**
                 *
                 *
                 * first line
                 */
                int nBooksLibrary = line3.values[0];
                int signupProcess = line3.values[1];
                int nShip = line3.values[2];

                /**
                 *
                 *
                 * second line
                 */
                List<Book> booksInLibrary= new ArrayList<>();
                for(int j=0; j<nBooksLibrary;j++){
                    booksInLibrary.add(books.get(line4.values[j]));
                    books.get(line4.values[j]).addCont();

                }

                libraries[i]=new Library(booksInLibrary,signupProcess,nShip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}



