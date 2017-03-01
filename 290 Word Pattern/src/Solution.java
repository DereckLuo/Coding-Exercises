import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern
 * Here follow means a full match, such taht there is a bijection between a letter in pattern and a non-empty
 * word in str
 * Example:
 * 	1. pattern = "abba", str = "dog cat cat dog" should return true
 *  2. pattern = "abba", str = "dog cat cat fish" should return false
 *  3. pattern = "aaaa", str = "dog cat cat dog" should return false
 *  4. pattern = "abba", str = "dog dog dog dog" should return false
 * Note:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space
 * @author Dereck
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog dog dog dog";
		boolean ret = wordPattern(pattern, str);
		if(ret){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		
	}
	
    public static boolean wordPattern(String pattern, String str) {
        
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        
        //parse the input with space
        String phrase = str;
        String delims = "[ ]+";
        String[] tokens = phrase.split(delims);
        
        //comparing with pattern
        if(pattern.length() != tokens.length){
        	System.out.println("first return");
        	return false;
        }
        for(int i = 0; i < pattern.length(); ++i){
        	String pattern_key = pattern.substring(i,i+1);
        	if(map1.get(pattern_key) == null && map2.get(tokens[i]) == null){
        		map1.put(pattern_key, tokens[i]);
        		map2.put(tokens[i], pattern_key);
        	}
        	else{
        		if(map1.get(pattern_key) == null || map2.get(tokens[i]) == null){
        			return false;
        		}
        		else if(!((map1.get(pattern_key)).equals(tokens[i])) || !(map2.get(tokens[i]).equals(pattern_key))){
        			return false;
        		}
        	}
        }
        return true;
    }

}
