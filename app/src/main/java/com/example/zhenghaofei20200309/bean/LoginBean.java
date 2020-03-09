package com.example.zhenghaofei20200309.bean;

import java.util.List;
/**
 * Zhenghaofei20200309
 * LoginBean
 * 2020-03-09
 */
public class LoginBean {



    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    List<result> list;

    public List<result> getList() {
        return list;
    }

    public void setList(List<result> list) {
        this.list = list;
    }

    public class result{
        String nickName;
        String headPic;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
