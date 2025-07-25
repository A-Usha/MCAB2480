import java.util.*;
import java.lang.*;
class RoundRobin{
Scanner sc=new Scanner(System.in);
int[] bur,rem,wai,ta;
int size,q,b=0,t=0,flag=0;
RoundRobin(int size)
{
this.size=size;
bur=new int[size];
wai=new int[size];
ta=new int[size];
rem=new int[size];
}
void get()
{
for(int i=0;i<size;i++)
{
System.out.println("Enter burst time of p"+(i+1)+":");
bur[i]=rem[i]=sc.nextInt();
}
System.out.println("Enter quantum time:");
q=sc.nextInt();
}
void round()
{
do{
flag=0;
for(int i=0;i<size;i++)
{
if(rem[i]>=q)
{
System.out.println("p"+(i+1)+"->");
for(int j=0;j<size;j++)
{
if(j==i)
rem[i]=rem[i]-q;
else if(rem[j]>0)
wai[j]+=q;
}
}
else if(rem[i]>0)
{
System.out.println("p"+(i+1)+"\t");
for(int j=0;j<size;j++)
if(j==i)
rem[i]=0;
else if(rem[j]>0)
wai[j]+=rem[i];
}
}

for(int i=0;i<size;i++)
if(rem[i]>0)
flag=1;
}
while(flag==1);
for(int i=0;i<size;i++)
ta[i]=wai[i]+bur[i];
}
void display()
{
System.out.println("\nProcesses\tBurst\tWaiting\tTurnaround");
for(int i=0;i<size;i++)
{
System.out.println("\tp"+(i+1)+"\t"+bur[i]+"\t"+wai[i]+"\t"+ta[i]);
b+=wai[i];
t+=ta[i];
}
System.out.println("average waiting time:"+(b/size));
System.out.println("average turnaround time:"+(t/size));
}
}
class KRoundRobin{
public static void main(String args[]){
Scanner s=new Scanner(System.in);
System.out.println("Enter no of process:");
int n=s.nextInt();
RoundRobin obj=new RoundRobin(n);
obj.get();
obj.round();
obj.display();
}
}
