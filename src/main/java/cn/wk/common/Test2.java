package cn.wk.common;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/8 下午2:53
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class Test2 {

	public static void main(String[] args) throws FileNotFoundException {
		/*FileInputStream is = new FileInputStream(new File("/Users/vayne/myself/tiancheng/projects/ecurrency-schedule/ecurrency-schedule-web/src/test/resources/q.txt"));
		boolean b = FtpUtil.uploadFile("192.168.157.85", 21, "wangkun", "wangkun", "/", "q.txt",is );
		if(b) {
			System.out.println("ok");
		}*/
		String time = String.valueOf(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
		System.out.println(time);
	}
}
