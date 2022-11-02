//2022-11-02
package com.jjob;

import java.util.List;

public class Result {
	
	  /*
     * Complete the 'playlist' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY songs
     *  2. INTEGER k
     *  3. STRING q
     */

    public static int playlist(List<String> songs, int k, String q) {
    // Write your code here
    	
    	int target = songs.lastIndexOf(q);
    	
    	int size= songs.size();
    	
    	int diff=Math.abs(target-k);
    	
    	if(diff*2<size)
    	{
    		return diff;
    	}
    	
    	return size-diff;

    }
	
	

}
