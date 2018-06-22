package com.app.whatslike.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.whatslike.models.Status;

public interface StatusRepository extends CrudRepository<Status, String> {

}
