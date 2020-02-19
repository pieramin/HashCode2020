import java.lang.reflect.Array;
import java.util.*;

public class Main {

    //This method prints "Hello Hashcode!" on the screen and tests new methods
    public static void main(String[] args) {
        System.out.println("Hello Hashcode!");

        //start IO
        try(var ioHandler = new IOHandler(Constants.PATH_TO_INPUT_FILE, Constants.PATH_TO_OUTPUT_FILE)){
            ReturnType line1 = ioHandler.readLine(); //used to store data
            ReturnType line2 = ioHandler.readLine();

            int max = line1.values[0];
            int currentMax = max;

            ArrayList<Integer> typesTaken = new ArrayList<>();
            int[] pizzaTypess = line2.values;
            ArrayList<Integer> pizzaTypesTaken = new ArrayList<>();
            HashMap<Integer, Boolean> taken = new HashMap<>();

            for(int i: pizzaTypess){
                pizzaTypesTaken.add(i);
            }

            ArrayList<TypeSum> coupleSum = new ArrayList<>();

            for (int i = pizzaTypesTaken.size() - 1; i >= 0; i--) {
                if (currentMax - pizzaTypesTaken.get(i) >= 0) {
                    typesTaken.add(i);
                    taken.put(i, true);
                    currentMax -= pizzaTypesTaken.get(i);
                }
            }

            for (int i = 0; i < pizzaTypesTaken.size(); i++) {
                for (int j = i; j < pizzaTypesTaken.size(); j++) {
                    int[] a = new int[2];
                    a[0] = i;
                    a[1] = j;
                    coupleSum.add(new TypeSum(a, pizzaTypesTaken.get(i) + pizzaTypesTaken.get(j)));
                }
            }

            for(int repeat = 0; repeat < 1; repeat++) {


                coupleSum.sort(Comparator.comparingInt(o -> o.sum));

                System.out.println("Remaining is: " + currentMax);

                ciclo:
                for (int i = 0; i < typesTaken.size(); i++) {
                    System.out.println("Testing " + i);
                    int oldMax = currentMax;
                    currentMax += typesTaken.get(i);

//                int index = myBinary(coupleSum, typesTaken.get(i));

                    last:
                    for (TypeSum typeSum : coupleSum) {
                        currentMax -= typeSum.sum;
                        if (currentMax < 0) {
                            currentMax = oldMax;
                            break;
                        }
                        if (currentMax < oldMax) {
                            long tmp = System.currentTimeMillis();
                            for (Integer integ : typeSum.types)
                                if (taken.containsKey(integ)) {
                                    currentMax = oldMax;
                                    continue last;
                                }

                            System.out.println("Taken " + (System.currentTimeMillis() - tmp));
                            System.out.println("urra");
                            typesTaken.remove(i);
                            for(int in: typeSum.types){
                                typesTaken.add(in);
                            }
                            break ciclo;
                        } else
                            currentMax = oldMax;

                    }
                }


//                ArrayList<TypeSum> newCouple = new ArrayList<>();
//                for(var elem: coupleSum){
//                    for(int i = 0; i < pizzaTypesTaken.size(); i++){
//                        int[] b = Arrays.copyOf(elem.types, elem.types.length + 1);
//                        b[elem.types.length] = i;
//                        TypeSum tmp = new TypeSum(b , elem.sum + pizzaTypesTaken.get(i));
//                        newCouple.add(tmp);
//                    }
//                }
//                coupleSum = newCouple;
            }
            Collections.sort(typesTaken);

            line1.values = new int[]{typesTaken.size()};
            line2.values = new int[typesTaken.size()];
            for (int i = 0; i < line2.values.length; i++) {
                line2.values[i] = typesTaken.get(i);
            }

            System.out.println("Remaining is: " + currentMax);

            ioHandler.writeLine(line1);
            ioHandler.writeLine(line2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int myBinary(ArrayList<TypeSum> coupleSum, Integer integer, int a, int b) {
        int middle = (b - a) /2;
//        if(coupleSum.get(middle).sum)


        return 0;
    }

}

class TypeSum{

    int[] types;
    int sum;



    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public TypeSum(int[] types, int sum) {
        this.types = types;
        this.sum = sum;
    }
}



