package com.example.demographql.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by wilyanto.salim
 * on 1/17/18.
 */

@Configuration
@Profile("!test")
public class FlywayConfiguration {
    @Bean(name = {"flyway", "flywayInitializer"})
    public Flyway flywayInitializer(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setValidateOnMigrate(false);
        flyway.setDataSource(dataSource);
//        flyway.setLocations("classpath:db/migration");
        flyway.setBaselineVersionAsString("0");
        flyway.setBaselineOnMigrate(true);
//        flyway.clean();
        flyway.migrate();
        return flyway;
    }
}
