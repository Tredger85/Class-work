//Andrew Franko
//Creates a new array of any length
//No parameters are passed into the function
//An array of user input numbers is returned
function fillArray(){
	//Generating an array of indeterminate length
	var numbers = new Array();
	//Initialize a boolean for testing
	var more = true;
	//For loop that steps through and up the array
	for(var i=0; more; i++){
		//Prompts for a number and sets it to the current array location
		numbers[i] = parseInt(prompt("Enter a positive or negative number"));
		//Allows user to determine if they want to add more numbers to the array
		more = confirm("Enter another number?");
	}
	//Returns the new array to where the function was called
	return numbers;
}
//Function doubles every third number of an array
//An array must be passed into the funtion
//Returns a copy of the origanal array with every third numer doubled
function doubleThird(array){
	//Generating a copy of the array parameter
	var array_copy = new Array();
	//Steps through the array that was the parameter
	for(var i =0; i<array.length; i++){
		//Tests if the current location is a multiple of 3 or i+1 for zero indexes
		if((i+1)%3==0){
			//If the test passes, double the original into the new location 
			array_copy[i]=array[i]*2;
		//Passes all array locations that are not divisible by 3
		}else{
			//Copying the old array into the new one
			array_copy[i]=array[i];
		}
	}
	//Returns the adjusted copy of the array parameter
	return array_copy;
}