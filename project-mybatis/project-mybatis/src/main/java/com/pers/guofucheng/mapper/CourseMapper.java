package com.pers.guofucheng.mapper;

import com.pers.guofucheng.pojo.Course;

import java.util.List;

/**
 * 课程(Course)表数据库访问层Mybatis实现
 *
 * @author guofucheng
 * @date 2020/08/25
 */
public interface CourseMapper {
    List<Course> findByCourseId(Integer courseId);
}
