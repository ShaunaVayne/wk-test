package cn.wk.dao;

import cn.wk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/4 下午5:39
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserOrEmail(String userName, String email);

}
