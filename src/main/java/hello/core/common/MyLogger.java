package hello.core.common;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
// @Scope(value = "request") // requestScope
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    // requestURL은 setter를 만들어서 나중에 중간에 들어오도록 setting
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("["+ uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString(); // uuid 생성 (unique한 값)
        System.out.println("["+ uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("["+ uuid + "] request scope bean close:" + this);
    }
}
