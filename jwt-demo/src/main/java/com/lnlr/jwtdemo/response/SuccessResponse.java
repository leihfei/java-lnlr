package com.lnlr.jwtdemo.response;


public class SuccessResponse implements Response {

	@Override
	public String getResponseCode() {
		return Response.CODE_SUCCESS;
	}

	@Override
	public String getResponseMsg() {
		return Response.MSG_SUCCESS;
	}

}
