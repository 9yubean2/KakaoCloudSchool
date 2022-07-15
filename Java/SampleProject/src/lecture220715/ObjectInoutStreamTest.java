package lecture220715;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class ObjectInoutStreamTest {
	public static void main(String[] args) {
		File file = new File("/Users/Dia/Desktop/readme.txt");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			Map<String,String> map = (Map<String,String>)obj;
			
			System.out.println(map.get("2"));
			
			ois.close();
			fis.close();
		}catch (Exception e){
			
		}
	}
}
