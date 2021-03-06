package br.com.fiap.traveller.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.traveller.dao.UserDao;
import br.com.fiap.traveller.models.User;

@Path("/users")
public class UserEndpoint {
	private UserDao dao = new UserDao();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		if(user == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.create(user);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		return Response.status(Response.Status.CREATED).entity(user).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Integer id) {
		User user = dao.findById(id);
		if (user == null) return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.status(Response.Status.OK).entity(user).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, User user) {
		if (dao.findById(id) == null) return Response.status(Response.Status.BAD_REQUEST).build();
		if (user  == null) return Response.status(Response.Status.BAD_REQUEST).build();
		user.setId(id);
		dao.update(user);		
		return Response.status(Response.Status.OK).entity(user).build();

	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") Integer id) {
		User user = dao.findById(id);
		if (user == null) return Response.status(Response.Status.BAD_REQUEST).build();
		dao.delete(user);
		return Response.status(Response.Status.OK).build();
		
	}

}
