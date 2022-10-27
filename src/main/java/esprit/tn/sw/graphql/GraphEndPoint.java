package esprit.tn.sw.graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import esprit.tn.sw.repository.LogementRepository;
import esprit.tn.sw.repository.RendezVousRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;



@WebServlet(urlPatterns = "/Atelier2")
public class GraphEndPoint extends SimpleGraphQLServlet {
	
	public GraphEndPoint () {
		super(buildSchema());
	}
	
    private static GraphQLSchema buildSchema() {
    	LogementRepository logementRepository = new LogementRepository();
    	RendezVousRepository rdvRepository = new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(logementRepository,rdvRepository),new Mutation(logementRepository,rdvRepository))
                .build()
                .makeExecutableSchema();
    }

}
