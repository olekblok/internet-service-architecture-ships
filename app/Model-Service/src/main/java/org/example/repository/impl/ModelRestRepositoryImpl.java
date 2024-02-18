package org.example.repository.impl;

import org.example.configuration.ModelRestApiUrl;
import org.example.dto.GetModelResponse;
import org.example.dto.PutModelRequest;
import org.example.repository.ModelRestRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Repository
public class ModelRestRepositoryImpl implements ModelRestRepository {

    private final RestTemplate restTemplate;
    private final ModelRestApiUrl restApiUrl;

    public ModelRestRepositoryImpl(RestTemplate restTemplate, ModelRestApiUrl restApiUrl) {
        this.restTemplate = restTemplate;
        this.restApiUrl = restApiUrl;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete(restApiUrl.getDeleteUrl(), id);
    }

    @Override
    public void updateName(UUID id, PutModelRequest putModelRequest) {
        String url = UriComponentsBuilder.fromUriString(restApiUrl.getPutUrl())
                .pathSegment("{id}")
                .buildAndExpand(id)
                .toUriString();

        restTemplate.put(url, putModelRequest);
    }

    @Override
    public void addModel(GetModelResponse getModelResponse) {
        restTemplate.postForLocation(restApiUrl.getPostUrl(), getModelResponse);
    }
}
