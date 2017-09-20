package org.garen.mc.mybatis.domain.demo;

import org.garen.mc.mybatis.domain.Author;
import org.garen.mc.util.JsonMapper;

import java.util.Date;

/**
 * 文件上传业务类
 *
 * @author Garen Gosling
 * @create 2017-09-18 13:22
 * @since v1.0
 */
public class AuthorDemo {
    /**
     * 作者对象例子
     *
     * @return  对象类型
     */
    public static Author getDemoObj(){
        Author author = new Author();
        author.setId(1L);
        author.setCode("CODE123456");
        author.setUcode("USER001");
        author.setPhone("13552979387");
        author.setIdNum("230502198803126666");
        author.setRealName("刘学良");
        author.setPenName("Garen Gosling");
        author.setCreateTime(new Date());
        author.setUpdateTime(new Date());
        return author;
    }

    /**
     *  作者对象例子
     *
      * @return Json类型
     */
    public static String getDemoJson(){
        return new JsonMapper().toJson(getDemoObj());
    }

    /**
     * 测试完记得注释，springBoot只能有一个main方法
     * @param args
     */
//    public static void main(String[] args){
//        System.out.println(getDemoJson());
//    }

}
