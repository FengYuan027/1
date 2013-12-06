// The number is between 1 and 3999

string intToRoman(int num){
  string tag[] = {"I", "V", "X", "L", "C", "D", "M"};
  
  string result = "";
  int index = 0;
  
  while (num > 0) {
    int digit = num % 10;
    if (digit > 0 && digit < 4 || digit > 5 && digit <9){
      result = tag[index] + result;
      num--;
      continue;
    }
    else if (digit == 4) {
      result = tag[index] + tag[index+1] + result;
    }
    else if (digit == 5) {
      result = tag[index+1] + result;
    }
    else if (digit == 9) {
      result = tag[index] + tag[index+2] + result;
    }
    num /= 10;
    index += 2;
  }
  
  return result;
}
