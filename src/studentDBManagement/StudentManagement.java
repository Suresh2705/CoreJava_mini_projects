package studentDBManagement;

import java.util.List;
import java.util.Set;

public interface StudentManagement {
	void addStudent(Student s);
	
	Student searchStudent(int id);

	List<Student> displayAllStudents();
	
	Student removeStudent(int id);
	
	void clearStudent();
	
	Set<Student> sortStudent();
	
	Student searchHighestMark();
}