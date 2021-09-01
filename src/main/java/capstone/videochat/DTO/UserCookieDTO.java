package capstone.videochat.DTO;

import java.util.Date;

public class UserCookieDTO {
    private boolean loginResult; //로그인 성공 여부
    private String cookieName; //쿠키 이름
    private String sessionId; //세션 id
    private Date validTime; //유효시간

    public boolean getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(boolean loginResult) {
        this.loginResult = loginResult;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }
}
