function seriesOfIntegers(){
	var integers = new array();
	var arrayIndex=0;
	var more=true;
	while(more){
		integers[arrayIndex] = parseInt(prompt("Enter a positive or negative number");
		more = confirm("Would you like to enter more numbers?");
		arrayIndex++;
	}
	var negTotal=0;
	var posTotal=0;
	var index=0;
	var searchMore = true;
	while(searchMore && index<integers.length){
		if(integers[index]<0){
			searchMore=false;
			document.write("You entered the following negative numbers: "+integers[index]):
			for(var i =index+1; i<integers.length; i++){
				if(integers[i]<0){
					document.write(", "+integers[i]);
					negTotal+=integers[i];
				}
				document.write("</br>");
				document.write("The sum of all negative numbers is: "+negTotal+"</br>");
			}
		} else {
			index++;
		}
	}
	if(index==integers.length){	
		document.write("You did not enter any negative numbers</br>");
	}
	searchMore=true;
	index=0;
	while(searchMore && index<integers.length){
		if(integers[index]>0){
			searchMore=false;
			document.write("You entered the following positive numbers: "+integers[index]):
			for(var i =index+1; i<integers.length; i++){
				if(integers[i]>0){
					document.write(", "+integers[i]);
					posTotal+=integers[i];
				}
				document.write("</br>");
				document.write("The sum of all positive numbers is: "+posTotal+"</br>");
			}
		} else {
			index++;
		}
	}
	if(index==integers.length){	
		document.write("You did not enter any positive numbers");
	}
}