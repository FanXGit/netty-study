package com.fzx.study.protobuf.test;

import com.fzx.study.protobuf.DataInfo;

/**
 * @Author:Fzx
 * @Description:
 * @Date :2019/9/4  15:07
 **/
public class ProtoBufTest {
    public static void main(String[] args) throws  Exception {
           DataInfo.Student student= DataInfo.Student.newBuilder().setName("����").setAge(20).setAdress("����").build();

            byte[] studentToByteArray=student.toByteArray();
            DataInfo.Student student2= DataInfo.Student.parseFrom(studentToByteArray);
            System.out.println(student2.toString());
    }
}
