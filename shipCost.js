//Andrew Franko
//Declared the JavaScript function
function shipCost(){
	//Holding and parsing the input from the form for the weight
	var weight=parseFloat(document.form.weight.value);
	//Testing to see if the weight is over 10 lbs (10, infinite)
	if (weight>10){
		//Output the cost back to the form if the weight is over 10 lbs
		document.form.output.value=weight*3.80;
	//Test for weight between six and ten (6,10]
	} else if (weight<=10 && weight>6) {
		//Output the cost back to the form if the weight is between 6 and 10 lbs
		document.form.output.value=weight*3.70;
	//Test for weight between six and ten (2,6]
	} else if (weight<=6 && weight>2) {
		//Output the cost back to the form if the weight is between 2 and 6 lbs
		document.form.output.value=weight*2.20;
	//Test for weight less than two lbs (0,2], assuming you arent shipping nothing
	} else {
		//Output the cost back to the form if the weight is less than two lbs
		document.form.output.value=weight*1.10;
	}
}	