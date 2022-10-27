package esprit.tn.sw.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.tn.sw.entity.Student;
import esprit.tn.sw.repository.StudentRepository;

public class Mutations implements GraphQLRootResolver{
	
	private StudentRepository studentRepo ;
	public Mutations(StudentRepository repo) {
		this.studentRepo =repo ;
		
		
	}
	
	public Student addStudent(String cin  , String nompre  ,String email) {
		Student s = new Student(cin, nompre, email);
		//this.studentRepo.saveStudent(s);
		return s ;
	}
	
	
}
