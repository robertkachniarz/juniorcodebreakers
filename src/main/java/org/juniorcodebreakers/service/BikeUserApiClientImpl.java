package org.juniorcodebreakers.service;

import org.juniorcodebreakers.model.user.BikeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class BikeUserApiClientImpl implements BikeUserApiClient {
    private final RestOperations restTemplate;

    @Autowired
    public BikeUserApiClientImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BikeUser fetchBikeUserInfo(String bikeUserId) {
        return null;
    }

}
