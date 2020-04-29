package cn.stylefeng.guns.petcage_busi.dto;

import cn.stylefeng.guns.petcage_busi.error.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by user chenzuoli on 2020/3/27 18:02
 * description: 返回给前端的数据传输结果对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultDTO {
    private Integer code;
    private Object data;
    private String msg;

    public static ResultDTO ok(Object data) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(0);
        resultDTO.setData(data);
        resultDTO.setMsg("请求成功");
        return resultDTO;
    }

    public static ResultDTO fail(String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(400);
        resultDTO.setData("");
        resultDTO.setMsg(message);
        return resultDTO;
    }

    public static ResultDTO fail(IErrorCode errorCode) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(errorCode.getCode());
        resultDTO.setMsg(errorCode.getMessage());
        return resultDTO;
    }

}