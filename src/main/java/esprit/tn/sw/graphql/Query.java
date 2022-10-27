package esprit.tn.sw.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.tn.sw.entity.Student;
import esprit.tn.sw.repository.StudentRepository;

public class Query implements GraphQLRootResolver{
	
	private  StudentRepository studentRepository;
	
	public Query( StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	
	public List<Student> allStudents(){
		return this.studentRepository.getALlStudents();
	}
	
	public Student StudentbyCin(String cin) {
		return this.studentRepository.getStudentbyCin(cin);
	}
	
	
}
