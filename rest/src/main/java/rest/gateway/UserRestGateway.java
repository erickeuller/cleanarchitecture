package rest.gateway;

import rest.vo.UserVO;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface UserRestGateway {

    UserVO create(UserVO userVO);

    UserVO getUserByCode(String code);

    Collection<UserVO> findAll();

    void delete(UserVO vo);

    UserVO update(UserVO vo);
}
