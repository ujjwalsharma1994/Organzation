package com.java.organization.dto;

public class RestResponse {

	private int statusCode;
	private String errorMessage;
	private String successMessage;
	private Object data;

	public RestResponse(int statusCode, String errorMessage, String successMessage, Object data) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.successMessage = successMessage;
		this.data = data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
