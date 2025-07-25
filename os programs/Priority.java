import java.util.*;
import java.lang.*;
class Priority{
public static void main(String args[]){
Scanner s=new Scanner(System.in);
int p,temp,i,j,order[];
float t1=0,t2=0;
System.out.println("Enter no of processes");
p=s.nextInt();
int bt[]=new int[p];
order=new int[p];
int pr[]=new int[p];
System.out.println("Enter burst time");
for(i=0;i<p;i++)
{
order[i]=i+1;
bt[i]=s.nextInt();
}
System.out.println("Enter priority");
for(i=0;i<p;i++)
{
order[i]=i+1;
pr[i]=s.nextInt();
}
for(i=0;i<p;i++)
{
for(j=i+1;j<p;j++)
{
if(pr[i]>pr[j])
{
temp=pr[i];
pr[i]=pr[j];
pr[j]=temp;
temp=bt[i];
bt[i]=bt[j];
bt[j]=temp;
temp=order[i];
order[i]=order[j];
order[j]=temp;
}
}
}
int wt[]=new int[p];
wt[0]=0;
for(i=1;i<p;i++)
{
wt[i]=bt[i-1]+wt[i-1];
t1+=wt[i];
}
int tat[]=new int[p];
for(i=0;i<p;i++)
{
tat[i]=bt[i]+wt[i];
t2+=tat[i];
}
System.out.println("Process\tBursttime\tPriority\tWaitingtime\tTurnaroundtime");
for(i=0;i<p;i++)
{
System.out.println("p"+order[i]+"\t\t"+bt[i]+"\t\t"+pr[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
}
float awt,att;
System.out.println("Average waiting time="+t1/p+"ms");

System.out.println("Average turnaround time="+t2/p+"ms");
}
}