//Andrew Franko
//Declared the JavaScript function
function recEval(){
	//Holding and parsing the input from the form for the height of the first rectangle
	var height1=parseFloat(document.form.height1.value);
	//Holding and parsing the input from the form for the width of the first rectangle
	var width1=parseFloat(document.form.width1.value);
	//Holding and parsing the input from the form for the height of the second rectangle
	var height2=parseFloat(document.form.height2.value);
	//Holding and parsing the input from the form for the width of the second rectangle
	var width2=parseFloat(document.form.width2.value);
	//Evaluate if the area(height multiplied by width) of the two rectangles are the equal
	if ((height1*width1)==(height2*width2)){
		//Output back to the form if the areas are equal
		document.form.output.value="They are equal";
	//If the areas are not equal, test to see if the first rectangle has a larger area
	} else if ((height1*width1)>(height2*width2)) {
		//Output back to the form if the area of the first rectangle is larger
		document.form.output.value="The size of rectangle one is greater";
	//Final else, we know that if we get here that the recatangles are not equal and the first is not larger, 
	//there for the second is not larger.
	} else {
		//Output to the form if neither of the first two conditions are met
		document.form.output.value="The size of rectangle two is greater";
	}
}	