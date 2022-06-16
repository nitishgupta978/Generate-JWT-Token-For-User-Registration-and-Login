package com.bridgelabz.user.registration.form.repository;

import com.bridgelabz.user.registration.form.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository <UserData, Integer> {

}
