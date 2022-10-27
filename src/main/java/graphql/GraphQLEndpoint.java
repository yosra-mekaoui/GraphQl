package graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {


    public GraphQLEndpoint(){
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LogementRepository lr = new LogementRepository();
        RendezVousRepository rdvRepo = new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(rdvRepo,lr), new Mutation(rdvRepo,lr))
                .build()
                .makeExecutableSchema();
    }
}