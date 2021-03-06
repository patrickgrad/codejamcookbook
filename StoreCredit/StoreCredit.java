import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StoreCredit
{

	public static void main(String[] args)
	{

		BufferedReader br = null;

		try 
		{
			/*Variables*/
			int count=0;
			int subCount=0;
			int N=0;
			int credit=0;
			int items=0;
			ArrayList<Integer> prices;
			ArrayList<Integer> sol;
	
			String sCurrentLine;

			br = new BufferedReader(new FileReader("./A-large-practice.in"));

			while ((sCurrentLine = br.readLine()) != null)
			{
				if(count==0)
				{
					N = Integer.parseInt(sCurrentLine);
				}
				
				else if(subCount==0) //count
				{
					credit = Integer.parseInt(sCurrentLine);
					subCount=1;
				}
				
				else if(subCount==1) //items
				{
					items = Integer.parseInt(sCurrentLine);
					//System.out.println(items);
					subCount=2;
				}
		
				else if(subCount==2) //prices
				{
					prices = createPrices(sCurrentLine);
					//System.out.println(prices);
					sol = solve(credit,items,prices);
					if(sol.get(1)<sol.get(0))
					{
						int swap = sol.get(1);
						sol.set(1,sol.get(0));
						sol.set(0,swap);
					}
					System.out.println("Case #" + (((count-1)/3)+1) + ": " + sol.get(0) + " " + sol.get(1)); 
					subCount=0;
				}				

				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public static ArrayList<Integer> createPrices(String str)
	{
		ArrayList<String> strArr = new ArrayList<String>(Arrays.asList(str.split(" ")));
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		for(int i=0; i<strArr.size(); i++)
		{
			intArr.add(Integer.parseInt(strArr.get(i)));
		}

		return intArr;

	}

	public static ArrayList<Integer> solve(int credit, int items, ArrayList<Integer> prices)
	{
		
		for(int i=0; i<prices.size(); i++)
		{
			for(int ii=0; ii<prices.size(); ii++)
			{
				if(((prices.get(i)+prices.get(ii))-credit==0)&&(i!=ii))
				{
					ArrayList<Integer> result = new ArrayList();
					result.add(i+1);
					result.add(ii+1);
					return result;
				}
			}
		
		}

		return null;
	}



}
