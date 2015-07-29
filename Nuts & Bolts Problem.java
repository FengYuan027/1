/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null || compare == null || nuts.length == 0 || nuts.length != bolts.length) {
            return;
        }
        sortHelper(nuts, bolts, compare, 0, nuts.length - 1);
    }
    
    public void sortHelper(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
        if (start >= end) return;
        int pivot = sortNuts(nuts, compare, start, end, bolts[start]);
        sortBolts(bolts, compare, start, end, nuts[pivot]);
        sortHelper(nuts, bolts, compare, start, pivot - 1);
        sortHelper(nuts, bolts, compare, pivot + 1, end);
    }
    
    public int sortNuts(String[] nuts, NBComparator compare, int start, int end, String bolt) {
        int index = start;
        while (index <= end) {
            if (compare.cmp(nuts[index], bolt) == 1) {
                swap(nuts, index, end--);
            }
            else if (compare.cmp(nuts[index], bolt) == -1) {
                swap(nuts, index, start++);
                index++;
            }
            else index++;
        }
        return end;
    }
    
    public void sortBolts(String[] bolts, NBComparator compare, int start, int end, String nut) {
        int index = start;
        while (index <= end) {
            if (compare.cmp(nut, bolts[index]) == 1) {
                swap(bolts, index, start++);
                index++;
            }
            else if (compare.cmp(nut, bolts[index]) == -1) {
                swap(bolts, index, end--);
            }
            else index++;
        }
    }
    
    public void swap(String[] array, int left, int right) {
        String temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
};
