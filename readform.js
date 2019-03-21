function validateCreditCard(){
	var text = document.form2.textBox.value;
	alert("This string we read is:\n"+text);
}

function writeback(){
	var output=("Filling up");
	document.form2.output.value = output;
}

function adder(){
	var num1=parseFloat(document.form.num1.value);
	var num2=parseFloat(document.form.num2.value);
	document.form.output.value=(num1+num2);
}