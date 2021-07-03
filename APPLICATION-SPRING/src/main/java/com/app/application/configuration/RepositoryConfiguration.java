package com.app.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.app.application.entity.Item;



@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configure)
	{
		
	//	configure.exposeIdsFor(entity_manager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
		configure.exposeIdsFor(Item.class);
	
		configure.getCorsRegistry().addMapping("/**").allowedOrigins("http://localhost:4200");
		
	}
}
