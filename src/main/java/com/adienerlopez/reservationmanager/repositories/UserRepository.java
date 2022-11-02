package com.adienerlopez.reservationmanager.repositories;

import com.adienerlopez.reservationmanager.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query(
            value = "select u from User u where upper( u.username ) like upper(concat('%', :username, '%') )  "
    )
    public Page<User> findByUsername( @Param( "username" ) String username, Pageable p );
}
