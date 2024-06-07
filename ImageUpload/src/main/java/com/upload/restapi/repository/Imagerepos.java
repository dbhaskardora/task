package com.upload.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upload.restapi.model.Images;

public interface Imagerepos extends JpaRepository<Images, Integer>{

}
