
package coletanea.codigos.servidor.chat;

@SuppressWarnings("serial")
public class ChatException extends Exception {
	public ChatException(String msg) {
		super(msg);
	}

	public ChatException(Throwable cause) {
		super(cause);
	}

	public ChatException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
