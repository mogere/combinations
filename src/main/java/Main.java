import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of E :");
        int E = sc.nextInt();
        if(E>51||E<1){
            System.out.println("please enter a value between 1 and 51");
        }
        System.out.println("Enter the value of O :");
        int O = sc.nextInt();
        if(O>51||O<1){
            System.out.println("please enter a value between 1 and 51");
        }
        System.out.println("Number of pictures taken is:"+picturesTaken(E,O));


    }

    public static int picturesTaken(int E, int O){

        int counter = 0;
        int[] evenNumber = new int[E];
        int[] odd = new int[E];
        for(int i=1; i<=E; i++){
            odd[i-1] = i*2-1;
            evenNumber[i-1] = i*2;
        }


        int[] oddNumber = new int[O];
        int[] even = new int[O];
        for(int i=1; i<=O; i++){
            oddNumber[i-1] = i*2-1;
            even[i-1] = i*2;
        }




       for (int num:evenNumber){
           int[] less = Arrays.stream(odd).filter(e -> e < num).toArray();
           List<int[]> result = calculateCombinations(less);
           counter+=result.size();
       }
        for (int num:oddNumber){
            int[] less = Arrays.stream(even).filter(e -> e <num).toArray();
            List<int[]> result = calculateCombinations(less);
            counter+=result.size();

        }
        System.out.println(counter);
        return counter;
    }





    public static List<int[]> calculateCombinations(int[] numbers){
        int startPtr = 0;

        List<int[]> result = new ArrayList<>();

        for (int i = startPtr; i<numbers.length; i++){
            for (int j = startPtr + 1; j<=numbers.length; j++){
                result.add(Arrays.copyOfRange(numbers, i, j));
            }
            startPtr ++;
        }
        return result;
    }
}






