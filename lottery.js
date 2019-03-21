//Andrew Franko
//This function creates a random 7 digit lottery number
//No parameters are passed
//The output is line of text followed by the 7 digits
function lotteryGenerator(){
	//Define an array and set the length to 7
	var lottery = new Array (7);
	//For loop that will step through the array
	for(var i=0; i<lottery.length; i++){
		//Generating a random number 0-9 and setting it to a location in the array
		lottery[i]=Math.floor(Math.random()*10);
	}
	//Printing wording to tell what the next numbers are
	document.write("Tonight's lottery numbers are: ");
	//For loop stepping through the array
	for(var j=0; j<lottery.length; j++){
		//Printing each location in the array, adding a space to distinguish each location
		document.write(lottery[j]+" ");
	}
}