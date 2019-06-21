/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.thirdparty.jackson;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

/**
 * LearnObjectMapper
 *
 * @author suwei
 * @since 2019/6/4 : 8:32 PM
 **/
public class LearnObjectMapper {
    public static void main(String... args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Machine machine = objectMapper.readValue(machineJson, Machine.class);
        System.out.println(machine.getMemusedPercentage());
        System.out.println(machine.getDetails());
        System.out.println(machine);
        Product product = objectMapper.readValue(productJson, Product.class);
        System.out.println(product);

    }

    @Data
    public static class Product {
        String name;
        String category;
    }

    @Data
    public static class Machine {
        @JsonProperty("sysmeminfo:memused_percentage")
        private String memusedPercentage;
        private String[] ips;
        Map<String, Object> details;
    }

    private static final String machineJson = "{" +
            "\"sysmeminfo:memused_percentage\": 30," +
            "\"sysifstat:total:intraffic\": null," +
            "\"syscpuidle:cpuwa\": 0," +
            "\"sysifstat:total:outtraffic\": null," +
            "\"syscpuidle:cpuus\": 0," +
            "\"ips\": [" +
            "\"10.85.225.102\"" +
            "]," +
            "\"sysdiskinfo:total:used_size_percentage\": null," +
            "\"sn\": \"ALIYUN201905P312C41597\"," +
            "\"syscpuidle:usage\": {" +
            "\"usage\": [" +
            "{" +
            "\"name\": \"syscpuidle:cpusys\"," +
            "\"value\": 0" +
            "}," +
            "{" +
            "\"name\": \"syscpuidle:cpuus\"," +
            "\"value\": 0" +
            "}," +
            "{" +
            "\"name\": \"syscpuidle:cpuwa\"," +
            "\"value\": 0" +
            "}" +
            "]," +
            "\"all\": 0" +
            "}," +
            "\"id\": \"8159853\"," +
            "\"agent_state\": 0," +
            "\"syscpuidle:cpusys\": 0" +
            "}";

    private static final String productJson = "{" +
            "\"name\": \"Pear yPhone 72\"," +
            "\"category\": \"cellphone\"," +
            "\"details\": {" +
            "   \"displayAspectRatio\": \"97:3\"," +
            "   \"audioConnector\": \"none\"" +
            "   }" +
            "}";
}
