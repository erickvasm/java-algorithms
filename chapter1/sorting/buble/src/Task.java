import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    public static int[] removeDuplicates(int numbers []){
        return Arrays.stream(numbers).sorted().distinct().toArray();
    }

    public static ArrayList<Integer> sortedAndRemoveDuplicates(int[] numbers){
        int length = numbers.length;
        for(int i = 0; i < length; i++){
            int j =  i - 1;
            while(j >= 0 && numbers[j] > numbers[j + 1]){
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
                j--;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < length; i++){
            if (i == 0  || numbers[i] != numbers[i - 1]){
                result.add(numbers[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] firstArray = {3, 1, 2, 2, 5};
        int[] result = removeDuplicates(firstArray);
        System.out.println(Arrays.toString(result));
        System.out.println(sortedAndRemoveDuplicates(firstArray));
    }
}
