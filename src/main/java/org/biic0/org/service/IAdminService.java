package org.biic0.org.service;
import org.biic0.org.domain.Admin;
import java.util.List;


public interface IAdminService extends IService<Admin,Long>{
         List<Admin> getall();

    Admin read(String adminID);

    void delete(String adminID);
}


