package com.hikvision.boot.commonservice.test;

import com.hikvision.boot.commoncore.test.TestDo;
import com.hikvision.boot.commondao.test.TestDao;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: nibinbin
 * @date: 2018/10/4 21:58
 * @modify by
 */
@Service
public class TestService {


    @Resource
    private TestDao testDao1;


    public TestDo testDo(String s) {
        return this.testDao1.selectById(s);
    }

    public TestDo selectById(String id) {
        TestDo testDo = this.testDao1.selectById(id);
        if(testDo == null) {
            System.out.println("testDo null");
        }
        return  null;
    }

    public List<TestDo> selectByMapper(String n1, Supplier<TestDo> supplier) {
        TestDo testDo = supplier.get();
        BiConsumer<String, TestDo> stringTestDoBiConsumer = (n11, testDo1) -> testDo1.setName(n11);
        stringTestDoBiConsumer.accept(n1, testDo);
        return this.testDao1.selectByMapper(testDo);
    }

    public List<TestDo> selectByIds() {
        List<String> ids = Arrays.asList("f32876adde7511e8a06354ee758567a6");
        List<TestDo> testDos = this.testDao1.selectByIds(ids);
        if(testDos == null) {
            System.out.println("testDos null");
        }
        return testDos;
    }

    @Cacheable(value = "user")
    public List<TestDo> selectAll(String ap){
        List<TestDo> result = this.testDao1.selectAll();
        return result;
    }

    @Cacheable(value = "user")
    public TestDo selectOne(){
        List<TestDo> result = this.testDao1.selectAll();
        System.out.println("i am in 12");
        return result.get(0);
    }

    @Cacheable(value = "random", key = "#p0")
    public String randomString(int randomSize){
        return String.valueOf(randomSize);
    }

    @Cacheable(value = "lists", key = "#p0")
    public List<String> lists(String listString) {
        List<String> result = new ArrayList<>();
        if(StringUtils.isNotBlank(listString)) {
            result.add(listString);
        }
        result.add("lists");
        return result;
    }

    @Cacheable(value = "sets", key = "#p0")
    public Set<String> sets(String setString) {
        Set<String> result = new HashSet<>();
        if(StringUtils.isNotBlank(setString)) {
            result.add(setString);
        }
        result.add("sets");
        return result;
    }

    @Cacheable(value = "maps", key = "#p0")
    public Map<String, String>  maps(String key) {
        Map<String, String> result = new HashedMap();
        result.put(key, key);
        result.put("result", "result");
        return result;
    }

    @Cacheable(value = "hmaps", key = "#p0")
    public Map<String, Integer>  hmaps(String key) {
        Map<String, Integer> result = new HashedMap();
        result.put(key, 1);
        result.put("result", 2);
        return result;
    }

    @CacheEvict(value = "random", allEntries = true)
    public void deleteRandom(){
        System.out.println("delete success");
    }

    public void  insert1() {
        char[][] ds = {{'a','z'},{'A','Z'},{'0','9'}};
        TestDo testDo = new TestDo();
        testDo.setName(new RandomStringGenerator.Builder().withinRange(ds).build().generate(10));
        testDo.setCreateTime(LocalDateTime.now());
        this.testDao1.insert1(testDo);
    }

    public void deleteList(){
        List<TestDo> dos = new ArrayList<>();
        TestDo do1 = new TestDo();
        do1.setId("e5df9edcde7111e8a06354ee758567a6");
        TestDo do2 = new TestDo();
        do2.setId("f3280f60de7511e8a06354ee758567a6");
        dos.add(do1);
        dos.add(do2);
        int a = 0;
        this.testDao1.deleteByIds(dos.stream().map(p-> p.getId()).collect(Collectors.toList()));
    }

    public void deleteByIds(){
        this.testDao1.deleteByIds(Arrays.asList("f3287455de7511e8a06354ee758567a6"));
    }

    public void deleteAll(){
        this.testDao1.deleteAll();
    }

    public void upadte(){
        TestDo testDo = new TestDo();
        testDo.setId("188ac466de8211e8a06354ee758567a6");
        testDo.setName("newName");
        this.testDao1.update(testDo);
    }

}
