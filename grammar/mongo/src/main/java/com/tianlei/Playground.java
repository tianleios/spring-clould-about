package com.tianlei;

import com.mongodb.MongoClient;
import com.tianlei.domain.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class Playground {

    public static void main(String[] args) {

        Morphia morphia = new Morphia();
        morphia.mapPackage("com.tianlei.domain");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");

        //1. C create

        //2. U update
        {
         final Query<User> updateQuery =  datastore.createQuery(User.class).field("age").lessThan(21);
         final UpdateOperations<User> updateOperations = datastore.createUpdateOperations(User.class).inc("age",-2);
         UpdateResults results = datastore.update(updateQuery,updateOperations);


        }

        //3. R read
        {
            Query<User> query = datastore.createQuery(User.class);

            //获取所有
            List<User> users = query.asList();
            List<User> tianleiUser = query.field("name")
                    .equal("tianlei")
                    .asList();

        }
        {
            Query<User> query = datastore.createQuery(User.class);
            QueryResults<User> queryResults = query.field("age").greaterThan(Integer.valueOf(20));
            List<User> largeAgeUser = queryResults.asList();
            User largeAgeUser1 = queryResults.get();

        }

        {

            Query<User> query = datastore.createQuery(User.class);
            User user21 = query.filter("age <",21).get();

        }


        //4. D delete
        //创建查询

        int a = 10;


    }
}
