// Negative ones shoule not be considered palindrome number

bool isPalindrome(int x) {

  if (x < 0) return false;
  
  int index = 1;
  
  while (x / index > 9) index*=10;
  
  while (index > 0) {
    int left = x / index;
    int right = x % 10;
    if (left != right) return false;
    x -= left*index;  // The left part must be removed!
    x /= 10;
    index /= 100;
  }
  
  return true;
}
