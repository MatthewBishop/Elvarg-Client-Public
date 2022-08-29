package com.jagex.oldscape.pub;

public interface OAuthApi {
	void setRefreshTokenRequester(RefreshAccessTokenRequester var1);

	boolean isOnLoginScreen();

	long getAccountHash();

	void setOtlTokenRequester(OtlTokenRequester var1);
}
