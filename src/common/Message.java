package common;

import java.util.HashMap;

public class Message {

	final HashMap<String,String> m_messageMap;

	public Message() {
		m_messageMap=new HashMap<String,String>();
		m_messageMap.clear();

		m_messageMap.put("1001W","error1");
		m_messageMap.put("1002W","error2");
		m_messageMap.put("1003W","error3");
		m_messageMap.put("1004W","error4");
		m_messageMap.put("1005W","error5");
		m_messageMap.put("9000E","システムエラーが発生しました");

	}

	public String getMessage(String messageID) {
		return m_messageMap.get(messageID);
	}
}
