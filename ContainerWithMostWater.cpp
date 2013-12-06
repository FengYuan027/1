
int maxArea(vector<int> &height){
  
  if (height.size()<=1) return 0;
  
  int begin = 0, end = height.size()-1, max = 0;
  
  while (begin < end){
    int area = 0;
    if (height[begin] < height[end]){
      area = (end-begin) * height[begin];
      begin++;
    }
    else {
      area = (end-begin) * height[end];
      end--;
    }
    if (area > max) max = area;
  }
  
  return max;
}
