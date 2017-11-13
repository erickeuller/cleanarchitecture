package sql.daos;

import sql.entities.UserEntity;

import javax.ejb.Stateless;

@Stateless
public interface UserEntityDAO {

    UserEntity create(UserEntity userEntity);

    UserEntity findByCode(String userEntity);

    UserEntity update(UserEntity user);

    void delete(UserEntity userEntity);
}
