//Andrew Franko
//creates the bmi function that takes a pair of parameters
function bmi(height, weight){
	//body mass index conversion from the parameters
	var bmi=parseFloat((weight*703)/(height*height));
	//Prints out text and bmi function calculation using the two inputs as arguments
	document.write("<p>Based on the height and weight entered, the Body Mass Index is: "+bmi+"</p>" ); 
}