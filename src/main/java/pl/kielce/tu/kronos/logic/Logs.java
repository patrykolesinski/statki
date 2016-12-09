package pl.kielce.tu.kronos.logic;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logs {
	public static final Logger LOGGER = Logger.getLogger("Logs");
	public static FileHandler fh;

	public static void logsToFileOn(String fileName) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("d_M_HH_mm_ss");
			fh = new FileHandler("D:/" + fileName + "_" + format.format(Calendar.getInstance().getTime()) + ".log");
			if (!fileName.equals("ServerLogs")) {
				LOGGER.setUseParentHandlers(false);
			}
			LOGGER.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
