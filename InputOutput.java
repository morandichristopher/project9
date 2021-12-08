package labproject9.io;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File input=new File("populations");
		Scanner in=new Scanner(input);
		PrintWriter out=new PrintWriter("output");
		ArrayList<String> name = new ArrayList<>();
		ArrayList<Integer> pop = new ArrayList<>();
		while(in.hasNextLine()) {
			String s = in.nextLine();
			String nums = "";
			String letters = "";
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(Character.isDigit(c)) {
					nums += c;
				}
				else if (Character.isLetter(c)) {
					letters += c;
				}
			}
			int a = Integer.parseInt(nums);
			pop.add(a);
			name.add(letters);
		}
		int min = pop.get(0);
		int max = pop.get(0);
		
		String minName = name.get(0);
		String maxName = name.get(0);
		
		int total = 0;
		
		
		for(int i = 0; i < pop.size(); i++) {
			if(pop.get(i) < min) {
				min = pop.get(i);
				minName = name.get(i);
			}
			if(pop.get(i) > max) {
				max = pop.get(i);
				maxName = name.get(i);
			}
			total += pop.get(i);
		}
		
		float avg = total/pop.size();
		
		out.println("Most Populated: " + maxName + " with " + max);
		out.println("Least Populated: " + minName + " with " + min);
		out.println("Total Population: " + total);
		out.println("Average Population: " + avg);
		
		in.close();
		out.close();
	}

}
