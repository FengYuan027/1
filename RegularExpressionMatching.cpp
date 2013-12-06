/* Regular expression matching:
  '.' matches any characters
  '*' matches zero or more of the preceding element
*/

bool isMatch(const char* s, const char* p){
  if (!s && !p) return true;
  if (!s || !p) return false;
  if (*s == '\0') return *p == '\0';
  if (*p == '\0') return *s == '\0';
  
  if (*(p+1) != '*'){
    if (*p == *s || *p == '.') return isMatch(s+1,p+1);
    else return false;
  }
  else {
    while (*p == *s || (*p == '.' && *s!= '\0')){
      if (isMatch(s,p+2)) return true;
      s++;
    }
    return isMatch(s,p+2);
  }
}
