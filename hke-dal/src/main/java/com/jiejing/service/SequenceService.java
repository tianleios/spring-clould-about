package com.jiejing.service;

import com.jiejing.dao.XmSequenceMapper;
import com.jiejing.model.XmSequence;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zc on 15/12/1.
 */
@Component public class SequenceService {
    @Resource private TransactionTemplate transactionTemplate;
    @Resource private XmSequenceMapper xmSequenceMapper;


    public long getSequence(final SequenceType sequenceType) {
        return transactionTemplate.execute(transactionStatus -> {
            XmSequence xmSequence =
                xmSequenceMapper.selectSequenceByCodeForUpdate(sequenceType.getCode());
            xmSequenceMapper.updateSequenceValueByCode(sequenceType.getCode());
            return genSequence(xmSequence.getValue(), sequenceType);
        });
    }

    /**
     * yyyymmdd+sequence
     *
     * @param sequence
     * @param sequenceType
     * @return
     */
    private long genSequence(long sequence, SequenceType sequenceType) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(new Date());
        return Long.valueOf(date + sequenceType.getCode() + sequence);
    }
}
