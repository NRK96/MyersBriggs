/* Name: Nicholas Keen
 * Course: Computer Science I - CIS
 * Section: 003
 * Assignment: 11
 */
import java.util.*;
import java.io.*;

//This program reads and interprets
//a file as if it were the answers to 
//a meyers briggs exam, then displays
//the results.
public class MyersBriggs {

    //Reads the file through the args array
    //creates a new file and calls the methods.
    public static void main(String [] args) 
			    throws FileNotFoundException{
	File file = new File(args[0]);
	PrintStream newFile = new PrintStream(fileName(args));
	Scanner fileScanner = new Scanner(file);
	meyersBriggs(fileScanner, newFile);
    }
    
    //Changes the extension of the file
    //to .mb
    public static String fileName(String [] args) {
	String file = args[0];
	int index = file.indexOf(".") + 1;
	String newFile = file.substring(0, index) + "mb";
	return newFile;
    }
    
    //Reads the lines and passes those lines
    //to the name and data methods.
    public static void meyersBriggs(Scanner fileScanner, PrintStream newFile) {
	while(fileScanner.hasNextLine()) {
	    String line = fileScanner.nextLine();
	    String [] mb = new String [1];
	    Scanner lineScanner = new Scanner(line);
	    if(lineScanner.hasNext()){
		lineScanner.next();
		String nextLine = fileScanner.next();
		for(int i = 0; i < mb.length; i++) {
		    mb[i] = name(line) + dim(nextLine) + 
		    data(nextLine) + personality(nextLine);
		    newFile.println(mb[i]);
		}
	    }
	}
    }
    
    //Creates an array from the dim methods
    //as well as prints out all of the data
    //portions of the mb test.
    public static String data(String nextLine) {
	int [] percents = {dimOnePercent(nextLine), 
			   dimTwoPercent(nextLine),
			   dimThreePercent(nextLine),
			   dimFourPercent(nextLine)};
	String data = "[" + percents[0] + "%";
	for(int i = 1; i < percents.length; i++) {
	    data = data + ", " + percents[i] + "%";
	}
	data = data + "] = ";
	return data;
    }
    
    //Prints out the name of the
    //individual who took the test.
    public static String name(String line) {
	String name = "";
	if(line.contains(" ")) {
	    name = line + ":\r\n";
	}
	return name;
    }
    
    //and returns the percent of A responses for
    //the first dimension of the mb test.
    public static int dimOnePercent(String nextLine) {
	char [] dimOne = {nextLine.charAt(0), nextLine.charAt(7), 
			  nextLine.charAt(14), nextLine.charAt(21), 
			  nextLine.charAt(28), nextLine.charAt(35), 
			  nextLine.charAt(42), nextLine.charAt(49), 
			  nextLine.charAt(56), nextLine.charAt(63)};
	int a = 0;
	int b = 0;
	    if(!nextLine.contains(" ")){
		for(int i = 0; i < dimOne.length; i++) {
		    if(dimOne[i] == 'A'){
			a++;
		    }else{
			b++;
		    }
		}
		double math = (1.0*a/(a+b)*100);
		int percent = (int) (math);
		return percent;
	    }
	return 0;
    }
    
    //Returns the number of responses i.e. A or B
    //for the first dimension.
    public static String dimOneAb(String nextLine) {
	char [] dimOne = {nextLine.charAt(0), nextLine.charAt(7), 
			  nextLine.charAt(14), nextLine.charAt(21),
			  nextLine.charAt(28), nextLine.charAt(35),
			  nextLine.charAt(42), nextLine.charAt(49),
			  nextLine.charAt(56), nextLine.charAt(63)};
	int a = 0;
	int b = 0;
	String ab = "";
	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimOne.length; i++) {
		if(dimOne[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    ab = a + "A-" + b + "B ";
	}
	return ab;
    }
    
    //Returns the percent of A responses for
    //the second dimension of the mb test.
    public static int dimTwoPercent(String nextLine) {
	char [] dimTwo = {nextLine.charAt(1), nextLine.charAt(2), 
			  nextLine.charAt(8),  nextLine.charAt(9),
			  nextLine.charAt(15), nextLine.charAt(16),
			  nextLine.charAt(22), nextLine.charAt(23),
			  nextLine.charAt(29),  nextLine.charAt(30),
			  nextLine.charAt(36), nextLine.charAt(37),
			  nextLine.charAt(43), nextLine.charAt(44),
			  nextLine.charAt(50), nextLine.charAt(51),
			  nextLine.charAt(57), nextLine.charAt(58),
			  nextLine.charAt(64), nextLine.charAt(65)};
	int a = 0;
	int b = 0;
	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimTwo.length; i++) {
		if(dimTwo[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    double math = (1.0*a/(a+b)*100);
	    int percent = (int) (math);
	    return percent;
	}
	return 0;
    }
    
    //Returns the number of responses i.e. A or B
    //for the second dimension.
    public static String dimTwoAb(String nextLine) {
	char [] dimTwo = {nextLine.charAt(1), nextLine.charAt(2), 
			  nextLine.charAt(8),  nextLine.charAt(9),
			  nextLine.charAt(15), nextLine.charAt(16),
			  nextLine.charAt(22), nextLine.charAt(23),
			  nextLine.charAt(29),  nextLine.charAt(30), 
			  nextLine.charAt(36), nextLine.charAt(37),
			  nextLine.charAt(43), nextLine.charAt(44),
			  nextLine.charAt(50),nextLine.charAt(51),
			  nextLine.charAt(57), nextLine.charAt(58),
			  nextLine.charAt(64), nextLine.charAt(65)};

	int a = 0;
	int b = 0;
	String ab = "";

	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimTwo.length; i++) {
		if(dimTwo[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    ab = a + "A-" + b + "B ";
	}
	return ab;
    }
    
    //Returns the percent of A responses for
    //the third dimension of the mb test.
    public static int dimThreePercent(String nextLine) {
	char [] dimThree = {nextLine.charAt(3), nextLine.charAt(4), 
			    nextLine.charAt(10), nextLine.charAt(11),
			    nextLine.charAt(17), nextLine.charAt(18),
			    nextLine.charAt(24), nextLine.charAt(25),
			    nextLine.charAt(31), nextLine.charAt(32),
			    nextLine.charAt(38), nextLine.charAt(39),
			    nextLine.charAt(45), nextLine.charAt(46),
			    nextLine.charAt(52),nextLine.charAt(53),
			    nextLine.charAt(59), nextLine.charAt(60),
			    nextLine.charAt(66), nextLine.charAt(67)};
	int a = 0;
	int b = 0;
	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimThree.length; i++) {
		if(dimThree[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    double math = (1.0*a/(a+b)*100);
	    int percent = (int) (math);
	    return percent;
	}
	return 0;
    }
    
    //Returns the number of responses i.e. A or B
    //for the third dimension.
    public static String dimThreeAb(String nextLine) {
	char [] dimThree = {nextLine.charAt(3), nextLine.charAt(4),
			    nextLine.charAt(10), nextLine.charAt(11),
			    nextLine.charAt(17), nextLine.charAt(18),
			    nextLine.charAt(24), nextLine.charAt(25),
			    nextLine.charAt(31), nextLine.charAt(32),
			    nextLine.charAt(38), nextLine.charAt(39),
			    nextLine.charAt(45), nextLine.charAt(46),
			    nextLine.charAt(52),nextLine.charAt(53), 
			    nextLine.charAt(59), nextLine.charAt(60),
			    nextLine.charAt(66), nextLine.charAt(67)};
	int a = 0;
	int b = 0;
	String ab = "";
	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimThree.length; i++) {
		if(dimThree[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    ab = a + "A-" + b + "B ";
	}
	return ab;
    }
    
    //Returns the percent of A responses for
    //the final dimension of the mb test.
    public static int dimFourPercent(String nextLine) {
	char [] dimFour = {nextLine.charAt(5), nextLine.charAt(6), 
			   nextLine.charAt(12), nextLine.charAt(13), 
			   nextLine.charAt(19), nextLine.charAt(20), 
			   nextLine.charAt(26), nextLine.charAt(27), 
			   nextLine.charAt(33), nextLine.charAt(34),
			   nextLine.charAt(40), nextLine.charAt(41),
			   nextLine.charAt(47), nextLine.charAt(48),
			   nextLine.charAt(54),nextLine.charAt(55),
			   nextLine.charAt(61), nextLine.charAt(62),
			   nextLine.charAt(68), nextLine.charAt(69)};
	int a = 0;
	int b = 0;
	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimFour.length; i++) {
		if(dimFour[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    double math = (1.0*a/(a+b)*100);
	    int percent = (int) (math);
	    return percent;
	}
	return 0;
    }
    
    //Returns the number of responses i.e. A or B
    //for the last dimension.
    public static String dimFourAb(String nextLine) {
	char [] dimFour = {nextLine.charAt(5), nextLine.charAt(6), 
			   nextLine.charAt(12), nextLine.charAt(13), 
			   nextLine.charAt(19), nextLine.charAt(20), 
			   nextLine.charAt(26), nextLine.charAt(27),
			   nextLine.charAt(33), nextLine.charAt(34),
			   nextLine.charAt(40), nextLine.charAt(41),
			   nextLine.charAt(47), nextLine.charAt(48),
			   nextLine.charAt(54),nextLine.charAt(55),
			   nextLine.charAt(61), nextLine.charAt(62),
			   nextLine.charAt(68), nextLine.charAt(69)};
	int a = 0;
	int b = 0;
	String ab = "";
	if(!nextLine.contains(" ")){
	    for(int i = 0; i < dimFour.length; i++) {
		if(dimFour[i] == 'A'){
		    a++;
		}else{
		    b++;
		}
	    }
	    ab = a + "A-" + b + "B \r\n";
	}
	return ab;
    }
    
    //Returns a String containing the values of
    //of the dimAb methods.
    public static String dim(String nextLine) {
	String [] dim = {dimOneAb(nextLine), dimTwoAb(nextLine),
			 dimThreeAb(nextLine), dimFourAb(nextLine)};
	String dimension = dim[0] + " " + dim[1] + " " + 
			   dim[2] + " " + dim[3] ;
	return dimension;
    }
    
    //Returns the personailty type.
    public static String personality(String nextLine) {
	int [] percents = {dimOnePercent(nextLine), 
			   dimTwoPercent(nextLine),
			   dimThreePercent(nextLine),
			   dimFourPercent(nextLine)};
	String first;
	String second;
	String third;
	String fourth;
	if(percents[0] >= 50) {
	    first = "I";
	}else{
	    first = "E";
	}if(percents[1] >= 50) {
	    second = "S";
	}else{
	    second = "N";
	}if(percents[2] >= 50) {
	    third = "T";
	}else{
	    third = "F";
	}if(percents[3] >= 50) {
	    fourth = "J";
	}else{
	    fourth = "P";
	}
	return first + second + third + fourth;
    }
}