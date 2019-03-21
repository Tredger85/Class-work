//Andrew Franko
//Enter a number of integers into an array and then separates out the positive and negative numbers
//No parameter is entered
//Prints a number of lines that includes the separated strings and totals
function seriesOfIntegers(){
	//Declares an array for the input
	var integers=fillArray();
	//Declares an array that will hold all the negative numbers
	var negative=new Array();
	//Declares an array that will hold all the positive numbers
	var positive=new Array();
	//Steps through the input array
	for(var i =0; i<integers.length; i++){
		//Tests to see if the integer in a location is a negative number
		if(integers[i]<0){
			//Adds the negative number to the end of the negative number array
			negative[negative.length]=integers[i];
		}
		//Tests to see if the integer in a location is a positive number
		if(integers[i]>0){
			//Adds the positive number to the end of the positive number array
			positive[positive.length]=integers[i];
		}
	}
	//Tests to see if any numbers were added to the negative array
	if(negative.length==0){
		//Prints if no negatives were entered
		document.write("You entered no negative numbers and there is no sum.</br>");
	//Goes through the else if one or more negative numbers were entered
	}else{
		//Prints all the negatives as a string
		document.write("You entered the following negative numbers: "+negative.toString()+"</br>");
		//Prints the sum of all negatives using sumArray function
		document.write("The sum of all negative numbers is: "+sumArray(negative)+"</br>");
	}
	//Tests to see if any numbers were added to the positive array
	if(positive.length==0){
		//Prints if no positive numbers were entered
		document.write("You entered no positive numbers and there is no sum.</br>");
	//Enters if positive numbers were entered
	}else{
		//Prints all the positive numbers to a string
		document.write("You entered the following positive numbers: "+positive.toString()+"</br>");
		//Prints the sum of all postive numbers using sumArray function
		document.write("The sum of all positive numbers is: "+sumArray(positive)+"</br>");
	}
}

//Function totals all the integers in an array
//Passes an array as a parameter
//Returns the total
function sumArray(array){
	//Declares and zeros the running total
	var total = 0;
	// Steps through the array
	for(var i = 0; i<array.length; i++){
		//Adds the integer at the location to the running total
		total+=array[i];
	}
	//Returns the total to the call
	return total;
}

//Funtion creates a new array, length is determined by the user
//No parameter is passed
//Returns a new user defined array
function fillArray(){
	//Intializes a new array
	var numbers = new Array();
	//Sets the test boolean to true
	var more = true;
	//Steps through the filling and lengthing of an array
	while(more){
		//Adds the user input to the end of the array
		numbers[numbers.length] = parseInt(prompt("Enter a positive or negative number"));
		//Prompts to see if the user wants to continue
		more = confirm("Enter another number?");
	}
	//Returns the new array
	return numbers;
}