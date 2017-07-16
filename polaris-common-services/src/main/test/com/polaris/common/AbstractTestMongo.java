package com.polaris.common;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author Mykola_Minaiev
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        TestMongoConfig.class
})
public abstract class AbstractTestMongo {
    private static MongodExecutable mongodExecutable;
    private static MongoClient mongoClient;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @BeforeClass
    public static void setUpClass() throws IOException {

        MongodStarter starter = MongodStarter.getDefaultInstance();

        int port = 12345;
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();

        try {
            mongodExecutable = starter.prepare(mongodConfig);
            MongodProcess mongod = mongodExecutable.start();

            mongoClient = new MongoClient(new ServerAddress(mongodConfig.net().getServerAddress(), mongodConfig.net().getPort()));
        } catch (IOException ioe) {
            tearDownClass();
        }
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
        if (mongodExecutable != null) {
            mongodExecutable.stop();
            mongodExecutable = null;
        }
    }
}