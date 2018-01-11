package com.cmbchina.drill.producer.service.impl;

import static com.cmbchina.drill.common.enums.ProducerResult.FAILURE;
import static com.cmbchina.drill.common.enums.ProducerResult.SUCCESS;

import com.cmbchina.drill.common.enums.ProducerResult;
import com.cmbchina.drill.producer.service.KafkaProducerDemoService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by sanshui on 2017/12/19.
 */
@Service
public class KafkaProducerDemoServiceImpl implements KafkaProducerDemoService {

    private static Logger logger = LoggerFactory.getLogger(KafkaProducerDemoServiceImpl.class);

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public ProducerResult createProducer() {
        try {
            kafkaTemplate.send("kafkaDemo","SUCCESSFULLY");
            return SUCCESS;
        } catch (Exception e) {
            return FAILURE;
        }
    }
}
