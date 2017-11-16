package sql.gateway.impl;

import core.entities.User;
import sql.adapters.UserEntityAdapter;
import sql.dao.UserEntityDAO;
import sql.gateway.UserDAOGateway;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.stream.Collectors;

import static sql.adapters.UserEntityAdapter.from;
import static sql.adapters.UserEntityAdapter.to;

@Stateless
public class UserDAOGatewayImpl implements UserDAOGateway {

    @EJB
    private UserEntityDAO dao;

    @Override
    public User createUser(User user) {
        return to(dao.create(from(user)));
    }

    @Override
    public User findByCode(String code) {
        return to(dao.findByCode(code));
    }

    @Override
    public Collection<User> findAll() {
        return dao.findAll().stream().map(UserEntityAdapter::to).collect(Collectors.toList());
    }

    @Override
    public User update(User user) {
        return to(dao.update(from(user)));
    }

    @Override
    public void delete(User user) {
        dao.delete(from(user));
    }
}
