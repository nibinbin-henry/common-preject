package com.hikvision.boot.commonutil.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/2/5 21:11
 * @modify by
 */
@Transactional(
        rollbackFor = Exception.class,
        propagation = Propagation.REQUIRED)
public @interface DefaultTransaction {
}
