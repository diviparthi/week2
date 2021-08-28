package week2.day2assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String string1 = "We learn java basics as part of java sessions in java week1";
		int count=0;
		String replac1="";
		String [] splitstring1 = string1.split(" ");
		for (int i = 0; i < splitstring1.length; i++)
		{
			System.out.println(splitstring1[i]);
		}
for (int i = 0; i < splitstring1.length; i++)
{
	for (int j = i+1 ; j < splitstring1.length -1 ; j++) {
		
	if (splitstring1[i].equals(splitstring1[j]))
	{
		count++;
	}
	if (count>0) 
	{
	   splitstring1[j]="";
	   count--;
	}
	}
	System.out.println(splitstring1[i]+"");

}
System.out.println(replac1);

	}

}
