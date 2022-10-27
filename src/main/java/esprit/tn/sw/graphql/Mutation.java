package esprit.tn.sw.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.tn.sw.entity.Logement;
import esprit.tn.sw.entity.RendezVous;
import esprit.tn.sw.repository.LogementRepository;
import esprit.tn.sw.repository.RendezVousRepository;




public class Mutation implements GraphQLRootResolver {
	
    private LogementRepository logementRepository;
    private RendezVousRepository rdvRepository;

    public Mutation(LogementRepository logementRepository,RendezVousRepository rdvRepository) {
        this.logementRepository = logementRepository;
        this.rdvRepository = rdvRepository;
    }
    
    public Logement createLogement(int reference, String adresse) {
        Logement logement = new Logement(reference,adresse);
        logementRepository.saveLogement(logement);
        return logement;
    }
    
    public Boolean updateRendezVous(int id, String date, String heure, String numTel){
    	Logement logement = rdvRepository.getLogementByRDV(id);
    	RendezVous rdv = new RendezVous(id,date,heure,logement,numTel);
    	System.out.println(rdv);
    	return rdvRepository.updateRendezVous(rdv);
    }
    
    public RendezVous createRendezVous(int id, String date, String heure, int refLog, String num) {
    	RendezVous rdv=new RendezVous(id, date, heure, logementRepository.getLogementsByReference(refLog), num);
    	
    	rdvRepository.addRendezVous(rdv);
    	return rdv;
    }
    
    public Boolean deleteRendezVous(int id) {
		return rdvRepository.deleteRendezVous(id);
	}

}
