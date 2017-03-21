package Neo4j.Java.API.Demo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

public class Neo4jJavaAPIDBOperation
{
    public static void main( String[] args ) {
        File gdbPath = new File("C:/Users/yi.zhou/IdeaProjects/DemoNeo4jDB");
        GraphDatabaseFactory gdbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDB = gdbFactory.newEmbeddedDatabase(gdbPath);

        try (Transaction gdbTransaction = graphDB.beginTx()){
            // Perform DB operation

            // Create nodes
            Node javaNode = graphDB.createNode(TutorialName.JAVA);
            Node scalaNode = graphDB.createNode(TutorialName.SCALA);

            // Set the node properties

            // Java node
            javaNode.setProperty("TutorialID", "JAVA001");
            javaNode.setProperty("Title", "Learn Java");
            javaNode.setProperty("NoOfChapters", "25");
            javaNode.setProperty("Status", "Completed");

            // Scala node
            scalaNode.setProperty("TutorialID", "SCALA001");
            scalaNode.setProperty("Title", "Learn Scala");
            scalaNode.setProperty("NoOfChapters", "20");
            scalaNode.setProperty("Status", "Completed");

            // Create a relationship from Java node to Scala node
            Relationship relationship = javaNode.createRelationshipTo(scalaNode, TutorialRelationships.JVM_LANGUAGES);
            relationship.setProperty("ID", "1234");
            relationship.setProperty("OOPS", "YES");
            relationship.setProperty("FP", "YES");

            gdbTransaction.success();
        }
        System.out.println("Done successfully");
    }
}
