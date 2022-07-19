package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam02_EchoServer {
    public static void main(String[] args){

        //fields
        //사용할 자원을 미리 선언해 놓기
        ServerSocket serverSocket = null;
        Socket socket = null;
        PrintWriter pr = null;
        BufferedReader br = null;

        try {

            serverSocket = new ServerSocket(6789);
            System.out.println("Echo Server 기동 - port : " + serverSocket.getLocalPort() +" client connection loading...");

            socket = serverSocket.accept(); //blocking method

            br = new BufferedReader(new InputStreamReader( socket.getInputStream() ));
            pr = new PrintWriter( socket.getOutputStream() );

            String msg = null;

            while(true){
                msg = br.readLine();
                if (msg.equals("/exit") || (msg ==null)){
                    //msg ==null 창을 강제 종료 했을 때
                    break;
                }

                pr.println(msg);
                pr.flush();

            }

        } catch (Exception e) {

        }
        finally {
            //사용된 resource를 해제
            try {
                //닫기 전에 null인지 아닌지 체크
                if (br != null) br.close();
                if (pr != null) pr.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
                System.out.println("서버 종료");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
