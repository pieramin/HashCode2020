import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    //This method prints "Hello Hashcode!" on the screen and tests new methods
    public static void main(String[] args) {
        System.out.println("Hello Hashcode!");

        //start IO
        try(var ioHandler = new IOHandler(Constants.PATH_TO_INPUT_FILE, Constants.PATH_TO_OUTPUT_FILE)){
            ReturnType line1 = ioHandler.readLine(); //used to store data
            ReturnType line2 = ioHandler.readLine();

            int max = line1.values[0];

            ArrayList<Integer> typesTaken = new ArrayList<>();
            int[] pizzaTypes = line2.values;
            for(int i = pizzaTypes.length - 1; i >= 0; i--){
                if(max - pizzaTypes[i] > 0){
                    typesTaken.add(i);
                    max -= pizzaTypes[i];
                }
            }

            Collections.reverse(typesTaken);

            line1.values = new int[]{typesTaken.size()};
            line2.values = new int[typesTaken.size()];
            for(int i = 0; i < line2.values.length; i++){
                line2.values[i] = typesTaken.get(i);
            }

            System.out.println("Remaining is: " + max);

            ioHandler.writeLine(line1);
            ioHandler.writeLine(line2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}



