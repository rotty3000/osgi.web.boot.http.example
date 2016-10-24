package jaxrs.example;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "osgi.jaxrs.resource.base=/examples/example-addon",
	service = ExampleAddon.class
)
public class ExampleAddon {

	@GET
	@Path("/{name}")
	public String sayHello(@PathParam("name") String name) {
		return "Hello " + name;
	}

	@PostConstruct
	public void init() {
		System.out.println("URIINFO: " + _uriInfo);
	}

	@Context
	UriInfo _uriInfo;

}
