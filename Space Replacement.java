public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (string == null || length <= 0) return 0;
        int count_of_space = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') count_of_space++;
        }
        int new_length = length + 2*count_of_space;
        if (count_of_space > 0) {
            int front = length - 1, back = new_length - 1;
            while (back > front) {
                if (string[front] == ' ') {
                    string[back--] = '0';
                    string[back--] = '2';
                    string[back--] = '%';
                }
                else string[back--] = string[front];
                front--;
            }
        }
        return new_length;
    }
}
