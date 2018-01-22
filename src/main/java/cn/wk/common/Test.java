package cn.wk.common;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/8 下午1:12
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class Test {
	public static void main(String[] args) {
		try {
			InputStream inputFile = new FileInputStream(new File("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/1.jpg"));
			File file = new File("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/1.jpg");
			byte[] buffer = new byte[(int) file.length()];
			int len = 0;
			String fileData = null;
			if ((len = inputFile.read(buffer)) != -1) {
				inputFile.close();
				fileData = new BASE64Encoder().encode(buffer);
			}
			/*BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/vayne/data/q.txt"));
			bw.write(fileData);
			bw.flush();
			bw.close();*/
			System.out.println(fileData.length());
			/*boolean b = deleteFile("/Users/vayne/data/q.txt");
			if(b) {
				System.out.println("ok");
			}*/
			/*File file = new File("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/a.jpg");
			if(file.exists()) {
				boolean b = deleteFile("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/a.jpg");
				if(b) {
					System.out.println("ok");
				}
			}*/
			/*File file = new File("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/a.jpg");
			if(file.exists()) {
				FileInputStream inputFile = new FileInputStream(file);
				byte[] buffer = new byte[(int) file.length()];
				int len = 0;
				String fileData = null;
				if ((len = inputFile.read(buffer)) != -1) {
					inputFile.close();
					fileData = new BASE64Encoder().encode(buffer);
				}
				System.out.println(fileData.length());
			}else {
				System.out.println("错误");
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 删除单个文件
	 *
	 * @param fileName
	 *            要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				//log.info("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				//log.warn("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			//log.warn("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}


}
