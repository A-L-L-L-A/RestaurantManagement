package management.exception;

public class DaoException extends RuntimeException {
	private static final long serialVersionUID = -5900990736983551757L;

	public DaoException() {

	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	} 
}
