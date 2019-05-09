package com.example.demo.common;

import lombok.Data;

import java.util.List;

@Data
public class ResultBody<T> {

    //返回数据代码 0 表示成功  1 表示失败
    private int code;
    //返回失败时的提示信息
    private String msg;
    //记录总数
    private int count;
    //记录集合
    private List<T> data;


    public static  <T> ResultBody  returnSuc(List<T> data){
        ResultBody resultBody=new ResultBody();
        resultBody.setCode(0);
        resultBody.setMsg("");
        resultBody.setData(data);
        resultBody.setCount(data.size());
        return  resultBody;
    }

    public static  <T> ResultBody  returnSucMsg(String msg){
        ResultBody resultBody=new ResultBody();
        resultBody.setCode(0);
        resultBody.setMsg(msg);
        resultBody.setCount(0);
        return  resultBody;
    }


    public static  <T> ResultBody  returnFail(String errorMsg){
        ResultBody resultBody=new ResultBody();
        resultBody.setCode(1);
        resultBody.setMsg(errorMsg);
        return  resultBody;
    }

}
