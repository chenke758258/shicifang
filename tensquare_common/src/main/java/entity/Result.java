package entity;

import java.io.Serializable;

public class Result<T> implements Serializable {
    // 是否成功
    private Boolean flag;
    // 返回码
    private Integer code;
    // 返回信息
    private String message;
    // 返回数据
    private T data;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(Boolean flag, Integer code, String message, T data) {

        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
