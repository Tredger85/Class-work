//Andrew Franko
//declare function getFatCalories
function discountTotal(){
	//gets the input from the packages field and parses the value
	var packages=parseFloat(document.form.packages.value);
	//declaring discount var here so it is not localized inside the if statements
	var discount=1;
	//determining if they get a discount, discount var does not need to change since no discount is applied
	if(packages<10){
		//output that notifies them that they don't get a discount
		document.form.discount.value=("No discount at this level");
	//determining if they get the lowest level discount	
	} else if (packages<20){
		//output of discount level
		document.form.discount.value=("20%");
		//changing discount var, we are not asked how much is saved so both the decimal here or 1-% in the final calculation works
		discount=.8;
	//determining if they get the second level of discount	
	} else if (packages<50){
		//output of discount level
		document.form.discount.value=("30%");
		//changing discount var
		discount=.7;
	//determining if they get the third level of discount/second best discount
	} else if (packages<100){
		//output of discount level
		document.form.discount.value=("40%");
		//changing discount var
		discount=.6;
	//determining if they get the best discount, all cases that do not qualify should be accounted for previously
	} else {
		//output of discount level
		document.form.discount.value=("50%");
		//changing discount var
		discount=.5;
	}
	//calculates the total including discount and returns it to the form
	document.form.total.value=(packages*discount*99);
}