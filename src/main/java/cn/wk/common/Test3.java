package cn.wk.common;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/12 下午2:38
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class Test3 {

	public static void main(String[] args) {
		//test1();
		//test2();
		test3();
		//test4();
	}

	private static void test4() {
		try {
			FileInputStream stream = new FileInputStream("/Users/vayne/data/1.txt");
			int read = stream.read();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private static void test3() {
		//Base64.encodeBase64String();
		//BASE64Encoder encoder = new BASE64Encoder();
		File file = new File("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/1.jpg");
		ArrayList<String> list = new ArrayList<>();
		if(file.exists()) {
			String fileData = null;
			try(FileInputStream inputFile = new FileInputStream(file)) {
				byte[] buffer = new byte[(int) file.length()];
				int len = 0;
				if ((len = inputFile.read(buffer)) != -1) {
					inputFile.close();
					//String encode = Base64.getEncoder().encodeToString(buffer);
					//String encode = Base64.encodeBase64String(buffer);
					//String pk = new BASE64Encoder().encode(buffer);
					byte[] bytes = cn.wk.common.Base64.encode(buffer);
					//pk.replaceAll("\r\n","");
					//String encode = new BASE64Encoder().encode(buffer);
					//encode = encode.replaceAll("[\\s*\t\n\r]", "");
					String pk = new String(bytes);
					list.add(pk);

					System.out.println(pk);
				}
				writeFile(list);
			}catch(Exception e) {
			}

		}
	}





	private static void writeFile(ArrayList<String> list) {

		try(FileWriter writer = new FileWriter("/Users/vayne/data/1.txt"); BufferedWriter bw = new BufferedWriter(writer)) {
			for (String string : list) {
				//写数据
				bw.write(string);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
		}
	}

	private static void test2()  {

		/*String basicEncoded = null;
		try {
			basicEncoded = Base64.getEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Using Basic Alphabet: " + basicEncoded);*/
	}

	private static void test1() {
		File file = new File("/Users/vayne/myself/tip/projects/SpringBootTest2/src/main/resources/static/1.jpg");
		/*if(file.exists()) {
			String fileData = null;
			try(FileInputStream inputFile = new FileInputStream(file)) {
				byte[] buffer = new byte[(int) file.length()];
				String encode = Base64.getEncoder().encodeToString(buffer);
				*//*int len = 0;
				if ((len = inputFile.read(buffer)) != -1) {
					inputFile.close();
					String encode = Base64.getEncoder().encodeToString(buffer);
				}*//*
				System.out.println(encode);
			}catch(Exception e) {

			}
		}*/
	}
}
