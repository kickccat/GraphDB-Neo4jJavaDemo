package Neo4j.Java.API.Demo;

import org.neo4j.cypher.internal.javacompat.ExecutionEngine;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

public class JavaNeo4jCQLRetrivalTest {
    public static void main(String[] args) {
        File gdbPath = new File("C:/Users/yi.zhou/IdeaProjects/DemoNeo4jDB");
        GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(gdbPath);

        // Neo4j Cypher Execution Engine

        @Deprecated
        // Old method deprecated
        /*ExecutionEngine executionEngine = new ExecutionEngine(graphDB);
          ExecutionResult executionResult = executionEngine.executeQuery("MATCH (java:JAVA) RETURN java");*/

        String result = graphDB.execute("MATCH (java:JAVA) RETURN java").resultAsString();

        //String results = executionResult.dumpToString();
        System.out.println(result);

    }
}
