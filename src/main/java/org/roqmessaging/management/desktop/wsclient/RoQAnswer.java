package org.roqmessaging.management.desktop.wsclient;
/**
 * A RoQ anwser message coming from an error message
 * @author Maxime Jeanmart
 *
 */
public class RoQAnswer {
	private int RESULT;
	private String COMMENT;
	public int getRESULT() {
		return RESULT;
	}
	public void setRESULT(int rESULT) {
		RESULT = rESULT;
	}
	public String getCOMMENT() {
		return COMMENT;
	}
	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	
	@Override
	public String toString() {
		return "RESULT: "+RESULT+", COMMENT: "+COMMENT;
	}
}
