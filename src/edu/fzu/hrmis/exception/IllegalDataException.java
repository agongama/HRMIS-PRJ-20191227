/**
 * 
 */
package edu.fzu.hrmis.exception;

/**
 * 数据录入异常
 * @author yangzecong
 *
 */
public class IllegalDataException extends HRMISException {

	/**
	 * 
	 */
	public IllegalDataException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IllegalDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public IllegalDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
