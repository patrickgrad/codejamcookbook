import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodeJamTemplate {

	public static void main(String[] args) {

		BufferedReader br = null;

		int N; 			//number of cases
		int count=0;  	//line counter

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(args[0]));		//input argument is the input file

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);

				System.out.println("Case #" + ": "); 
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

	/* functions here */
}
