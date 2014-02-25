import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Input
//
//The first line contains the number of test cases, T, and T cases follow (each one in a different line). Each test case consists of one integer N (1 ² N ² 100), indicating that you must find the Nth missing integer in the file (in ascending order).
//
//Output
//
//The Nth missing number in the file, in a different line for each test case.
//
//Example
//
//Suppose that all numbers from 0 to 107 are in the file, and that 108 is the first integer missing in the file. Then, if you are asked to provide the 1st missing number, you will have to ouput 108.


public class MissingNumbers {

	public static void main(String[] args) {

		new MissingNumbers().run();
		
	}

	private void run() {

		List<Integer> lost_numbers = new ArrayList();
		BufferedReader br = null;
		BufferedReader br2 = null;
		try {
			
			
			br = new BufferedReader(new FileReader("numbers.in"));	
			br2 = new BufferedReader(new FileReader("input.in"));
			
			int first_number = Integer.parseInt(br.readLine());
			if(first_number != 0){
				for(int i = 0; i<first_number; i++){
					lost_numbers.add(i);
				}
			}
			
			String numbers;
			
			while(( numbers = (br.readLine()))!=null){
				
				int number = Integer.parseInt(numbers);
				int difference = number-first_number;
				if(difference != 1){
					for(int i = 0; i<difference; i++){
						int added = i+number;
						lost_numbers.add(added);
					}
				}
				first_number = number;
			}
			
			int numberOfInputs = Integer.parseInt(br2.readLine());
			System.out.println(numberOfInputs);
			for(int i=0; i<numberOfInputs;i++){
				int positionNumber = Integer.parseInt(br2.readLine());
				System.out.println(lost_numbers.get(positionNumber));
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

}
