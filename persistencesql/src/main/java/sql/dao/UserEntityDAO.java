package sql.dao;

import sql.entities.UserEntity;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface UserEntityDAO {

    UserEntity create(UserEntity userEntity);

    UserEntity findByCode(String userEntity);

    Collection<UserEntity> findAll();

    UserEntity update(UserEntity user);

    void delete(UserEntity userEntity);
}
