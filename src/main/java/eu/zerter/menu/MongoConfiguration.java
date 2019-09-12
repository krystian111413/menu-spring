package eu.zerter.menu;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "baza_krystian";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://krystian111413:zZz3uteE@ds123662.mlab.com:23662/baza_krystian");
    }
}
