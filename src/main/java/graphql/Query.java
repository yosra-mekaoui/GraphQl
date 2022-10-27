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
}
