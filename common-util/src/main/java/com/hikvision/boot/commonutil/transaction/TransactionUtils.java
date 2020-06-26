package com.hikvision.boot.commonutil.transaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.function.Consumer;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/6/7 14:15
 * @modify by
 */
public class TransactionUtils {

    public static void beforeCommit(Consumer<Boolean> consumer) {
        register(new TransactionSynchronizationAdapter() {
            @Override
            public void beforeCommit(boolean readOnly) {
                consumer.accept(readOnly);
            }
        });
    }

    public static void beforeCommit(Consumer<Boolean> consumer, ExceptionHandler handler) {
        register(new TransactionSynchronizationAdapter() {
            @Override
            public void beforeCommit(boolean readOnly) {
                try {
                    consumer.accept(readOnly);
                }catch (Exception e) {
                    if(handler != null) {
                        handler.handler(e);
                    }
                }
            }
        });
    }

    private static void register(TransactionSynchronizationAdapter adapter) {
        TransactionSynchronizationManager.registerSynchronization(adapter);
    }

    public static class ExceptionHandler {
        public void handler(Exception e) {

        }
    }
}
