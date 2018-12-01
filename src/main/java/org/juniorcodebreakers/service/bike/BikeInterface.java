package org.juniorcodebreakers.service.bike;

import org.juniorcodebreakers.model.Bikes;
import org.juniorcodebreakers.model.Status;

public interface BikeInterface {

   void addBike();
   void deleteBike(long bikeId);
   void changeStatus(long bikeId, Status newStatus);
   Bikes fetchAllBikes();
   Bikes fetchById(long bikeId);
   Bikes fetchByStatus(Status status);



}
