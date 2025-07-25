import java.util.Scanner;
public class BitStuffing{
	public static String bitStuffing(String originalData){
		StringBuilder stuffedData=new StringBuilder();
		int counter=0;
		for(char bit :originalData.toCharArray()){
			if(bit=='1'){
				counter++;
				stuffedData.append(bit);
				if(counter==5){
					stuffedData.append('0');
					counter=1;
				}
			}
			else{
				stuffedData.append(bit);
				counter=0;
				
			}
		}
		return stuffedData.toString();
	}
	public static String bitUnstuffing(String originalData){
	StringBuilder UnstuffedData=new StringBuilder();
		int counter=0;
		for(char bit:originalData.toCharArray()){
			if(bit=='1'){
				counter++;
				UnstuffedData.append(bit);
				if(counter==5 && originalData.charAt(originalData.indexOf(bit) + 1)=='0'){
				
					counter=1;
				}
			}
			else{
				
				UnstuffedData.append(bit);
				counter=0;
			}
		}
		return UnstuffedData.toString();
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the original data");
		String originalData=sc.nextLine();
		String stuffedData=bitStuffing(originalData);
		System.out.println("Original data"+ originalData);
		System.out.println("Stuffed data"+stuffedData);
		String UnstuffedData=bitUnstuffing(originalData);
		System.out.println("Unstuffed data"+UnstuffedData);
	}
}
		