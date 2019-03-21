function salesCom(){
	var sales, commission;
	var COMMISSION_RATE=0.10;
	sales = parseInt(prompt("Enter Sales"));
	commission=sales*COMMISSION_RATE;
	document.write("The amount of sales: $"+sales+"</br>");
	document.write("The commission ammount: $"+commission+"</br>");
}

function stepHeader(){
	for(var counter=6; counter>=1; counter--){
		document.write("<h"+counter+"> This is heading "+counter+"</h"+counter+">");
	}
}