package com.liuyuhang.sell.utils;

import com.liuyuhang.sell.vo.ResultVO;

/**
 * @Auther: 刘宇航
 * @Date: 2019/11/18 00:07
 * @Description:
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
