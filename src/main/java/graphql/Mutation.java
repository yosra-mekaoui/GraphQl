package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entity.Logement;
import entity.Logement.Type;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
    private RendezVousRepository  rendezVousRepository;
    private LogementRepository logementRepository;
    public Mutation(RendezVousRepository r, LogementRepository l) {
        this.logementRepository =l;
        this.rendezVousRepository=r;
    }

    public RendezVous createRendezVous(int id, String date,String heure, int refLog,String num){
        RendezVous r = new RendezVous(id,date,heure,logementRepository.getLogementsByReference(refLog),num);
        this.rendezVousRepository.addRendezVous(r);
        return r;

    }

    public Boolean updateRendezVous(int id, String date, String heure, String numTel){
    	Logement logement = rendezVousRepository.getLogementByRDV(id);
    	RendezVous rdv = new RendezVous(id,date,heure,logement,numTel);
    	System.out.println(rdv);
    	return rendezVousRepository.updateRendezVous(rdv);
    }
    public Boolean deleteRendezVous(int id) {
		return rendezVousRepository.deleteRendezVous(id);
	}
    public Logement createLogement(int reference, String adresse) {
        Logement logement = new Logement(reference,adresse);
        logementRepository.saveLogement(logement);
        return logement;
    }
}
