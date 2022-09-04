package org.sreekanth.ngm.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionFactoryConfigImpl implements SessionFactoryConfig {
	
	@Autowired
	private EntityManagerFactory factory;

	@Override
	@Bean
	public SessionFactory getSessionFactory() {
		return factory.unwrap(SessionFactory.class);
	}

}
