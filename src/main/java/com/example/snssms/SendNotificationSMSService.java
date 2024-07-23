package com.example.snssms;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Slf4j
@Component
public class SendNotificationSMSService {
    @Autowired

    SnsClient snsClient;
    public void pubTextSMS(String message, String phoneNumber) {
        try {
            System.out.println(">>>>>>>>> sending shite" );

            PublishRequest request = PublishRequest.builder()
                    .phoneNumber(phoneNumber)
                    .message(message).build();

            PublishResponse result = snsClient.publish(request);

            System.out.println(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
