package org.juniorcodebreakers.service.bike;

import org.juniorcodebreakers.model.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BikeRepository extends CrudRepository<Bike,Long> {


}
