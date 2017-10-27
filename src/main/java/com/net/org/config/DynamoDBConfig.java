package com.net.org.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {
    @Value("${aws.dynamodb.accessKeyId}")
    private String awsDynamodbAccessKeyId;

    @Value("${aws.dynamodb.secretKey}")
    private String awsDynamodbSecreteKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(getCredentials()).withRegion(Regions.AP_NORTHEAST_1).build();
        return amazonDynamoDB;
    }

    public AWSCredentialsProvider getCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsDynamodbAccessKeyId, awsDynamodbSecreteKey));
    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB());
        return mapper;
    }

}