package com.pers.guofucheng.filterPattern;

/**
 * 实体类对象【被过滤的实体类】
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class Person {

    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 婚姻状况
     */
    private String maritalStatus;
 
   public Person(String name,String gender,String maritalStatus){
      this.name = name;
      this.gender = gender;
      this.maritalStatus = maritalStatus;    
   }
 
   public String getName() {
      return name;
   }
   public String getGender() {
      return gender;
   }
   public String getMaritalStatus() {
      return maritalStatus;
   }  
}
