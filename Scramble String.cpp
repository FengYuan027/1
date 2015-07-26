class Solution {
public:
    bool isScramble(string s1, string s2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (s1 == "" && s2 == "") return true;
        int N = s1.size();
        if (N != s2.size()) return false;
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            a += s1[i];
            b += s2[i];
        }
        if (a!=b) return false;
        vector<vector<vector<bool > > > isScrambleStr(N,vector<vector<bool> >(N,vector<bool>(N+1,false)));
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                isScrambleStr[i][j][0] = true;
                if (s1[i] == s2[j]) isScrambleStr[i][j][1] = true;
            }
        }
        for (int len = 2; len <= N; len++){
            for (int i = N - len; i >= 0; i--)
                for (int j = N - len; j >= 0; j--)
                    for (int k = 1; k < len; k++){
                        if (isScrambleStr[i][j][k] && isScrambleStr[i+k][j+k][len-k]
                            ||isScrambleStr[i][j+len-k][k] && isScrambleStr[i+k][j][len-k]){
                            isScrambleStr[i][j][len] = true;
                            break;
                        }
                    }
        }
        return isScrambleStr[0][0][N];
    }
};
