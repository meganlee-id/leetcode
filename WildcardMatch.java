import java.util.ArrayList;


public class WildcardMatch {
    public boolean isMatch2(String s, String p) {
        // Base case: assume s, p are not null
        int S = s.length(), P = p.length();
        if (S == 0 && P == 0) return true;
        if (S != 0 && P == 0) return false;
        if (S == 0 && p.charAt(0) != '*') return false;
        if (S == 0 && p.charAt(0) == '*') return isMatch("", p.substring(1));
        
        // General case:
        char curp = p.charAt(0);
        char curs = s.charAt(0);
        if (curp == '?' || curs == curp) return isMatch(s.substring(1), p.substring(1));
        else { // curp == '*'
            for (int i = 0; i <= S; i++) {
                boolean flag = isMatch(s.substring(i), p.substring(1));
                if (flag) return true;
            }
            return false;
        }
    }
    
    
    
    
    
    public boolean isMatch(String s, String p) {
        // Base case: assume s, p are not null
        int S = s.length(), P = p.length();
        if (S == 0 && P == 0) return true;
        if (S != 0 && P == 0) return false;
        if (S == 0 && p.charAt(0) != '*') return false;

        //---- CASE 1: p.charAt(0) is concrete
        if (p.charAt(0) != '*' && p.charAt(0) != '?') {
        		if (s.charAt(0) != p.charAt(0)) return false;
        		else {
        			String nextS = (S == 1) ? "" : s.substring(1);
                String nextP = (P == 1) ? "" : p.substring(1);
                return isMatch(nextS, nextP);
        		}
        }
        
        //---- CASE 2: p.charAt(0) is '*' or '?'
        int firstL = 0; 
        int numOfQ = 0;
        while (firstL < P) {
            if (p.charAt(firstL) == '*') { firstL++; continue; }
            if (p.charAt(firstL) == '?') { firstL++; numOfQ++; continue; }
            else break;
        }
        
        //----- there is a concrete letter in pattern
        if (firstL < P) {
            ArrayList<Integer> indices = validIndices(p.charAt(firstL), s, numOfQ);
            for (int i: indices) {
                String nextS = (i == S - 1) ? "" : s.substring(i + 1);
                String nextP = (firstL == P - 1) ? "" : p.substring(firstL + 1);
                if (isMatch(nextS, nextP))
                    return true;
            }
            return false;
        
        //----- there is NOT a concrete letter in pattern
        } else {
            return (S >= numOfQ);       // S's length should be at least of numOfQnum of '?'
        }
        
    }
    
    public ArrayList<Integer> validIndices(char ch, String s, int bound) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch && i >= bound) 
                result.add(i);
        }
        return result;
    }

    //////////////// Test ///////////////////
    public static void main(String[] args) {
    		boolean[] b = new boolean[10];
		WildcardMatch wm = new WildcardMatch();
		b[0] = wm.isMatch("", "*");
		b[1] = wm.isMatch("abcad", "a*cb**?");
		b[2] = wm.isMatch("abbbbm", "*?");
		b[3] = wm.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a");
		b[4] = wm.isMatch("ab", "*");
		b[5] = wm.isMatch("ab", "?*");
		b[6] = wm.isMatch("aab", "c?a*b*");
		b[7] = wm.isMatch("cabab", "*ab");

		for (int i = 0; i < 8; i++) {
			System.out.println(b[i]);
		}  	
		System.out.println("d".substring(1,1));
	}
}

// NOTE: str.indexOf(ch); -1 or num
// ERROR: line 16: p[firstL] ---> p.charAt(firstL);
// ERROR: line 40: ArrayList<Character>  ---> ArrayList<Integer>
//System.out.println("d".substring(1,1)); !!!  ""
//System.out.println("d".substring(2,1)); !!!  error
