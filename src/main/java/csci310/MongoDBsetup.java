package csci310;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.Arrays;

public class MongoDBsetup {
    protected static MongoClient getMongoClient(){
        //creating credentials
        MongoCredential cred = MongoCredential.createCredential("feire","MyDB","mongoDBpw".toCharArray());

        //creating client
        MongoClient mongo = new MongoClient(new ServerAddress("localhost",27017), Arrays.asList(cred));
        return mongo;
    }
}
