package com.example.learningaws;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.polly.PollyClient;
import software.amazon.awssdk.services.polly.model.SynthesizeSpeechRequest;
import software.amazon.awssdk.services.polly.model.SynthesizeSpeechResponse;

/**
 * Created by tareqmy on 5/6/21.
 */
@Slf4j
public class Polly {

    public void helloPolly() {
        log.debug("Hello Polly");
        PollyClient pollyClient = PollyClient.builder()
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(ProfileCredentialsProvider.builder()
//                        .profileName("default")
                        .build())
                .build();

        SynthesizeSpeechRequest synthReq = SynthesizeSpeechRequest.builder()
                .text("Hello World")
                .voiceId("Aditi")
                .outputFormat("mp3")
                .build();
        ResponseInputStream<SynthesizeSpeechResponse> responseInputStream = pollyClient.synthesizeSpeech(synthReq);
        pollyClient.close();
        log.debug("Bye Polly");
    }
}
