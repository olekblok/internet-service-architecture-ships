package org.example.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class ModelRestApiUrl {
    @Value("${isa.model.url.delete}")
    private String deleteUrl;
    @Value("${isa.model.url.put}")
    private String putUrl;
    @Value("${isa.model.url.post}")
    private String postUrl;
}
