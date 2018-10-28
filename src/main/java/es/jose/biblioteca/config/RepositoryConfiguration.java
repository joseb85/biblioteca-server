package es.jose.biblioteca.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Archivo de configuración de base de datos
 * @since 28-oct-2018
 * @author joseb85
 */
@Configuration
@EnableJpaRepositories
public class RepositoryConfiguration {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource( dataSource() );
        em.setPackagesToScan( new String[] { "es.jose.biblioteca.entities" } );
        em.setJpaVendorAdapter( vendorAdapter );
        em.setJpaProperties( additionalProperties() );
        
        return em;
    }
    
    
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        
        System.out.println(env.getProperty( "es.jose.driverClassName" ));
        System.out.println(env.getProperty( "es.jose.url" ));
        System.out.println(env.getProperty( "es.jose.username" ));
        System.out.println(env.getProperty( "es.jose.password" ));
        dataSource.setDriverClass( env.getProperty( "es.jose.driverClassName" ) );
        dataSource.setJdbcUrl( env.getProperty( "es.jose.url" ) );
        dataSource.setUser( env.getProperty( "es.jose.username" ) );
        dataSource.setPassword( env.getProperty( "es.jose.password" ) );
        dataSource.setIdleConnectionTestPeriod(1000);
        
        return dataSource;
    }
    
    
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory( entityManagerFactory().getObject());
        return transactionManager;
    }
    
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    
    private Properties additionalProperties() {
        return new Properties() {
            private static final long serialVersionUID = 5066887942579387179L; {
                setProperty( "hibernate.dialect", env.getProperty( "hibernate.dialect" ) );
                setProperty( "hibernate.show_sql", env.getProperty( "hibernate.show_sql" ) );
                setProperty( "hibernate.connection.autocommit", env.getProperty( "hibernate.connection.autocommit" ) );
                setProperty( "hibernate.generate_statistics", env.getProperty( "hibernate.generate_statistics" ) );
                setProperty( "jadira.usertype.autoRegisterUserTypes", env.getProperty( "jadira.usertype.autoRegisterUserTypes" ) );
            }
        };
    }
}
