package com.pers.guofucheng.filterPattern;

import java.util.List;

/**
 * 满足多个标准
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public class AndCriteria implements Criteria {

    /**
     * 标准
     */
    private Criteria criteria;
    /**
     * 其他标准
     */
    private Criteria otherCriteria;

    /**
     * 需要满足多个标准对象
     *
     * @param criteria      标准
     * @param otherCriteria 其他标准
     */
    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria; 
   }

    /**
     * 满足标准【过滤器链】
     *
     * @param persons 人
     * @return {@link List<Person>}
     */
    @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);     
      return otherCriteria.meetCriteria(firstCriteriaPersons);
   }
}
