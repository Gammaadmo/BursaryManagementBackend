package org.biic0.org.controller;

import org.biic0.org.domain.Admin;
import org.biic0.org.domain.User;
import org.biic0.org.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody AdminRequest adminRequest) {
        Admin admin = adminService.create(
                new Admin.Builder()
                        .setAdminID(adminRequest.getAdminID())
                        .setPassword(adminRequest.getPassword())
                        .setUserName(adminRequest.getUserName())
                        .setUser(adminRequest.getUser())
                        .build()
        );
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> adminList = adminService.getall();
        return ResponseEntity.ok(adminList);
    }

    @GetMapping("/{adminID}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String adminID) {
        Admin admin = adminService.read(adminID);
        return admin != null ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{adminID}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String adminID, @RequestBody AdminRequest adminRequest) {
        Admin existingAdmin = adminService.read(adminID);
        if (existingAdmin != null) {
            Admin updatedAdmin = new Admin.Builder()
                    .setAdminID(adminID)
                    .setPassword(adminRequest.getPassword())
                    .setUserName(adminRequest.getUserName())
                    .setUser(adminRequest.getUser())
                    .build();
            return ResponseEntity.ok(adminService.update(updatedAdmin));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{adminID}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String adminID) {
        Admin admin = adminService.read(adminID);
        if (admin != null) {
            adminService.delete(adminID);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public static class AdminRequest {
        private String adminID;
        private String password;
        private String userName;
        private User user;

        public String getAdminID() {
            return adminID;
        }

        public void setAdminID(String adminID) {
            this.adminID = adminID;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
