import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

//        picturesTaken(2,3);
        int [] even = {2,4};
        int [] odd = {1, 3};
        int result = calculateCombinations(even).size() + calculateCombinations(odd).size();
        System.out.println(calculateCombinations(odd).size());

    }

    public static int picturesTaken(int E, int O){
        int counter = 0;
        List<Integer> even = new ArrayList<>();
        for(int i=1; i<=E; i++){
            int j=i;
            j=i*2;
            even.add(j);
        }
        int[] evenNumber = new int[even.size()];
        for(int i = 0; i < even.size(); i++) evenNumber[i] = even.get(i);

        List<Integer> odd = new ArrayList<>();
        for(int i=1; i<=O; i++){
            int j=i;
            j=i*2-1;
            odd.add(j);
        }
        int[] oddNumber = new int[odd.size()];
        for(int i = 0; i < even.size(); i++) oddNumber[i] = odd.get(i);


       for (int num:evenNumber){
           int[] less = Arrays.stream(oddNumber).filter(e -> e < num).toArray();
           List<int[]> result = calculateCombinations(less);
           counter+=result.size();
       }
        for (int num:oddNumber){
            int[] less = Arrays.stream(evenNumber).filter(e -> e <num).toArray();
            List<int[]> result = calculateCombinations(less);
            counter+=result.size();
        }

        System.out.println(counter);
        System.out.println(evenNumber.length);
        System.out.println(oddNumber.length);

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






