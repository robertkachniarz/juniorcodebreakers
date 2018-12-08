package org.juniorcodebreakers.service;

import org.juniorcodebreakers.model.user.BikeUser;

public interface BikeUserApiClient {
    /*Users fetchAllBooks();*/

    BikeUser fetchBikeUserInfo(String bikeUserId);

}
