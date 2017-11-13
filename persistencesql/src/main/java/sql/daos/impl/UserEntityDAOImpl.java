package sql.daos.impl;

import sql.daos.UserEntityDAO;
import sql.entities.UserEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.concurrent.ThreadLocalRandom;

@Stateless
public class UserEntityDAOImpl implements UserEntityDAO {

    @PersistenceContext(name = "sqlpersistence")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserEntity create(UserEntity user) {
        em.persist(user);
        return user;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public UserEntity findByCode(String code) {
        String sql = "SELECT u FROM USER WHERE u.code = :code";
        TypedQuery<UserEntity> query = em.createQuery(sql, UserEntity.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserEntity update(UserEntity user) {
        return em.merge(user);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(UserEntity userEntity) {
        em.remove(userEntity);
    }
}
