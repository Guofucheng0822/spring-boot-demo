package com.pers.guofucheng.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class Employee {
    /**
     * 名字
     */
    private String name;
    /**
     * 部门
     */
    private String dept;
    /**
     * 工资
     */
    private int salary;
    /**
     * 下属
     */
    private List<Employee> subordinates;
 
   //构造函数
   public Employee(String name,String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
      subordinates = new ArrayList<Employee>();
   }
 
   public void add(Employee e) {
      subordinates.add(e);
   }
 
   public void remove(Employee e) {
      subordinates.remove(e);
   }
 
   public List<Employee> getSubordinates(){
     return subordinates;
   }

   @Override
   public String toString(){
      return ("Employee :[ Name : "+ name 
      +", dept : "+ dept + ", salary :"
      + salary+" ]");
   }   
}
