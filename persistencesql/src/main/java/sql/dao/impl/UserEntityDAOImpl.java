package sql.dao.impl;

import sql.dao.UserEntityDAO;
import sql.entities.UserEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Stateless
public class UserEntityDAOImpl implements UserEntityDAO {

    @PersistenceContext(name = "cleanarc")
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
        String sql = "SELECT u FROM USER as u WHERE u.code = :code";
        TypedQuery<UserEntity> query = em.createQuery(sql, UserEntity.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Collection<UserEntity> findAll() {
        String sql = "SELECT u FROM USER as u";
        TypedQuery<UserEntity> query = em.createQuery(sql, UserEntity.class);
        return query.getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserEntity update(UserEntity user) {
        UserEntity entity = findByCode(user.getCode());
        user.setId(entity.getId());
        return em.merge(user);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(UserEntity userEntity) {
        userEntity = findByCode(userEntity.getCode());
        em.remove(userEntity);
    }
}
