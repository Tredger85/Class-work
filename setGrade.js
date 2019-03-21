//Andrew Franko
//Creating the object and the different items in student
function Student(studentID, firstName, lastName, grade) { 
    this.studentID = studentID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.grade = grade; 
    this.setGrade = function(newGrade) {
        return this.grade = newGrade;
    }
}

//Created three student objects as directed
var s1 = new Student("s1", "Jane", "Doe", "B");
var s2 = new Student("s2", "John", "Doe", "C");
var s3 = new Student("s3", "Mohammad", "Smith", "A");

//Created an array of the student so they can be looked at in a programatic way
var students = [s1, s2, s3];

//Creating the student table
function createTable(){
    //Headers
    document.write("<table border=&quot;3&quot;><tr><th>Student ID</th><th>First Name</th><th>Last Name</th><th>Grade</th></tr>");
    //Creating one line per student and writing the syntacs to HTML
    for(var i=0; i<students.length; i++){ 
        document.write("<tr>");
        document.write("<td> "+students[i].studentID+" </td>");
        document.write("<td> "+students[i].firstName+" </td>");
        document.write("<td> "+students[i].lastName+" </td>");
        document.write("<td> "+students[i].grade+" </td>");
        document.write("</tr>");
    }
    document.write("</table>")
} 
//Some gold plating of user input for setGrade
function setGrade(){
    var eID =  (document.form.student_id.value);
    var newGrade = (document.form.grade.value);
    //Testing for a valid letter grade
    if(newGrade=="A"||newGrade=="B"||newGrade=="C"||newGrade=="D"||newGrade=="F"){
        //Stepping through the array of students
        for(var i=0; i<students.length; i++){
            //Testing to see if the input is a studentID
            if (eID==students[i].studentID){
                //calling the setGrade function on the student object
                students[i].setGrade(newGrade);
                //recreating the student table
                createTable();
            }
        }
    }
}