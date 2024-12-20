package com.business.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig
{
    /*  If we @Autowired this instance in ServiceImpl then below is mandatory;
        Since we have @RequiredArgsConstructor so below not mandatory;   */
    @Bean
    public RestTemplate restTemplate()
    {
        return  new RestTemplate();
    }
}
