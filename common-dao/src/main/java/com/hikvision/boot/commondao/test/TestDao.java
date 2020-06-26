package com.hikvision.boot.commondao.test;

import com.hikvision.boot.commoncore.test.TestDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: nibinbin
 * @date: 2018/10/4 22:25
 * @modify by
 */
@Mapper
public interface TestDao {
    void insert1(TestDo name);

    TestDo selectById(String id);

    List<TestDo> selectByMapper(TestDo testDo);

    List<TestDo> selectByIds(List<String> ids);

    List<TestDo> selectAll();

    void insert2(List<TestDo> dos);

    void deleteById(String id);

    void deleteByIds(List<String> ids);

    void deleteAll();

    void update(TestDo stestDo);

    /**
     * updateList 34
     * @param dos
     */
    void updateList(List<TestDo> dos);
}
