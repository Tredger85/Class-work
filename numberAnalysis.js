//Andrew Franko
//Function has takes input for an array of 20 integers
//No parameter into the function
//Prints the lowes, highest, sum and average of the input array
function numberAnalysis(){
	//Creates a new array of 20 locations
	var numbers = new Array(20);
	//For loop to step through the array
	for(var i=0; i<numbers.length; i++){
		//Prompts and parses integers for each location in the array, also prints where in the input the user is
		numbers[i] = parseInt(prompt("Enter a positive or negative number. This is "+(i+1)+" of 20"));
	}
	//Calls the findLow function and prints
	document.write("The lowest number you entered: "+findLow(numbers)+"</br>");
	//Calls the findHighest function and prints
	document.write("The highest number you entered: "+findHighest(numbers)+"</br>");
	//Calls the sumArray function and prints
	document.write("The total of the numbers you entered: "+sumArray(numbers)+"</br>");
	//Calls the average function and prints
	document.write("The average of the numbers you entered: "+average(numbers)+"</br>");
}
//Function adds all the integers in an array
//Needs an array as a parameter
//Returns the sum to the call
function sumArray(array){
	//Declares a variable the will hold the total to zero
	var total = 0;
	//Steps through the array
	for(var i = 0; i<array.length; i++){
		//Adds each array location to the running total
		total+=array[i];
	}
	//Returns the total to the call
	return total;
}
//Function averages out the integers in a array
//Needs an array as a parent	
//Returns the average to the call
function average(array){
	//Uses the sumArray  function and the number of locations in array to determine the average
	return sumArray(array)/array.length;
}

//Function looks for the highest integer in the array
//Needs an array as the parameter
//Returns the highest number in the array
function findHighest(array){
	//Declares and sets the variable to the first location of the array
	var high = array[0];
	//Steps through the array, starts at 1 as the variable is already from the zero position
	for (var i=1; i<array.length; i++){
		//Tests to see if the next location is higher than what is currently the highest
		if (array[i]>high){
			//Replaces the high variable with that of the curent location of the array
			high=array[i];
		}
	}
	//Returns the high to the call
	return high;
}

//Function looks for the lowest integer in the array
//Needs an array as the parameter
//Returns the lowest number in the array
function findLow(array){
	//Declares and sets the variable to the first location of the array
	var low = array[0];
	//Steps through the array, starts at 1 as the variable is already from the zero position
	for (var i=1; i<array.length; i++){
		//Tests to see if the current location is less than the current lowest
		if (array[i]<low){
			//Sets low to the new lowest number
			low=array[i];
		}
	}
	//Returns the low to the call
	return low;
}