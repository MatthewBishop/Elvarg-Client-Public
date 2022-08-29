package osrs;
import com.jagex.oldscape.pub.OtlTokenRequester;
import com.jagex.oldscape.pub.RefreshAccessTokenRequester;
public interface OAuthApi {
	boolean isOnLoginScreen();
	long getAccountHash();
	void setOtlTokenRequester(OtlTokenRequester var1);
	
	void setRefreshTokenRequester(RefreshAccessTokenRequester var1);
}
