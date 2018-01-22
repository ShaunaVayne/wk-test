package cn.wk.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileUtil {

	public static void writeFile(ArrayList<String> list, String fileName, String filePath) {
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + fileName));
			for (String string : list) {
				//写数据
				bw.write(string);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		} catch (Exception e) {

		}
	}
}