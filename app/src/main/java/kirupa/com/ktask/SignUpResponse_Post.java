package kirupa.com.ktask;

/**
 * Created by kirupa on 4/5/18.
 */


public class SignUpResponse_Post {

    private String success;

    private String message;
    private Integer userid;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

}