package message.util;

import lombok.Data;

/**
 * 类注释，描述
 *
 * @author dengdingwwen
 * @version $Id: Session.java,v 1.0 2018/12/12 15:30 dengdingwwen
 * @date 2018/12/12 15:30
 */
@Data
public class Session {

    private String userId;

    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}