package rest;

import rest.gateway.UserRestGateway;
import rest.vo.UserVO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRest {

    @EJB
    private UserRestGateway gateway;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserVO user) {
        return Response.ok().entity(gateway.create(user)).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok().entity(gateway.findAll()).build();
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("code") String code) {
        return Response.ok(gateway.getUserByCode(code)).build();
    }

    @DELETE
    @Path("/{code}")
    public Response delete(@PathParam("code") String code) {
        UserVO vo = gateway.getUserByCode(code);
        gateway.delete(vo);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UserVO vo) {
        return Response.ok().entity(gateway.update(vo)).build();
    }
}
