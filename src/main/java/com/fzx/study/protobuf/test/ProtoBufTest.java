package com.fzx.study.protobuf.test;

import com.fzx.study.protobuf.DataInfo;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/9/4  15:07
 **/
public class ProtoBufTest {
    public static void main(String[] args) throws  Exception {
           DataInfo.Student student= DataInfo.Student.newBuilder().setName("张三").setAge(20).setAdress("北京").build();

            byte[] studentToByteArray=student.toByteArray();
            DataInfo.Student student2= DataInfo.Student.parseFrom(studentToByteArray);
            System.out.println(student2.toString());
    }
}
