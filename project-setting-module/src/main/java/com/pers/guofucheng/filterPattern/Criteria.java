package com.pers.guofucheng.filterPattern;

import java.util.List;

/**
 * 标准
 *
 * @author guofucheng
 * @date 2020/08/17
 */
public interface Criteria {
   /**
    * 满足标准
    *
    * @param persons 人
    * @return {@link List<Person>}
    */
   public List<Person> meetCriteria(List<Person> persons);
}
