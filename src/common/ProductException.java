package common;

public class ProductException extends Exception{

	private String m_messageID="";

	private Exception m_exceptionType;

	private Message m_message;


	public ProductException(String messageID) {
		this.m_messageID=messageID;

		m_message = new Message();
	}

	public ProductException(String messageID,Exception exceptionType) {
		this.m_messageID = messageID;
		this.m_exceptionType=exceptionType;
	}

		public String getMessage() {
			return m_message.getMessage(m_messageID);
		}

		public Exception getExceptionType() {
			return this.m_exceptionType;
		}
	}


