package com.atguigu.common.config.exception;


import com.atguigu.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.ToString;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode
 */
@Data
@ToString
public class GuiguException extends RuntimeException{

    private Integer code;//状态码
    private String msg;//描述信息

    public GuiguException(Integer code,String msg){
        super(msg);
        this.code=code;
        this.msg=msg;
    }

    /**
     * 接收枚举类对象
     * @param resultCodeEnum
     */
    public GuiguException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
        this.msg=resultCodeEnum.getMessage();
    }
}
