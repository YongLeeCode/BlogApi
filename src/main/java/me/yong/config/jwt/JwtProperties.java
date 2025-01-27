package me.yong.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt") //yml파일에서 issuer와 secretKey 값 매핑
public class JwtProperties {
    private String issuer;
    private String secretKey;
}
