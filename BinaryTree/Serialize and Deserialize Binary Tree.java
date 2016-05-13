/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        serializeHelper(root, data);
        return data.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder data) {
        if (data.length() > 0) {
            data.append(",");
        }
        if (root == null) data.append("n");
        else {
            data.append(String.valueOf(root.val));
            serializeHelper(root.left, data);
            serializeHelper(root.right, data);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(data.split(","), new int[1]);
    }
    
    private TreeNode deserializeHelper(String[] data, int[] index) {
        TreeNode current = data[index[0]].equals("n") ? null : new TreeNode(Integer.valueOf(data[index[0]]));
        index[0]++;
        if (current != null) {
            current.left = deserializeHelper(data, index);
            current.right = deserializeHelper(data, index);
        }
        return current;
    }
}
