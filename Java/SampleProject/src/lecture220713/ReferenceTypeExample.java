package lecture220713;
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
*/
import java.util.*;

public class ReferenceTypeExample {
	public static void main(String[] args) {
		
		//배열과 비슷하지만
		//동적으로 크기 조절 가능하고
		//저장은 무조건 객체형태로만 저장된다 (primitive type 넣으려고 해도 wrapper객체를 통해 reference type으로 변환되어 저장)
		List list = new ArrayList<>();
		list.add("Hello");
		list.add("홍길동");
		list.add(100);// = list.add(new Integer(100));
		list.add(new Student());
		
		//List 만들어서 사용
		//대부분 같은 data type을 이용
		List<String> listStr = new ArrayList<String>();
		listStr.add("Hello");
		listStr.add("홍길동");
		//listStr.add(100); //ERROR : The method add(int, String) in the type List<String> is not applicable for the arguments (int)
		
		//Map
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "홍길동");
		map.put("2", "Hello");
		
	}
}
