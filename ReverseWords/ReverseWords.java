import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {

		int N; 			//number of cases
		int count=0;    //line counter

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(args[0]));		//input argument is the input file

			while ((sCurrentLine = br.readLine()) != null) {		//main body here
				if(count==0)
				{
					N = Integer.parseInt(sCurrentLine);
				}
				else
				{
					ArrayList<String> reverseList = createReverseStrList(sCurrentLine);
					System.out.println("Case #" + count + ": " + clean(reverseList.toString())); 
				}
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public static ArrayList<String> createReverseStrList(String str)
	{
		ArrayList<String> strArr = new ArrayList<String>(Arrays.asList(str.split(" ")));
		ArrayList<String> newStrArr = new ArrayList<String>();

		if(strArr.size()>1)
		{	
			for(int i=strArr.size()-1; i>=0; i--)
			{
				newStrArr.add(strArr.get(i));
			}
		}

		else
			newStrArr = strArr;

		return newStrArr;

	}

	public static String clean(String str)
	{
		String s = str.replace("[","");
		s = s.replace("]","");
		s = s.replace(",","");
		return s;
	}
}
