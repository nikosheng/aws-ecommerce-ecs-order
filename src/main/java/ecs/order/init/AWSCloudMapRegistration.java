package ecs.order.init;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.servicediscovery.AWSServiceDiscovery;
import com.amazonaws.services.servicediscovery.AWSServiceDiscoveryClientBuilder;
import com.amazonaws.services.servicediscovery.model.RegisterInstanceRequest;
import com.amazonaws.services.servicediscovery.model.RegisterInstanceResult;
import ecs.order.util.MapBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.net.InetAddress;
import java.util.UUID;

public class AWSCloudMapRegistration implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(AWSCloudMapRegistration.class);

    @Value("${aws.servicediscovery.serviceId:}")
    private String cloudMapServiceId;
    @Value("${aws.servicediscovery.enabled:false}")
    private String enabled;

    @Autowired
    private AWSCredentialsProvider credentialsProvider;

    @Override
    public void run(String... args) throws Exception {

        if ("true".equals(enabled)) {
            AWSServiceDiscovery client = AWSServiceDiscoveryClientBuilder.standard()
                    .withRegion("ap-southeast-1")
                    .withCredentials(credentialsProvider)
                    .build();

            InetAddress ipv4 = InetAddress.getLocalHost();

            RegisterInstanceRequest request = new RegisterInstanceRequest()
                    .withServiceId(cloudMapServiceId)
                    .withInstanceId(UUID.randomUUID().toString().replaceAll("-", ""))
                    .withAttributes(
                            new MapBuilder.Builder<String>()
                                    .map("AWS_INSTANCE_IPV4", ipv4.getHostAddress())
                                    .build().map()
                    );
            RegisterInstanceResult result = client.registerInstance(request);
            log.info("AWS Cloud Map Register Instance Result: " + result.getOperationId());
        }
    }
}
