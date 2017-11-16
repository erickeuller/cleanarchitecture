package rest.gateway.impl;

import core.boundaries.UserDAO;
import core.usecases.CreateUser;
import core.usecases.DeleteUser;
import core.usecases.GetUser;
import core.usecases.UpdateUser;
import rest.adapters.UserVoAdapter;
import rest.gateway.UserRestGateway;
import rest.vo.UserVO;
import sql.gateway.UserDAOGateway;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.stream.Collectors;

import static rest.adapters.UserVoAdapter.from;
import static rest.adapters.UserVoAdapter.to;

@Stateless
public class UserRestGatewayImpl implements UserRestGateway {

//    @EJB
//    private UserDAOGateway dao;

    private UserDAO dao = new nosql.gateway.UserDAOGateway();

    @Override
    public UserVO create(UserVO userVO) {
        CreateUser createUser = new CreateUser(dao);
        return from(createUser.create(to(userVO)));
    }

    @Override
    public UserVO getUserByCode(String code) {
        GetUser getUser = new GetUser(dao);
        return from(getUser.byCode(code));
    }

    @Override
    public Collection<UserVO> findAll() {
        GetUser getUser = new GetUser(dao);
        return getUser.findAll().stream().map(UserVoAdapter::from).collect(Collectors.toList());
    }

    @Override
    public void delete(UserVO vo) {
        DeleteUser deleteUser = new DeleteUser(dao);
        deleteUser.delete(to(vo));
    }

    @Override
    public UserVO update(UserVO vo) {
        UpdateUser updateUser = new UpdateUser(dao);
        return from(updateUser.update(to(vo)));
    }
}
