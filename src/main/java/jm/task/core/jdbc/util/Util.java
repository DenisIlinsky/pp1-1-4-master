package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static SessionFactory sessionFactory;
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    public static SessionFactory getUserSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            settings.setProperty("hibernate.connection.url", URL);
            settings.setProperty("hibernate.connection.username", USERNAME);
            settings.setProperty("hibernate.connection.password", PASSWORD);
            settings.setProperty("hibernate.current_session_context_class","thread");
            settings.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            settings.setProperty("hibernate.show_sql", "true");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(settings)
                    .build();

            configuration.setProperties(settings);

            sessionFactory = configuration
                    .setProperties(settings)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        } return sessionFactory;
    }
}


