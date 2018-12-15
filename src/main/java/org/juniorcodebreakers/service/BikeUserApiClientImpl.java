package org.juniorcodebreakers.service;

import org.juniorcodebreakers.model.user.BikeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;


@Service
public class BikeUserApiClientImpl implements BikeUserApiClient {
    private final RestOperations restTemplate;
    private final String url;

    @Autowired
    public BikeUserApiClientImpl(RestOperations restTemplate, @Value("http://localhost:8080/users") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public BikeUser fetchBikeUserInfo(String bikeUserId) {
        BikeUser bikeUser = restTemplate.getForObject(url + "/" + bikeUserId + "/details", BikeUser.class);
        BikeUser bikeUser1 = new BikeUser();
        bikeUser1.setLogin(bikeUser.getLogin());
        bikeUser1.setPassword(bikeUser.getPassword());
        bikeUser1.setE_mail(bikeUser.getE_mail());

        return bikeUser1;

        /*Book book = restTemplate.getForObject(url + "/" + bookId + "/details", Book.class);
        return new Book(bookId, book.getTitle(), book.getAuthor(), book.getDescription());*/

    }
}
