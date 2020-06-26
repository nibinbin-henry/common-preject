package com.hikvision.boot.commonservice.test;

import com.hikvision.boot.commoncore.test.TestDo;
import com.hikvision.boot.commondao.test.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/4/19 11:01
 * @modify by
 */
@Service("userService")
public class UserServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private TestDao testDao;

    public List<TestDo> selectAll() {
        List<TestDo> dos = testDao.selectAll();
        logger.info("dos: " + dos);
        return dos;
    }
}
