//Andrew Franko
//declares the function name and passes in a parameter
function CF_converter(celsius){
	//outputs the parameter after it has been converted
	var fahrenheit=parseFloat((celsius*9/5)+32);
	//Prints out the original input and the calculated fahrenheit using the input as an argument
	document.write("<p>"+celsius+ " degrees Celsius is the same as "+fahrenheit+" degrees Fahrenheit</p>" ); 
}