package com.mini_project.mini_project.activity.repository;

import com.mini_project.mini_project.activity.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
