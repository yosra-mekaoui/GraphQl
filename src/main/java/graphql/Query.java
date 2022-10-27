package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Query implements GraphQLRootResolver {
    private RendezVousRepository  rendezVousRepository;
    private LogementRepository logementRepository;
public Query(RendezVousRepository r, LogementRepository l) {
    this.logementRepository =l;
    this.rendezVousRepository=r;
}


    public List<RendezVous> allRendezVousList(){
    return this.rendezVousRepository.getListeRendezVous();
    }
    public List<RendezVous> getRdvsByLog(int reference) {
        return rendezVousRepository.getListeRendezVousByLogementRef(reference);
    }
    public RendezVous RendezVousbyId(int id) {
		return this.rendezVousRepository.getRendezVousbyId(id);
	}
    public List<Logement> allLogements() {
        return logementRepository.getAllLogements();
    }
    
    public Logement getLogementByRef(int reference) {
        return logementRepository.getLogementsByReference(reference);
     
    }
    public List<Logement> getLogementByType(Logement.Type type) {
        return logementRepository.getLogementsByType(type);
     
    }
   
}
