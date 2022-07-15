package lecture220715;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectStreamTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("1","Anne");
		map.put("2","Bred");
		map.put("3","Charlie");
		
		File file = new File("/Users/Dia/Desktop/readme.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
