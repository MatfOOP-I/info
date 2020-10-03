package z_dodatno01SingletonPattern;

import java.text.SimpleDateFormat;

public class Logger {
	// Privatna staticka referenca na 'Logger' objekat.
	private static Logger instance;
	private StringBuilder data;

	// Krijemo konstruktor od spoljasnjeg sveta.
	private Logger() {
		data = new StringBuilder();
	}
	
	// Kod se trivijalno moze naciniti bezbednim po niti sa:
	// public synchronized Logger get() { ... } no to vec
	// izlazi iz domena kursa. Vise o tome na kursu Razvoja softvera.
	public static Logger get() {
		if (instance == null)
			instance = new Logger();
		return instance;
	}
	
	private String timestamp() {
		return (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
	}
	
	public void logWarningMsg(String msg) {
		String tmp = "[" + timestamp() + "] WARNING: " + msg;
		System.out.println(tmp);
		data.append(tmp + "\n");
	}
	
	public void logErrorMsg(String msg) {
		String tmp = "[" + timestamp() + "] ERROR: " + msg;
		System.out.println(tmp);
		data.append(tmp + "\n");
	}
	
	public void logInfoMsg(String msg) {
		String tmp = "[" + timestamp() + "] INFO: " + msg;
		System.out.println(tmp);
		data.append(tmp + "\n");
	}
	
	public String getFullLogData() {
		return data.toString();
	}
	
	public void clearFullLogData() {
		data.setLength(0);
	}
}
