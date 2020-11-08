/* Problem : The program must accept an Integer N as the input. The program must find the factors of N. Then the program must sort these factors in descending order
	     based on their factors count. If more than one factors have the same factors count, then the program must sort these factors in descending order.
	     Finally, the program must print the sorted factors as the out.
	     Problem Statement from skillrack.com
*/

import java.util.*;

class SortFactors implements Comparable<SortFactors>
{
    int number,factorsCount;
    
    public int getFactorsCount(){
        return this.factorsCount;
    }
    public void setFactorsCount(int factorsCount){
        this.factorsCount= factorsCount;
    }
    
    public int getNumber(){
        return this.number;
    }
    public void setNumber(int number){
        this.number = number;
    }
    
    @Override
    public int compareTo(SortFactors other){
        int result = other.getFactorsCount() - this.getFactorsCount();
        if(result == 0){
            return other.getNumber() - this.getNumber();
        }
        return result;
    }
    
}

public class Sort_Factors_Factors_Count {
    
    static int getFactorsCount(int num){
        int factors_count = 0;
        for(int i=1;i<num+1;i++){
            if(num%i==0) factors_count++;
        }
        return factors_count;
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<SortFactors> sorted_numbers = new ArrayList<SortFactors>();
		for(int i=1;i<n+1;i++){
		    
		    if(n%i==0){
		        int factors_count = getFactorsCount(i);
		        SortFactors temp = new SortFactors();
		        temp.setFactorsCount(factors_count);
		        temp.setNumber(i);
		        sorted_numbers.add(temp);
		    }
		    
		}
		
		Collections.sort(sorted_numbers);
		
		for(SortFactors num: sorted_numbers){
		    System.out.print(num.getNumber() + " ");
		}

	}
}