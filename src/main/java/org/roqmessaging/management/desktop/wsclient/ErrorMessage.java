package org.roqmessaging.management.desktop.wsclient;
/**
 * An error message coming from the RoQ server
 * @author Maxime Jeanmart
 *
 */
public class ErrorMessage {
	private String message;
	private RoQAnswer RoQAnswer;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RoQAnswer getRoQAnswer() {
		return RoQAnswer;
	}
	public void setRoQAnswer(RoQAnswer roQAnswer) {
		RoQAnswer = roQAnswer;
	}
	
	@Override
	public String toString() {
		return "error: message="+message+", RoQAnswer="+RoQAnswer;
	}
}
