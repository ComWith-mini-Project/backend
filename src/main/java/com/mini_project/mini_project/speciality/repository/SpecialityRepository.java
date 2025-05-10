package com.mini_project.mini_project.speciality.repository;

import com.mini_project.mini_project.speciality.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}