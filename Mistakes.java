public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] maxLength = new int[1];
        helper(root, maxLength);
        return maxLength[0];
    }
    
    private int helper(TreeNode root, int[] maxLength) {
        if (root == null) return 0;
        int currentLength = 1;
        // Problem begin
        if (root.left != null && root.left.val - 1 == root.val) currentLength += helper(root.left, maxLength);
        if (root.right != null && root.right.val - 1 == root.val) currentLength = Math.max(currentLength, 1 + helper(root.right, maxLength));
        // Problem end
        maxLength[0] = Math.max(maxLength[0], currentLength);
        return currentLength;
    }
}

// Flip Game II
public class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }
    
    private boolean canWin(char[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == '+' && s[i+1] == '+') {
                s[i] = s[i+1] = '-';
                // Begin
                if (!canWin(s)) return true;
                s[i] = s[i + 1] = '+';
                // End
            }
        }
        return false;
    }
}
/*
Unique Word Abbreviation
1) If word's abbreviation is not in the dictionary
2) If a word's abbreviation is in the dictionary, but not the same word
*/

//Peeking Iterator
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next;
    
    private void peekNext() {
        // Begin
        if (iterator != null && iterator.hasNext()) next = iterator.next();
        // End
    }

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    peekNext();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer nextValue = next;
	    peekNext();
	    return nextValue;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}

// H-Index, H-Index II

// Factor Combinations

// Contains Duplicate
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // Begin
            if (set.contains(nums[i])) return true;
            if (i >= k) set.remove(nums[i-k]);
            set.add(nums[i]);
            // End
        }
        return false;
    }
}
