package capstone.videochat.DTO;

public class UserLoginDTO {
    String id;
    String password;
    boolean useCookie; //아이디 기억하기 체크 여부

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUseCookie() {
        return useCookie;
    }

    public void setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
    }
}
