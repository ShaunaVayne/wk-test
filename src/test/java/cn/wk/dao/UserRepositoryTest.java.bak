package cn.wk.dao;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;


/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/4 下午5:48
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
@RunWith(Arquillian.class)
@SpringApplicationConfiguration()
public class UserRepositoryTest {


    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void findByUserName() throws Exception {

    }

    @org.junit.Test
    public void findByUserOrEmail() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UserRepository.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
