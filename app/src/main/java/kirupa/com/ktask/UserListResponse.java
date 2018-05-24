package kirupa.com.ktask;

/**
 * Created by kirupa on 4/5/18.
 */

public class UserListResponse {


    /**
     * id : 437
     * name : mallikarjun
     * email : mallikarjunagv308@gmail.com
     * password : andro@12345
     * com_code : a0057aeb68080bbeca2ee424f9ff8485
     * status : INACTIVE
     * forgot : 79e8985ac9e95dfbef149303268348e9
     * logintype : email
     * uid : a0c6d2cf7fe3ce334657f1ef7ffc1d0a
     */

    private String id;
    private String name;
    private String email;
    private String password;
    private String com_code;
    private String status;
    private String forgot;
    private String logintype;
    private String uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCom_code() {
        return com_code;
    }

    public void setCom_code(String com_code) {
        this.com_code = com_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getForgot() {
        return forgot;
    }

    public void setForgot(String forgot) {
        this.forgot = forgot;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
