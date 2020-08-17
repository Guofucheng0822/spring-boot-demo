package com.pers.guofucheng.filterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准单
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class CriteriaSingle implements Criteria {
 
   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> singlePersons = new ArrayList<Person>(); 
      for (Person person : persons) {
         if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
            singlePersons.add(person);
         }
      }
      return singlePersons;
   }
}
