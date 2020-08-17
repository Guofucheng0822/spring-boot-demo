package com.pers.guofucheng.filterPattern;

import com.pers.guofucheng.filterPattern.Criteria;
import com.pers.guofucheng.filterPattern.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准的男性
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class CriteriaMale implements Criteria {

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> malePersons = new ArrayList<Person>();
      for (Person person : persons) {
         if(person.getGender().equalsIgnoreCase("MALE")){
            malePersons.add(person);
         }
      }
      return malePersons;
   }
}
