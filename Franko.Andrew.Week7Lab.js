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

    addClasses(newCourse){ this.classes.push(newCourse); }

    getCourseName() {	
        return getCoursesName(this.classes);
    }

    removeCourse(courseName) {
        removeFrom(this.classes, courseName);
    }
}

class Course{
	constructor(courseSessionId, courseName) {
		this.courseSessionId = courseSessionId;
		this.courseName = courseName;
    }
    getSessionId() { return this.courseSessionId; }

    getCourseName(){ return this.courseName; }
}

class Teacher{
	constructor(teacherName) {
		this.teacherName = teacherName;
		this.teachCourse = [];
    }
    getName() { return this.teacherName; }
    
    getCoursesName() {	return getCoursesName(this.teachCourse); }

    addCourse(course) { this.teachCourse.push(course); }

    removeCourse(courseName){ removeFrom(this.teachCourse,courseName); }
}

function removeFrom(from, courseName){
    for( let x = 0; x<from.length; x++){
        if(from[x].getCourseName()===courseName){
            delete from[x];
        }
    }
}

function getCoursesName(course) {	
    var courseName = [];
    for( let i = 0; i<course.length; i++){
        courseName.push(course[i].getCourseName()+" ("+course[i].getSessionId()+")");
    }
    return courseName;
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

var courses = [];
courses.push(java1);
courses.push(java2);
courses.push(java3);
courses.push(sql);
courses.push(history1);
courses.push(history2);

var teachers = [];
teachers.push(teacher1);
teachers.push(teacher2);
teachers.push(teacher3);

var students = [];
students.push(tom);
students.push(dick);
students.push(harry);

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
    console.log( students[a].getStudentName() + " is taking: "+students[a].getCourseName());
}

tom.removeCourse(java2);

console.log("Tom drops the second session of java, and then --")
console.log( tom.getStudentName() + " is taking: "+tom.getCourseName());

console.log(findStudentsPerCourseId(1501));