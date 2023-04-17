package com.agentbased.controller;

import com.agentbased.model.Role;
import com.agentbased.model.UserEntity;
import com.agentbased.services.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return systemAdminService.getAllUsers();
    }

    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return systemAdminService.createUser(userEntity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable(value = "id") Long id,
                                                 @RequestBody UserEntity userDetails) throws Exception {
        return systemAdminService.updateUser(id, userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id)
            throws Exception {
        return systemAdminService.deleteUser(id);
    }

    // Add more methods for managing roles, access control, etc.

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return systemAdminService.getAllRoles();
    }

    @PostMapping("/createRole")
    public Role createRole(@RequestBody Role role) {
        return systemAdminService.createRole(role);
    }

    @PutMapping("/update/role/{id}")
    public ResponseEntity<Role> updateUser(@PathVariable(value = "id") Long id,
                                                 @RequestBody Role userDetails) throws Exception {
        return systemAdminService.updateRole(id, userDetails);
    }

    @DeleteMapping("/delete/role/{id}")
    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") Long id)
            throws Exception {
        return systemAdminService.deleteRole(id);
    }
}

