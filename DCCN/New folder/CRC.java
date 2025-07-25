import java.util.*;
public class CRC{
public String XOR(String a,String b){
String result="";
int length=b.length();
for(int i=0;i<length;i++){
if(a.charAt(i)==b.charAt(i)){
result+="0";
}else{
result+="1";
}
}
return result;
}
public String repeatChar(char c,int n){
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<n;i++){
		sb.append(c);
	}
	return sb.toString();
}
public String CRC_Divide(String data, String polynomial) {
        int m = polynomial.length();
        int n = data.length();
        String paddedData = data + repeatChar('0', m - 1); // Append m-1 zeroes to the data
        String remainder = paddedData.substring(0, m); // Get first m bits of the padded data

        for (int i = m; i < n + m - 1; i++) {
            if (remainder.charAt(0) == '1') {
                remainder = XOR(remainder, polynomial) + paddedData.charAt(i);
            } else {
                remainder = XOR(remainder, repeatChar('0', m)) + paddedData.charAt(i);
            }
        }
		if (remainder.charAt(0) == '1') {
            remainder = XOR(remainder, polynomial);
        }

        // Return the remainder (CRC)
        return remainder.substring(1, m); // Return the last (m-1) bits as CRC
    }
public String Calculate_CRC(String data,String polynomial){
return CRC_Divide(data,polynomial);
}
public Boolean Check_CRC(String data,String polynomial){
String remainder=CRC_Divide(data,polynomial);
return remainder.equals(repeatChar('0',polynomial.length()-1));
}
public static void main(String args[]){
CRC crcCalculator=new CRC();
Scanner sc=new Scanner(System.in);
System.out.println("Enter the data(binary):");
String data=sc.nextLine();
System.out.println("Enter the CRC polynomial(binary):");
String polynomial=sc.nextLine();
String crc=crcCalculator.Calculate_CRC(data,polynomial);
System.out.println("CRC code:"+crc);
String dataWithCRC=data+crc;
if(crcCalculator.Check_CRC(dataWithCRC,polynomial)){
System.out.println("Data received correctly (no error)");
}else{
System.out.println("Data received with errors");
}
sc.close();
}
}