package com.xlenc.party;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;

/**
 * User: Michael Williams
 * Date: 11/7/13
 * Time: 1:29 AM
 */
public class MongoHealthCheck extends HealthCheck {

    private final Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        super("MongoHealthCheck");
        this.mongo = mongo;
    }

    @Override
    protected HealthCheck.Result check() throws Exception {
        mongo.getDatabaseNames();
        return HealthCheck.Result.healthy();
    }

}
