package rest.gateway;

import core.entities.User;
import core.usecases.CreateUser;
import rest.vo.UserVO;
import sql.daos.impl.UserEntityDAOImpl;
import sql.gateway.UserDAOGateway;

import static rest.adapters.UserVoAdapter.from;
import static rest.adapters.UserVoAdapter.to;

public class UserRestGateway {

    private CreateUser createUser = new CreateUser(new UserDAOGateway());

    public UserVO create(UserVO userVO) {
        return from(createUser.create(to(userVO)));
    }
}
