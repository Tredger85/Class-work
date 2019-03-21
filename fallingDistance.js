//Cycles through distance fallen over 1 to 10 seconds
//No parameter
//Prints time and distance fallen over that time into a table
function fallingDistance(){
	for(var i=1; i<=10; i++){
		//Opening the row
		document.write("<tr>");
		//filling the first column of the row with the time/counter
		document.write("<td>"+i+"</td>");
		//calculating and filling the second column with total
		document.write("<td>"+Number(i*i*.5*9.8).toFixed(1)+" meters</td>");
		//close the row
		document.write("</tr>");
	}
}