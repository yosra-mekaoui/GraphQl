package esprit.tn.sw.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.tn.sw.entity.Logement;
import esprit.tn.sw.entity.RendezVous;
import esprit.tn.sw.repository.LogementRepository;
import esprit.tn.sw.repository.RendezVousRepository;






public class Query implements GraphQLRootResolver {
	
    private LogementRepository logementRepository;
    private RendezVousRepository rdvRepository;

    public Query(LogementRepository logementRepository,RendezVousRepository rdvRepository) {
        this.logementRepository = logementRepository;
		this.rdvRepository = rdvRepository;
    }

    public List<Logement> allLogements() {
        return logementRepository.getAllLogements();
    }
    
    public Logement getLogementByRef(int reference) {
        return logementRepository.getLogementsByReference(reference);
     
    }
    public List<RendezVous> getRdvsByLog(int reference) {
        return rdvRepository.getListeRendezVousByLogementRef(reference);
    }
    public List<RendezVous> allRendezVous() {
        return rdvRepository.getListeRendezVous();
    }

}
