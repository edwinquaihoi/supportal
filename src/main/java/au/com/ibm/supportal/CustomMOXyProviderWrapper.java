package au.com.ibm.supportal;

import javax.ws.rs.ext.Provider;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

@Provider
public class CustomMOXyProviderWrapper extends MOXyJsonProvider {

}
