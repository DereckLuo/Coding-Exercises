import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 
 * @author Dereck
 * 187. Repeated DNA Sequences
 * 	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example:
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC","CCCCCAAAAA"]
 */



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		List<String> output = findRepeatedDnaSequences(input);
		
		System.out.println(output);

		
	}
	
    public static List<String> findRepeatedDnaSequences(String s) {
    	//List of string to return 
        List<String> ret = new Vector<String>();
        //base case check
        if(s.length() <= 10) return ret; 
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println("Check");
        
        for(int i = 0; i <= s.length()-10; i++){
        	String temp = s.substring(i, i+10);
        	if(map.get(temp) == null){	//case first time see this
        		map.put(temp, 1);
        	}
        	else if(map.get(temp) == 1){
        		map.put(temp, 2);
        		ret.add(temp);
        	}
        }
        
        return ret;
    }

}
