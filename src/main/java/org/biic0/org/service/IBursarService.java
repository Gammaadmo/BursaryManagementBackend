package org.biic0.org.service;

import org.biic0.org.domain.Bursar;

import java.util.List;

public interface IBursarService {

    Bursar create(Bursar bursar);

    List<Bursar> getAll();

    Bursar read(String bursarId);

    Bursar update(Bursar bursar);

    boolean delete(String bursarId);
}
