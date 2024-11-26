package org.biic0.org.service;

import org.biic0.org.domain.Bursary;

import java.util.List;

public interface IBursaryService {

    Bursary create(Bursary bursary);

    List<Bursary> getAll();

    Bursary read(String bursaryId);

    Bursary read(Long bursaryId);

    Bursary update(Bursary bursary);

    boolean delete(String bursaryId);

    boolean delete(Long bursaryId);
}
