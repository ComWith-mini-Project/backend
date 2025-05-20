package com.mini_project.mini_project.certification.repository;

import com.mini_project.mini_project.certification.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
