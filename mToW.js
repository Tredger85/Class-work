//Andrew Franko
//Declared the JavaScript function
function mToW(){
	//Holding and parsing the input from the form for the mass
	var mass=parseFloat(document.form.mass.value);
	//Introducing weight to hold the mass after the conversion
	var weight=mass*9.8;
	//Testing to see if the weight is over 1000
	if (weight>1000){
		//Output back to the form if the weight is over 1000
		document.form.output.value="Too heavy";
	//Testing to see if the weight is under 10
	} else if (weight<10) {
		//Output back to the form if the weight is under 10
		document.form.output.value="Too light";
	//Final else, we know that the weight is between 10 and 1000 Newtons 
	// and there for is available for the conversion.
	} else {
		//Output to the form if neither of the first two conditions are met
		document.form.output.value=weight+" Kilograms";
	}
}	