import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
	public static final String HOP_FAILURE = "failure";
	public static final String HOP_OUT = "out";
	private static final int STATUS_FAILURE = 1;

	public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        Solution solu = new Solution();
        ArrayList<Integer> data = new ArrayList<Integer>();
        while(sc.hasNext()){
        	try {
        		int x=sc.nextInt();      
              if (x >= 0)
  				data.add(x);
  			else
  				throw new RuntimeException("Unexpected Negative Integers");   
			} catch (InputMismatchException e) {
				throw new InputMismatchException("Unexpected Data Type"); 
			}

       }
        sc.close();
        String hopIndexes = solu.runfindHops(data);
        System.out.println(hopIndexes);
	}

	public String runfindHops(ArrayList<Integer> array){
		String hopIndexes = null;
		try {
			hopIndexes =findHops(array);
		} catch (RuntimeException rte) {;
			System.exit(STATUS_FAILURE);
		}
		return hopIndexes;
	}	
	
	private String findHops(ArrayList<Integer> array) {
		ArrayList<String> hops = new ArrayList<String>();
		int range=0;
		int i=0;
		int j=0;
		int maxhop=0;
		int selectIndex=0;
		for(i=0;i<array.size();){
			hops.add(String.valueOf(selectIndex));
			range=i+array.get(i);//init range
			if (range<=0||range<=selectIndex) {
				return HOP_FAILURE;
			}
			if (range>=array.size()) {
				hops.add(HOP_OUT);
				break;
			}
			for(j=i+1;j<=range;j++){
				int temp=j+array.get(j);
				if (temp>maxhop) selectIndex=j;
				maxhop=Math.max(temp, maxhop);
			}
			i=selectIndex;			
		}		
		if (hops.size()==0) {
			return HOP_FAILURE;
		}
		String result = hops.toString();
		return result.substring(1, result.length() - 1); 
		
	}
}















