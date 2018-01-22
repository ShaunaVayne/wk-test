package cn.wk.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/8/4 上午9:46
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
@Controller
@RequestMapping(value = "/first")
public class WebActionTest {

    @RequestMapping(value = "/test1",params = "name")
    public String foo1(Model model, @RequestParam(value = "name",defaultValue = "liujia") String name) {
        model.addAttribute("test",name);
        return "/test/hello";
    }

    @RequestMapping(value = "/test")
	public String foo2() {
    	return "/test/ajaxLong";
	}

	@RequestMapping(value = "/test3" )
	public void foo3(long timed, HttpServletResponse response) throws Exception {
		PrintWriter writer = response.getWriter();
		Random random = new Random();
		while(true) {
			Thread.sleep(300);//睡眠300毫秒,模拟业务功能
			int i = random.nextInt(100);//产生一个1-100之间的随机数
			if(i > 20 && i < 56) {
				long timeMillis = System.currentTimeMillis();
				//返回数据信息
				writer.print("result: " +i+ ",respone time:" +timeMillis+ ",request time:" +timed+ ",use time:" + (timeMillis - timed));
				break;//跳出循环, 返回数据
			}else {//模拟没有数据变化, 将休眠hold住连接
				Thread.sleep(100);
			}
		}
	}

}
