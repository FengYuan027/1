/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
*/

public class Solution {
    private String[] appendix = {"Billion ", "Million ", "Thousand ", ""};
    private int[] pivot = {1000000000, 1000000, 1000, 1};
    private String hundred = "Hundred ";
    private String zero = "Zero";
    private String[] lessTwenty = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private String[] tens = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    
    public String numberToWords(int num) {
        if (num == 0) return zero;
        int index = 0;
        String word = "";
        while (num > 0) {
            int current = num / pivot[index];
            if (current > 0) {
                word += convertHundred(current) + appendix[index];
            }
            num %= pivot[index];
            index++;
        }
        return word.trim();
    }
    
    public String convertHundred(int num) {
        String word = "";
        if (num >= 100) {
            word += lessTwenty[num/100 - 1] + hundred;
            num %= 100;
        }
        if (num >= 20) {
            word += tens[num/10 - 2];
            num %= 10;
        }
        if (num > 0) {
            word += lessTwenty[num - 1];
        }
        return word;
    }
}
