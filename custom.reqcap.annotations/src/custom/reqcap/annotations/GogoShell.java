package custom.reqcap.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.osgi.namespace.implementation.ImplementationNamespace;

import aQute.bnd.annotation.headers.RequireCapability;

@RequireCapability(
	filter = "(" + ImplementationNamespace.IMPLEMENTATION_NAMESPACE + "=gogo.shell)",
	ns = ImplementationNamespace.IMPLEMENTATION_NAMESPACE
)
@Retention(RetentionPolicy.CLASS)
public @interface GogoShell {}