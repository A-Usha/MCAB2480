class MaxElement
{

	public static void main(String[] args) 
		
	{
		
		
		int[] arr={50,30,20,90,70};
		
		int Max=arr[1];
		
		for(int i=1;i<arr.length;i++){
			if(arr[i]>Max)
			{
				Max=arr[arr.length-1];
			}
		}
		System.out.println("Maximum element in the array is:"+Max);
	}
}
