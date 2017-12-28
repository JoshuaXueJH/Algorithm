package com.joshua.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LogParser {
	/**
	 * 题二：程序员小明目前在做日志解析的工作，可是他遇到一种特殊的日志格式，如下所示。
	
	type=SYSCALL msg=audit(1434371271.277:135496) arch=c000003e syscall=2 success=yes exit=3 a0=7fff0054e929 a1=0 a2=1fffffffffff0000 a3=7fff0054c390 items=1 ppid=6265 pid=6266 auid=1000 uid=0 gid=0 euid=0 suid=0 fsuid=0 egid=0 sgid=0 fsgid=0 tty=pts0 ses=113 comm="cat" exe="/usr/bin/cat" key="ssh config change"
	
	请你替小明实现这种日志的解析：
	
	public HashMap<String, Object> parse(String log) {}
	
	
	举例说明： name=xiaoming  alias=jiaozhu  op=”change passwd”  age=20  sex=male 
	解析后得到  
		HashMap<String, Object>(
			“name”	 -> “xiaoming”,
	 		“alias” -> “jiaozhu”,
			“age”	 -> 20,
			“sex”	 -> “male”,
			“op”	 -> “change paswd”
		)
	 */
	public static void main(String[] args) {
		String log = "type=SYSCALL msg=audit(1434371271.277:135496) arch=c000003e syscall=2 success=yes exit=3 a0=7fff0054e929 a1=0 a2=1fffffffffff0000 a3=7fff0054c390 items=1 ppid=6265 pid=6266 auid=1000 uid=0 gid=0 euid=0 suid=0 fsuid=0 egid=0 sgid=0 fsgid=0 tty=pts0 ses=113 comm=\"cat\" exe=\"/usr/bin/cat\" key=\"ssh config change\"";
		Map<String, Object> logMap = new LogParser().parse(log);
		for (Entry<String, Object> entry : logMap.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public HashMap<String, Object> parse(String log) {
		if (log == null || log.isEmpty()) {
			return null;
		}

		HashMap<String, Object> logMap = new HashMap<String, Object>();
		
		String[] logPieces = splitLogToPieces(log);

		for (String logPiece : logPieces) {
			if (!logPiece.isEmpty() && logPiece != null) {
				logMap.put(logPiece.split("=")[0].trim(), logPiece.split("=")[1].trim().replace("\"", ""));
			}
		}
		return logMap;
	}

	public String[] splitLogToPieces(String log) {
		String[] logPieces = log.split(" ");

		int lastValidPiece = 0;
		for (int i = 0; i < logPieces.length; i++) {
			if (logPieces[i].contains("=")) {
				lastValidPiece = i;
			} else {
				logPieces[lastValidPiece] = logPieces[lastValidPiece] + " " + logPieces[i];
				logPieces[i] = "";
			}
		}
		return logPieces;
	}
}
