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

string intToRoman2(int num){
    string tag = {"I", "V", "X", "L", "C", "D", "M"};
    int pivot = 1, index = 0;
    while (num / pivot > 9) {
        pivot*=10;
        index+=2;
    }
    string result = "";
    while (num > 0){
        int digit = num / pivot;
        if ( digit >= 1 && digit < 4){
            result += tag[index];
            num -= pivot;
            continue;
        }
        else if ( digit == 4){
            result += tag[index] + tag[inde+1];
            num -= 4*pivot;
        }
        else if ( digit >= 5 && digit < 9){
            result += tag[index+1];
            num -= pivot*5;
            continue;
        }
        else if ( digit == 9){
            result += tag[index] + tag[index+2];
            num -= pivot*9;
        }
        pivot /= 10;
        index -= 2;
    }
    return result;
}
