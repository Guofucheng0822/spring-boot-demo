package com.pers.guofucheng.filterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准的女
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class CriteriaFemale implements Criteria {
 
   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> femalePersons = new ArrayList<Person>(); 
      for (Person person : persons) {
         if(person.getGender().equalsIgnoreCase("FEMALE")){
            femalePersons.add(person);
         }
      }
      return femalePersons;
   }
}
