package com.codeing.tabuser.book;

import java.util.List;

/**
 * @author Yorlg
 * @data 2021/12/30 11:27
 * @apiNote
 */
public class JsonResult<T> {

    /**
     * 200成功,!200就是失败
     */
    public int code;


    /**
     * 返回提示语
     */
    public String msg;

    /**
     * 返回的数据
     */
    public List<T> data;
}
