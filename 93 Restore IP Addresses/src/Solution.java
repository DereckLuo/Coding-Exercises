import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by retuning all possible valid IP address combinations.
 * For example:
 * Given: "25525511135"
 * return ["255.255.11.135", "255.255.111.35"]
 * @author Dereck
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "010010";
		
		List<String> ret = restoreIpAddresses(input);
		
		System.out.println(ret);
		
	}
	
    public static List<String> restoreIpAddresses(String s) {
    	List<String> ret = new ArrayList<String>();
    	//base case check
    	if(s.length() < 4 || s.length() > 12){
    		return ret;
    	}
        
        //first number:
        for (int i = 1; i < 4; i++){
        	//System.out.print("i is:"); System.out.println(i);
        	String temp = "";
        	String first = s.substring(0,i);
        	int num_f = Integer.parseInt(first);
        	if(num_f < 256 && !(first.length() > 1 && first.charAt(0) == '0')){
        		String temp_f = temp + first + '.';
        		//System.out.println(temp_f);
        		//second number
            	for(int j = i+1; j < i+4; j++){
            		//System.out.print("j is:"); System.out.println(j);
            		if(j < s.length()){
            			String second = s.substring(i,j);
                		int num_s = Integer.parseInt(second);
                		if(num_s < 256 && !(second.length() > 1 && second.charAt(0) == '0')){
                			String temp_s = temp_f + second + '.';
                			//System.out.println(temp_s);
                			//third number
                    		for(int k = j+1; k < j+4; k++){
                    			//System.out.print("k is:"); System.out.println(k);
                    			if(k < s.length()){
                    				String third = s.substring(j,k);
                        			int num_t = Integer.parseInt(third);
                        			if(num_t < 256 && !(third.length() > 1 && third.charAt(0) == '0')){
                        				String temp_t = temp_s + third + '.';
                        				//System.out.println(temp_t);
                        				//fourth number
                        				String fourth = s.substring(k);
                        				int num_last = Integer.parseInt(fourth);
                        				if(num_last < 256 && !(fourth.length() > 1 && fourth.charAt(0) == '0')){
                        					String temp_last = temp_t + fourth;
                        					ret.add(temp_last);
                        				}
                        			}
                    			}
                    		}
                		}
            		}
            	}
        	}
        }
        return ret;
    }

}
