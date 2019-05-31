# Automated Time Table Generator
 - A web application that generates a timetable for a school/college without any scheduling overlaps existing.
 - Basic Entities
	 - Courses
	 - Sessions (Lecture / Lab)
   	- Teachers
   	- Rooms
## Courses
- Each course has an id, name.
- Courses consist of lectures and labs.
- Each lecture/lab in a course is assigned a teacher.
- Each lecture/lab is assigned a room.
- Each lecture/lab has an assigned number of hours.
## Teachers
- Each teacher has an id, phone, email.
- Teachers can be assigned more than one lecture/lab.
## Rooms
- There are classrooms and laboratories.
- Room scheduling cannot overlap.
## The interface allows the user to
- Input number of courses with their details. 
- For each course, define the number of lectures, labs.
- Input the number of rooms, their details. 
- Assign teachers and rooms to each lecture/lab.
## Output
- The output should be a timetable with no scheduling overlap. 
- In cases of an overloaded schedule and no available time slot, the system should notify the user to change room/teacher.
# Developing Side
- Back End Development 
	- Java
- Front End Development
	- AngularCLI
- RESTful API
	- JAX-RS
