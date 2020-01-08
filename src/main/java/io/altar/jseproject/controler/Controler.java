package io.altar.jseproject.controler;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.Business.BusinessEntity;
import io.altar.jseproject.model.Entityy;
import io.altar.jseproject.model.EntityyDTO;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class Controler <T extends BusinessEntity<R,E>,R extends EntityRepository<E>,E extends Entityy, D extends EntityyDTO>{
	@Inject
	protected T service;
	@Context
	protected UriInfo context;

	
	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return "url : "+ context.getRequestUri().toString()+"is Ok";
	}
	
	@POST
	@Consumes("application/json")
	public Response addProduct(D d) {
		try {
			service.create(fromDTO(d));
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(404).entity(e.getMessage()).build();
		}
		
	}
	
	@PUT
	@Consumes("application/json")
	public Response editProduct(D d) {
		try {
			service.update(fromDTO(d));
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(404).entity(e.getMessage()).build();
	}
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getProduct(@PathParam("id")long id) {
		try {
			return Response.ok().entity(toDTO(service.read(id))).build();
		} catch (RuntimeException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteProduct(@PathParam("id")long id) {
		try {
			service.delete(id);
			return Response.status(204).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	
	@GET
	@Path("isEmpty")
	@Produces("text/plain")
	public boolean isEmpty() {
		return service.isEmpty();
	}
	
	@GET
	@Path("getAllIds")
	@Produces("application/json")
	public long[] geAllIdsarray() {
		return service.getAllIdsarray();
	}
	
	public abstract D toDTO(E e);
	public abstract E fromDTO(D d);
	
	
	
	
	
	
}
