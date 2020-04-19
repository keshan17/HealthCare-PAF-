package BasicAuth;
import BasicAuth.*;

import LoginModel.*;



import java.util.Base64;
import java.util.List;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER="Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX="Basic ";
	private static final String SECURED_URL_PREFIX="secured ";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
	if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
		
		List<String> authHeader =requestContext.getHeaders().get(AUTHORIZATION_HEADER);
		if(authHeader != null &&  authHeader.size() >0) {
			
			String authToken=authHeader.get(0);
			authToken=authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");	
			String decodedString=new String(Base64.getDecoder().decode(authToken));
					
			//String decodedString= Base64.decodeAsString(authToken); 
			StringTokenizer tokenizer=new StringTokenizer(decodedString, ":");
			String username=tokenizer.nextToken();
			String password=tokenizer.nextToken();
			
			if("user".equals(username) && "password".equals(password))
			{
				  if( ! Users.isUserAllowed(username, password, statusset))
	                {
	                	Response unauthoriazedStatus = Response
								.status(Response.Status.UNAUTHORIZED)
								.entity("{\"error\" : \"not authorized 3\"}")
								.build();
	                	requestContext.abortWith(unauthoriazedStatus);
	                   
	                }
			
			// LoginClass objClass=new LoginClass();
		}
		Response unauthorizedStatus= Response
										.status(Response.Status.UNAUTHORIZED)
										.entity("userr cannot access this resourses")
										.build();
		
		requestContext.abortWith(unauthorizedStatus);
			
		
		
	}

	}

	
	}
}
