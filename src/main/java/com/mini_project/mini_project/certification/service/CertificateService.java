package com.mini_project.mini_project.certification.service;

import com.mini_project.mini_project.certification.dto.CertificateRequestDto;
import com.mini_project.mini_project.certification.entity.Certificate;
import com.mini_project.mini_project.certification.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository repository;

    public List<Certificate> getAll() {
        return repository.findAll();
    }

    public Certificate create(CertificateRequestDto dto) {
        Certificate certificate = Certificate.builder()
                .name(dto.getName())
                .issuer(dto.getIssuer())
                .year(dto.getYear())
                .build();

        return repository.save(certificate);
    }

    public Certificate update(Long id, CertificateRequestDto dto) {
        Certificate certificate = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("자격증 및 수료 정보를 찾을 수 없습니다."));

        certificate.setName(dto.getName());
        certificate.setIssuer(dto.getIssuer());
        certificate.setYear(dto.getYear());

        return repository.save(certificate);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
