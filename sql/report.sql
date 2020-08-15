/////1. SQL statement that reports all the student of a specific class in this case 5/////

SELECT students.student_id, students.name, students.surname, students.email, students.fk_class_id FROM students
INNER JOIN classes 
ON students.fk_class_id = classes.class_id 
WHERE classes.class_id = 5;


/////2. SQL statement that reports all the student of a specific class in this case 2B/////

SELECT students.student_id, students.name, students.surname, students.email, students.fk_class_id FROM students
INNER JOIN classes 
ON students.fk_class_id = classes.class_id 
WHERE classes.class_name = '2B';