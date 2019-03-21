//Prompts for the length and width
//No parameters are entered as this is the start to the program
//Calls and then writes the area function
function recArea(){
	//Declares a variable for length and prompts for the number
	var length=parseFloat(prompt("Enter the length"));
	//Declares a variable for width and prompts for the number
	var width=parseFloat(prompt("Enter the width"));
	//Function and returns with in the print line
	document.write(area(length,width)+" is the area");
}

//Calculates the are of a rectangle
//Passes the parameters of length and width
//Returns the value of length multiplied by width
function area(length,width){
	//calculates and returns length*width
	return length*width;
}