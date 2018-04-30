//Pseudo Code - 
//create file for questions (1-10)
//create file for answers (1-10)
//Create input for title and round (1-10)
//
//Input- scanner/sys.in
//fetch files  for questions in order of rounds (10 rounds)
//fetch files for answers in order of rounds (10 rounds)
//provide error message if file not found 
//provide error message if files do not contain 10 rounds
//
//output- sys.out
//export to power point presentation
//Export Title Slide in order by round (1-10), but before each question (loop) 
//after each title round - export questions by corresoponding round to powerpoint presentation (1-10)
//after each question - export questions by round to powerpoint - to repeat question (1-10)
//export answer in order of round (1-10) inlcude corresponding question with answer

package edu.maryville.isys320.TriviaNight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildTriviaNightPresentation {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = "TriviaNight.pptx";
		SlideShowBuilder builder = new SlideShowBuilder();
		QuestionsManager qm = new QuestionsManager("data");

		//add user input to select play by  Round or Category
		Scanner console = new Scanner(System.in); 
		System.out.print("Would you like to create slides by Category or by Round? Type 1 for Category and 2 for Round. "); 
		int gameType = console.nextInt();

		if (gameType == 1)
			builder.buildCategorySlideShow(qm.getCategories(), qm.getQuestions(), qm.getAnswers(), fileName);
		else if (gameType == 2)
			builder.buildRoundSlideShow(qm.getCategories(), qm.getQuestions(), qm.getAnswers(), fileName);
		else
			System.out.println("Game does not exist.  Please try again");
		
//		builder.printSlideShowInfo("Sample.pptx");

	}
	
}
