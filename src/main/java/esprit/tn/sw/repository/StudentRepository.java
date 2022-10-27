package esprit.tn.sw.repository;

import java.util.ArrayList;
import java.util.List;


import esprit.tn.sw.entity.Student;

public class StudentRepository {
		private  List<Student> students;
		public StudentRepository()
		{
			
			students = new ArrayList<>();
			students.add(new Student("1234567890", "TEST TEST", "test@test.tn"));
			students.add(new Student("0987654321", "TEST1 TEST1", "test1@test1.tn"));
		}
		
		
		public List<Student> getALlStudents(){
			return students;
		}
		
		public Student getStudentbyCin(String cin) {
			for (Student s:students){
				if(s.getCin().equals(cin))
					return s;
			}
			return null;
		}
		public void saveStudent(Student student) {
			students.add(student);
			
		}
}
