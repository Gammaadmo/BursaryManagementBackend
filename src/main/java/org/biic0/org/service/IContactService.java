package org.biic0.org.service;

import org.biic0.org.domain.Contact;


import java.util.List;

public interface IContactService extends IService<Contact, String> {
        List<Contact> getAll();
    }
