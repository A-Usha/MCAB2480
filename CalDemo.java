import java.util.Calendar;
class CalDemo
{
	public static void main(String args[]){
		
	Calendar c=Calendar.getInstance();
	System.out.println(c.getTime());//Fri Nov 29 19:48:12 IST 2024-present day-month-date
	
	
 c.add(Calendar.DATE,+12);
 System.out.println(c.getTime());//Wed Dec 11 19:55:02 IST 2024
 c.add(Calendar.YEAR,+2);
  System.out.println(c.getTime());//Fri Dec 11 19:57:06 IST 2026
  System.out.println(c.get(Calendar.MONTH));//11
  System.out.println(c.get(Calendar.YEAR));//2026
 
  
}
}
