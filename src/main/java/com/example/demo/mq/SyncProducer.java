package com.example.demo.mq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class SyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new
                DefaultMQProducer("email_send");
        producer.setNamesrvAddr("192.168.222.134:9876");
        producer.start();
        for (int i = 0; i <10 ; i++) {
            Message msg=new Message("lijin","push",
                    ("helloRocketmq"+i).getBytes(RemotingHelper.DEFAULT_CHARSET)
                    );
            SendResult sendResult=producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();

        System.out.println("over=============");
    }



    }

