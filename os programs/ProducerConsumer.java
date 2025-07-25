import java.util.Scanner;
public class ProducerConsumer{
public static void main(String args[])
{
int[] buffer=new int[10];
int bufsize,in,out,produce,consume,choice=0;
in=0;
out=0;
bufsize=10;
while(choice!=3)
{
System.out.println("\n1.Produce\t2.Consume\t3.Exit");
System.out.println("\nEnter your choice");
choice=sc.nextInt();
switch(choice)
{
 case 1:
if((in+1)%bufsize==out)
{
System.out.println("\nvBuffer is full");
}
else
{
System.out.println("\n Enter the value:");
produce=sc.nextInt();
buffer[in]=produce;
in=(in+1)%bufsize;
}
break;
  case 2:
if(in==out)
{
System.out.println("\n Buffer is empty");
}
else
{
consume=buffer[out];
System.out.println("\nThe consumed value is"+consume);
out=(out+1)%bufsize;
}
break;
}
}
}
public final static Scanner sc=new Scanner(System.in);
}