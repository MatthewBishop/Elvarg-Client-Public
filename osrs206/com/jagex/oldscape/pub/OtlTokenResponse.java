package com.jagex.oldscape.pub;

public interface OtlTokenResponse {
	boolean isSuccess();

	String getToken();

	String getAccessToken();

	String getRefreshToken();
}
