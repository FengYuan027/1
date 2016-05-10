/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        if ( (numerator>0)^(denominator>0)) {
            result.append('-');
        }
        long numeratorL = Math.abs((long)numerator), denominatorL = Math.abs((long)denominator);
        result.append(numeratorL/denominatorL);
        numeratorL = numeratorL % denominatorL * 10;
        if (numeratorL != 0) {
            result.append('.');
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            while (numeratorL != 0) {
                if (map.containsKey(numeratorL)) {
                    result.insert(map.get(numeratorL), "(");
                    result.append(')');
                    break;
                }
                else {
                    map.put(numeratorL, result.length());
                    result.append(numeratorL/denominatorL);
                    numeratorL = numeratorL % denominatorL * 10;
                }
            }
        }
        return result.toString();
    }
}
