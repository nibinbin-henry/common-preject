package com.hikvision.boot.commonaction.test;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.hikvision.boot.commoncore.test.TestDo;
import com.hikvision.boot.commondao.common.config.DbProperties;
import com.hikvision.boot.commondao.common.config.DbPropertiesOther;
import com.hikvision.boot.commonservice.test.TestService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.print.PSPrinterJob;

import javax.annotation.Resource;
import java.lang.ref.SoftReference;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

/**
 * @description:
 * @author: nibinbin
 * @date: 2018/10/4 11:03
 * @modify by
 */
@Controller
@RequestMapping("/test")
public class TestAction {


    @Resource
    private TestService testService;
    @Autowired
    private DbProperties dbProperties;
    @Autowired
    private DbPropertiesOther dbPropertiesOther;

    private List<TestDataModel> data = new ArrayList<>();
    private Map<Integer, TestDataModel> maps = new HashedMap();

    @RequestMapping("/dupm1")
    @ResponseBody
    public String dump1() {
        for(int i =0 ; i<20000 ; i++) {
            data.add(new TestDataModel(i, true));
            maps.put(Integer.valueOf(i), new TestDataModel(i, true));
        }
        return "true";
    }

    @RequestMapping("/wait1")
    @ResponseBody
    public String wait1() throws InterruptedException {
        synchronized (this) {
            this.wait();
        }
        return "true";
    }

    @RequestMapping("nsert1")
    @ResponseBody
    public boolean insert1() {
        System.out.println("1");
        this.testService.insert1();
        return  true;
    }

    
    @RequestMapping("/randomString")
    @ResponseBody
    public String randomString() {
        for(int i = 1; i<1000; i++) {
            System.out.println(testService.randomString(i));
        }
        return "t";
    }

    @RequestMapping("/lists")
    @ResponseBody
    public List<String> lists() {
        return testService.lists("lists1");
    }

    @RequestMapping("/sets")
    @ResponseBody
    public Set<String> sets() {
        return testService.sets("sets1");
    }

    @RequestMapping("/maps")
    @ResponseBody
    public Map<String, String> maps() {
        return testService.maps("maps1");
    }

    @RequestMapping("/hmaps")
    @ResponseBody
    public Map<String, Integer> hmaps() {
        return testService.hmaps("hmaps1");
    }

    @RequestMapping("/deleteRandom")
    @ResponseBody
    public void deleteRandom() {
        this.testService.deleteRandom();
    }

    @RequestMapping("/insert2")
    @ResponseBody
    public boolean insert2() {
        return true;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public boolean selectById() {
        return this.testService.selectById("") != null;
    }

    @RequestMapping("/selectByMapper")
    @ResponseBody
    public List<TestDo> selectByMapper(){
        return this.testService.selectAll("12");
    }

    @RequestMapping("/selectOne")
    @ResponseBody
    public TestDo selectOne(){
        return this.testService.selectOne();
    }

    @RequestMapping("/selectByIds")
    @ResponseBody
    public List<TestDo> selectByIds() {
        return  this.testService.selectByIds();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<TestDo> selectAll(){
        return this.testService.selectAll("56");
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public boolean deleteById() {
        return  true;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public boolean deleteAll() {
        SoftReference<String> dsd = new SoftReference<>("sd");
        this.testService.deleteAll();
        return  true;
    }

    @RequestMapping("/deleteList")
    @ResponseBody
    public boolean deleteList(){
        this.testService.deleteList();
        return true;
    }

    @RequestMapping("/deleteByIds")
    @ResponseBody
    public boolean deleteByIds(){
        this.testService.deleteByIds();
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(){
        this.testService.upadte();
        return true;
    }

    @RequestMapping("/property")
    @ResponseBody
    public String property(){
        return dbProperties.getUrl() + dbPropertiesOther.getUrl();
    }

    public static void main(String[] args) {
        timesamp();
        simpleDateFormat();
        dateFormatZone();
        instant2();
        localDateTime();
        instant();
        instant1();
        dateFormat();
        LocalDate date = LocalDate.now();
        date.plus(1, ChronoUnit.DAYS);
//        DateTimeFormatter forma
    }

    public static void dateFormat() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println();
    }

    public static void dateFormatZone() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter zoneFormat = dateFormat.withZone(ZoneOffset.of("-08:00"));
        System.out.println(LocalDateTime.now().format(zoneFormat));
    }

    public static void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("lcoaldateTime: " + localDateTime.getNano());
    }

    public static void instant2() {
        Instant instant = Instant.now();
        System.out.println(instant.getNano());
        System.out.println(new Date().getTime());
    }

    public static void simpleDateFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss", Locale.CHINESE);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    public static void instant() {
        Instant instant = Instant.now(Clock.system(ZoneOffset.ofHours(8)));
        ZonedDateTime zonedDateTime = instant.atZone(ZoneOffset.of("-08:00"));
        System.out.println(instant);
        System.out.println(zonedDateTime);
    }

    public static void instant1(){
        Clock utcClock = Clock.systemUTC();
        Clock defaultClock = Clock.systemDefaultZone();
        Clock offsetClock = Clock.offset(Clock.systemUTC(), Duration.ofHours(-5));

        ZoneId denverTimeZone = ZoneId.of("America/Denver");
        ZoneId newYorkTimeZone = ZoneId.of("America/New_York");
        ZoneId chicagoTimeZone = ZoneId.of("America/Chicago");
        ZoneId losAngelesTimeZone = ZoneId.of("America/Los_Angeles");

        Instant instant = Instant.now(defaultClock);
        Instant instant2 = Instant.now(utcClock);
        Instant instant3 = Instant.now(offsetClock);

        System.out.println(instant);
        System.out.println(instant2);
        System.out.println(instant3.plus(Duration.ofSeconds(90)));
        System.out.println(instant3.atZone(newYorkTimeZone));
        System.out.println(instant3.atZone(chicagoTimeZone));
        System.out.println(instant3.atZone(denverTimeZone));
        System.out.println(instant3.atZone(losAngelesTimeZone));
    }

    public static void timesamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("timestamp: " + timestamp.getTime());
    }
}
