/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            int wordNumber = 0, wordLength = 0;
            for (; i + wordNumber < words.length && wordLength + words[i + wordNumber].length() + wordNumber <= maxWidth; wordNumber++) {
                wordLength += words[i+wordNumber].length();
            }
            String line = new String(words[i]);
            for (int j = 0; j < wordNumber - 1; j++) {
                if (i + wordNumber == words.length) line += ' ';
                else {
                    int spaceCount = (maxWidth - wordLength) / (wordNumber - 1) + ((maxWidth - wordLength)%(wordNumber - 1) > j? 1 : 0);
                    for (int k = 0; k < spaceCount; k++) line += ' ';
                }
                line += words[i + j + 1];
            }
            while (line.length() < maxWidth) line += ' ';
            lines.add(line);
            i += wordNumber - 1;
        }
        return lines;
    }
}

