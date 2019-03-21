/*CSD 210 HW3 part5(problem 18)
Andrew Franko 2/2/18
Method to count the number of words in a string.
While the test for the outer while loop and the second while loop are the same 
they are not redundent because what it is tested against changes inbetween*/
public class WordCount {
    public static void wordCount(String words) {
        int end=0;
        int count=0;
        while(end<words.length()){
            int start=end;
            while(start<words.length() && words.charAt(start)==' '){
                start++;
            }
            end=start;
            while(end<words.length() && words.charAt(end)!=' '){
                end++;
            }
            if(end!=start){
                count++;
            }
        }
    System.out.println("There were "+count+" in that string.");
    }
    
    public static void main (String[] args) {
    }
}
