

public class Main {

    //This method prints "Hello Hashcode!" on the screen and tests new methods
    public static void main(String[] args) {
        System.out.println("Hello Hashcode!");

        //start IO
        try(var ioHandler = new IOHandler(Constants.PATH_TO_INPUT_FILE, Constants.PATH_TO_OUTPUT_FILE)){
            ReturnType ln; //used to store data

            //tests for IO
            ln = ioHandler.readLine();
            ioHandler.writeLine(ln);


            ln = ioHandler.readLine();
            ioHandler.writeLine(ln);

            ln = ioHandler.readLine();
            ioHandler.writeLine(ln);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}



