class Student{
	constructor(studentId, studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.classes = [];
    }
    getStudentId() { return this.studentId; }

    getClasses() { return this.classes; }
   
    getStudentName() { return this.studentName; }

    setStudentId(newId){ this.studentId=newId; }
    
    setStudentName(newName){ this.studentName=newName; }

    addClasses(newCourse){ 
        this.classes.push(newCourse); 
        newCourse.studentTakingClass.push( this.studentName);
    }

    getClassNames() { return getCoursesName(this.classes); }
    
    removeCourse(courseID){
        for (var x = this.classes.length; x>=0; x--){
            if (this.classes[x] === courseID){
                this.classes.splice(x,1);
            }
        }
    }
}

class Course{
	constructor(courseSessionId, courseName) {
		this.courseSessionId = courseSessionId;
        this.courseName = courseName;
        this.studentTakingClass = [];
    }
    getSessionId() { return this.courseSessionId; }

    getCourseName(){ return this.courseName; }

    getStudents(){ return this.student; }
}

class Teacher{
	constructor(teacherName) {
		this.teacherName = teacherName;
		this.teachCourse = [];
    }
    getName() { return this.teacherName; }
    
    getCoursesName() {	return getCoursesName(this.teachCourse); }

    addCourse(course) { this.teachCourse.push(course); }
}

function getCoursesName(course) {	
    var courseName = [];
    for( let i = 0; i<course.length; i++){
        courseName.push(course[i].getCourseName()+" ("+course[i].getSessionId()+")");
    }
    return courseName;
}

function removeCourse (courses, courseName){
    for (var x =0; x<courses.lenth; x++){
        if (courses[x] === courseName){
            courses.splice(x,1);
        }
    }
}

var java1 = new Course(1501, "java 1");
var java2 = new Course(1502, "java 1");
var java3 = new Course(1503, "java 1");

var sql = new Course(1511, "SQL");

var history1 = new Course(1801, "World Histroy");
var history2 = new Course(1811, "American Histroy");

var tom = new Student(5500, "Tom Little");
var dick = new Student(5501, "Dick Stevenson");
var harry = new Student(5502, "Harry Johnson");

var teacher1 = new Teacher("John Harrison");
var teacher2 = new Teacher("Steve Simpson");
var teacher3 = new Teacher("Erin Janeway");

var courses = [java1,java2,java3,sql,history1,history2];
var teachers = [teacher1,teacher2,teacher3];
var students = [tom,dick,harry];

function findStudentsPerCourseId(courseSessionId){
    var result = [];
    for (student of students){
        if(student.getClasses().some(course =>
            course.courseSessionId === courseSessionId)){
                result.push(student);
        }
    }
    return result;
}

teacher1.addCourse(java1);
teacher1.addCourse(java3);

teacher2.addCourse(history1);
teacher2.addCourse(history2);

teacher3.addCourse(java2);
teacher3.addCourse(sql);

for(let a = 0; a<teachers.length; a++){
    console.log( teachers[a].getName() + " is teaching: "+teachers[a].getCoursesName());
}

tom.addClasses(java2);
tom.addClasses(history1);
tom.addClasses(sql);
tom.addClasses(java1);

dick.addClasses(history1);
dick.addClasses(history2);
dick.addClasses(java3);

harry.addClasses(history2);
harry.addClasses(sql);
harry.addClasses(java1);

for(let a = 0; a<students.length; a++){
    console.log( students[a].getStudentName() + " is taking: "+students[a].getClassNames());
}

for(let a = 0; a<courses.length; a++){
    console.log(courses[a].getCourseName() + " ("+courses[a].getSessionId()+") has the following students: ");
    for(let b = 0; b<courses[a].studentTakingClass.length; b++){
        console.log(courses[a].studentTakingClass[b] + ", ");
    }
}
console.log(findStudentsPerCourseId(1501));
tom.removeCourse(java2);
for(let a = 0; a<students.length; a++){
    console.log( students[a].getStudentName() + " is taking: "+students[a].getClassNames());
}