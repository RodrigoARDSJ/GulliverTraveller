package br.com.fiap.traveller.rest;

import br.com.fiap.traveller.dao.UserDao;
import br.com.fiap.traveller.dao.impl.UserDaoImpl;
import br.com.fiap.traveller.models.User;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserEndpoint {
    private final EntityManager em = EntityManagerSingleton.getInstance().createEntityManager();
    private final UserDao dao = new UserDaoImpl(em);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> index() {
        return dao.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        try {
            dao.create(user);
            em.getTransaction().commit();
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
        if (user == null) return Response.status(Response.Status.BAD_REQUEST).build();
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
