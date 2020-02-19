import java.io.*;
import java.util.Vector;

public class Base {

    static File            inputFile;
    static FileReader      inputFr;
    static BufferedReader  inputBr;

    static File            outputFile;
    static FileWriter      outputFw;
    static BufferedWriter  outputBw;

    //This method prints "Hello Hashcode!" on the screen and tests new methods
    public static void main(String[] args) {
        ReturnType ln;
        System.out.println("Hello Hashcode!");
        //This method must be called at the start of the code
        openInputFile();
        openOutputFile();
        //readLine() reads a new line from the file
        ln=readLine();
        writeLine(ln);

        ln=readLine();
        writeLine(ln);

        ln=readLine();
        writeLine(ln);

        closeInputFile();
    }



    //this method prepares the input file to be read
    static public void openInputFile(){
        try {
            inputFile   = new File(Constants.pathToInputFile);
            inputFr     = new FileReader(inputFile);
            inputBr     = new BufferedReader(inputFr);
        }
        catch(IOException e){
            System.err.println("Wrong input path! I'm exiting... ");
            e.printStackTrace();
            System.exit(1);
        }

    }

    static public void closeInputFile(){
        try {
            inputFr.close();
            inputBr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //this method should be used to read a line of integers from a file.
    //It returns a ReturnType object (array of integers) if there is another line to read,  null otherwise.
    static public ReturnType readLine() {
        String read=null;
        try {
            read=inputBr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(read==null){
            if(Constants.debug) System.out.println("DEBUG - Read \n(null)");
            return null;
        }

        //The parse from document is performed with Strings. Tmp allows us to convert a string into an int
        String[] tmp;
        tmp=read.split(" ");

        //Initialising the returnType
        ReturnType returnType;
        returnType = new ReturnType(tmp.length);

        //Converts from String to int
        for(int i=0;i<tmp.length;i++){
            returnType.value[i]=Integer.parseInt(tmp[i]);
        }

        //if debug mode in on, the method prints the value returned
        if(Constants.debug){
            System.out.println("DEBUG - Read:");
            printLine(returnType);
        }
        return returnType;
    }


    //this method prints the velues inside rt
    static private void printLine(ReturnType rt){
        for(int i=0;i<rt.value.length;i++) System.out.println(rt.value[i]);
    }

    //This method opens the output file
    static public void openOutputFile(){
        try {
            outputFile   = new File(Constants.pathToOutputFile);
            if(outputFile.exists())
                outputFile.delete();
            outputFile.createNewFile();
            outputFw     = new FileWriter(outputFile,true);
            outputBw     = new BufferedWriter(outputFw);
        }
        catch(IOException e){
            System.err.println("Error openining the output file ! I'm exiting... ");
            e.printStackTrace();
            System.exit(1);
        }
    }

    //This method appends the given rt to the output file
    static public void writeLine(ReturnType rt){
        String tmp="";
        if(rt==null) {
            if(Constants.debug) System.out.println("DEBUG - Line to write: "+ tmp);
            return;
        }
        for(int i=0;i<rt.value.length-1;i++)
            tmp+=rt.value[i]+" ";
        tmp+=rt.value[rt.value.length-1]+"\n";
        if(Constants.debug) System.out.println("DEBUG - Line to write: "+ tmp);

        try{
            outputBw.write(tmp);
            outputBw.flush();
        } catch (IOException e){
            System.err.println("Unable to write in "+ Constants.pathToOutputFile);
            e.printStackTrace();
        }
    }
}



//This class represents the return type of the methods in the base class
class ReturnType{
    //here we use a int array to return data
    int[] value;
    //initializing the array
    ReturnType(int length){
        value=new int[length];
    }
}