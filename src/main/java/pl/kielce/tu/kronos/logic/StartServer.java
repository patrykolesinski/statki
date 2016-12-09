package pl.kielce.tu.kronos.logic;

import java.io.IOException;

public class StartServer {

	public StartServer() {
	}
	
	public static void main(String... args) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
		try {
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -cp server.jar pl.kielce.tu.kronos.logic.Server"});
			//String command = "cmd /c start cmd.exe || ipconfig";
			//Process child = Runtime.getRuntime().exec(command);
			//Process child= Runtime.getRuntime().exec("cmd /c start somebat.bat");
			//process = runtime.exec("start cmd");
			//process = runtime.exec("cmd java pl.kielce.tu.kronos.logic.Server");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("end");
	}

}
