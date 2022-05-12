package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "procurementEntityManagerFactory", basePackages = {
		"cl.chilecompra.mserv.repository"}, transactionManagerRef = "procurementTransactionManager")
public class ProcurementDBConfig {

	@Primary
	@Bean(name = "procurementDatasource")
	@ConfigurationProperties(prefix = "spring.procurement.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "procurementEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
																		   @Qualifier("procurementDatasource") DataSource dataSource) {

		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");

		return builder.dataSource(dataSource).properties(properties)
				.packages("cl.chilecompra.mserv.entity")
				.persistenceUnit("Platform").build();
	}

	@Primary
	@Bean(name = "procurementTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("procurementEntityManagerFactory")EntityManagerFactory entityManagerFactory) {

		return new JpaTransactionManager(entityManagerFactory);
	}
}
