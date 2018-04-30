package edu.maryville.isys320.TriviaNight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class QuestionsManager {
	public ArrayList<String> categories = new ArrayList<String>();
	public ArrayList<String> questions = new ArrayList<String>();;
	public ArrayList<String> answers = new ArrayList<String>();;
	
	public QuestionsManager(String categoryFolder) {
		File fldr = new File(categoryFolder);
		String[] files = fldr.list();
		int questCount = 0; //create integer to count questions in categories
		
		Collections.addAll(categories,files);
		Collections.sort(categories);  // it appears to be sorted in ascending order already 
		for (String fileName : categories) {
			File f = new File(categoryFolder + "/" + fileName);
			try {
				Scanner fs = new Scanner(f);
				while(fs.hasNextLine()) { // Assume Q, A, Blank Line triplets 
					questCount++;
					questions.add(fs.nextLine());
					answers.add(fs.nextLine());
					fs.nextLine();
				}
				//added if else to check questions more or less than 10
				if (questCount < 10)  
					System.out.println("Category " + fileName + " has less than 10 questions");
				else if (questCount > 10)
					System.out.println("Category " + fileName + " has more than 10 questions");
				
				questCount = 0; // reset counter
				
				fs.close();
				//adjusted code to print user friendly error message
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File Not Found");  
			}
			
		}
	}
	
	public String[] getCategories() {
		return categories.toArray(new String[categories.size()]);
	}
	
	public String[] getQuestions() {
		return questions.toArray(new String[questions.size()]);
	}
	
	public String[] getAnswers() {
		return answers.toArray(new String[answers.size()]);
	}

}
