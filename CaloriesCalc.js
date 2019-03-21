//Andrew Franko
//declare function getFatCalories
function getFatCalories(){
	//gets the input from the fat field and parses the value
	var fat=parseFloat(document.form.fat.value);
	//calculates the calories from fat and then returns it to the form
	document.form.fromFat.value=(fat*9);
}

//declare function getCarbCalories
function getCarbCalories(){
	//gets the input from the carbs field and parses the value
	var carbs=parseFloat(document.form.fat.value);
	//calculates the calories from carbs and then returns it to the form
	document.form.fromCarbs.value=(carbs*4);
}