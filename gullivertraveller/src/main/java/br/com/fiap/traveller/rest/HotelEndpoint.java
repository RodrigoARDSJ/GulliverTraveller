package br.com.fiap.traveller.rest;

import java.util.List;

import javax.persistence.EntityManager;
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

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.dao.impl.HotelDaoImpl;
import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

@Path("/hotels")
public class HotelEndpoint {
	EntityManager em = EntityManagerSingleton.getInstance();
	private HotelDao dao = new HotelDaoImpl(em);
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hotel> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Hotel hotel) {
		if(hotel == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.create(hotel);
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		return Response.status(Response.Status.CREATED).entity(hotel).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Integer id) {
		Hotel hotel = dao.findById(id);
		if (hotel == null) return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.status(Response.Status.OK).entity(hotel).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, Hotel hotel) {
		if (dao.findById(id) == null) return Response.status(Response.Status.BAD_REQUEST).build();
		if (hotel  == null) return Response.status(Response.Status.BAD_REQUEST).build();
		hotel.setId(id);
		dao.update(hotel);		
		return Response.status(Response.Status.OK).entity(hotel).build();

	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") Integer id) {
		Hotel hotel = dao.findById(id);
		if (hotel == null) return Response.status(Response.Status.BAD_REQUEST).build();
		dao.delete(hotel);
		return Response.status(Response.Status.OK).build();
		
	}

}
