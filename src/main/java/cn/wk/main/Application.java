package cn.wk.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/3 下午4:02
 * @ProjectName: SpringBootTest2`
 * @Version: 1.0.0
 */
@ComponentScan(value = {"cn.wk"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
