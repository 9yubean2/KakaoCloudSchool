package lecture220715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
	public static void main(String[] args) throws IOException {
		System.out.println("키보드로 한줄을 입력하세요!!");
		//키보드(표준입력-System.in)를 통해 데이터를 1줄 입력받기
		//이 System.in이라는 제공된 Stream은 사용하기 너무 힘들어요
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String input = br.readLine();
			System.out.println("입력받은 문자열은: " + input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
