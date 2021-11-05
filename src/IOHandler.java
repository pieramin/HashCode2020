import java.io.*;

class IOHandler implements AutoCloseable{

    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * Creates reader and writer from the given files
     */
    IOHandler(String inputFilepath, String outputFilepath) throws IOException {
        //create reader
        var inputFile = new File(inputFilepath);
        reader = new BufferedReader(new FileReader(inputFile));

        //create writer
        var outputFile   = new File(outputFilepath);
        if(outputFile.exists() && !outputFile.delete())
            System.err.println("Cannot delete existing output file");
        if(!outputFile.createNewFile())
            System.err.println("Cannot create output file, it already exists somehow");
        writer = new BufferedWriter(new FileWriter(outputFile,true));

    }

    /**
     * this method should be used to read a line of data from a file.
     * @return a ReturnType object if there is another line to read,  null otherwise.
     */
    ReturnType readLine() throws IOException {
        String read; //stores the data read
        ReturnType typedData; //store the data read with their proper type
        read = reader.readLine();

        if(read == null){
            if(Constants.DEBUG) System.out.println("DEBUG - Read (null), probable EOF");
            return null;
        }

        //The parse from document is performed with Strings. Tmp allows us to convert a string into an int
        String[] tmp = read.split(" ");

        //Initialising the typedData
        typedData = new ReturnType(tmp);

        //if DEBUG mode in on, the method prints the value returned
        if(Constants.DEBUG){
            System.out.println("DEBUG - Read: " + typedData);
        }

        return typedData;
    }

    /**
     * This method appends the given data to the output file
     * @param data To be written
     */
    void writeLine(ReturnType data) throws IOException {
        if(data == null) {
            if(Constants.DEBUG)
                System.out.println("DEBUG - Line to write is null");
            return;
        }

        if(Constants.DEBUG)
            System.out.println("DEBUG - Line to write: " + data.toFileData());

        writer.write(data.toFileData());
        writer.flush();
    }

    @Override
    public void close() throws Exception {
        reader.close();
        writer.close();
    }
}
