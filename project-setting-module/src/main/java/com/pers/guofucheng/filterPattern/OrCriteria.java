package com.pers.guofucheng.filterPattern;

import java.util.List;

/**
 * 满足其中一个标准
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class OrCriteria implements Criteria {
 
   private Criteria criteria;
   private Criteria otherCriteria;
 
   public OrCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria; 
   }
 
   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
      List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);
 
      for (Person person : otherCriteriaItems) {
         if(!firstCriteriaItems.contains(person)){
           firstCriteriaItems.add(person);
         }
      }  
      return firstCriteriaItems;
   }
}
