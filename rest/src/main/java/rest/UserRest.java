package rest;

import javafx.application.Application;
import rest.gateway.UserRestGateway;
import rest.vo.UserVO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/users")
public class UserRest {

    private UserRestGateway gateway;

    @POST
    @Consumes()
    public UserVO create(UserVO user) {
        return gateway.create(user);
    }
}
