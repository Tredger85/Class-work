//Andrew Franko
//declared the function
function BMI_form(){
	//declared a variable to hold the input of the height, 
	//parse float to hold the value as a number and keep any decimals
	var height=parseFloat(document.BMIform.height.value);
	//declared a variable to hold the input of the weight, 
	//parse float to hold the value as a number and keep any decimals
	var weight=parseFloat(document.BMIform.weight.value);
	//sending a value back to the form after preforming the BMI formula using the input height and weight
	document.BMIform.bmi.value=(weight*703/(height*height));
}