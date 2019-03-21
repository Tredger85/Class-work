//Prompts for two values to be entered
//No parameters are entered as this is the start to the program
//Calls and then writes the max function
function maximum(){
	//Declares a variable and prompts for number
	var a=parseInt(prompt("Enter a number"));
	//Declares a variable (b) and prompts for another number
	var b=parseInt(prompt("Enter another number"));
	//Function and returns with in the print line
	document.write(max(a,b)+" is the larger number");
}

//Determines the larger of two value
//The parameters are two integers
//Returns the larger integer
function max(a,b){
	return Math.max(a,b);
}