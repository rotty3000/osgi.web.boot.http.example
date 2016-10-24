package jaxrs.example;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"jaxrs.application.select=(component.name=com.liferay.portal.rest.example.ExampleApplication)",
		"osgi.jaxrs.filter.base=/examples"
	}
)
@Provider
public class ExampleFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext)
		throws IOException {

		System.out.println("FILTERED!");
	}

}
