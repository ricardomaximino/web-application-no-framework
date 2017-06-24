package com.brasajava.servers;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/rest")
public class RestServer {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "Hello from rest web server using jersey";
	}
	
	//PARAM
	
	@GET
	@Path("/param/{pathParam}")
	@Produces(MediaType.TEXT_PLAIN)
	public String learn(@PathParam("pathParam")String pathParam,@MatrixParam("matrixParam") String matrixParam,@QueryParam("queryParam")String queryParam, @HeaderParam("headerParam") String headerParam,@CookieParam("cookieParam") String cookieParam){
		return "Path Param: " + pathParam + " \nQuery Param: " + queryParam + " \nMatrix Param: " + matrixParam + " \nHeader Param: " + headerParam + " \nCookie Param: " + cookieParam;
	}
	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	public String context(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
		return "Some URI-Info: " + uriInfo.getAbsolutePath() + " Some header: " + httpHeaders.getHeaderString("Content-Type");
	}
	
}
