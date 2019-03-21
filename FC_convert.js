//Andrew Franko
//declared the function
function FC_form(){
	//declared a variable to hold the input of the Fahrenheit, 
	//parse float to hold the value as a number and keep any decimals
	var fahr=parseFloat(document.FCform.fahr.value);
	//sending a value back to the form after preforming the conversion from Fahrenheit to Celsius on the variable
	document.FCform.cel.value=(fahr-32)*5/9;
}