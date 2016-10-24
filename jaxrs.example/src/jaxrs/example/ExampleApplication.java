package jaxrs.example;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "osgi.jaxrs.application.base=/example-application",
	service = Application.class
)
public class ExampleApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String sayHello() {
		return "Hello world";
	}

}
