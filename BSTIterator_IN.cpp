struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int v) { val = v; left = NULL; right = NULL; }
};

class BSTIterator{
  
  stack<TreeNode*> stk;
  TreeNode* root;
  
  void pushLeft(TreeNode* r) {
    while (r) {
      stk.push(r);
      r = r->left;
    }
  }
  
public:
  
  BSTIterator(TreeNode* r) {
    root = r;
    init();
  }
  
  void init(){
    while(!stk.empty()){
      stk.pop();
    }
    pushLeft(root);
  }
  
  bool hasNext(){
    return !stk.empty();
  }
  
  TreeNode* getNext(){
    if (!hasNext()) return NULL;
    TreeNode* node = stk.top();
    stk.pop();
    pushLeft(node->right);
    return node;
  }
  
};
