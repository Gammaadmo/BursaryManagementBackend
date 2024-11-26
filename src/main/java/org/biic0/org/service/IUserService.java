package org.biic0.org.service;

import org.biic0.org.domain.User;

import java.util.List;

public interface IUserService extends IService<User, String> {
    User update(org.apache.catalina.User user);

    List<User> getAll();
}
