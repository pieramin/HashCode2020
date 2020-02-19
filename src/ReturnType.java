import java.util.Arrays;

//This class stores the data read from  the file
class ReturnType{

    //here we use a int array to return data
    private int[] values;

    //initializing the array
    ReturnType(String[] data){
        values = new int[data.length];

        //Converts from String to int
        for(int i = 0; i < data.length; i++){
            values[i] = Integer.parseInt(data[i]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    /**
     * @return this with proper format to be written to file
     */
    String toFileData() {
        StringBuilder builder = new StringBuilder();
        for (int val: values) {
            builder.append(val).append(" ");
        }
        builder.replace(builder.length() - 1, builder.length(), "\n"); //replace last white space with new line
        return builder.toString();
    }
}
