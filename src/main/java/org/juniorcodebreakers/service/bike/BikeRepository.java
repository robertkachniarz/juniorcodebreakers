package org.juniorcodebreakers.service.bike;

import org.juniorcodebreakers.model.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike,Long> {

}
