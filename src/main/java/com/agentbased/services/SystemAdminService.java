package com.agentbased.services;

import com.agentbased.model.Role;
import com.agentbased.model.UserEntity;
import com.agentbased.repositories.RoleRepository;
import com.agentbased.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemAdminService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    public UserEntity createUser(UserEntity userEntity) {
        // Perform necessary checks and validations before creating the user
        // ...
        return userEntityRepository.save(userEntity);
    }


    public ResponseEntity<UserEntity> updateUser(@PathVariable(value = "id") Long id,
                                                 @RequestBody UserEntity userDetails) throws Exception {

        UserEntity user = userEntityRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found for this id :: " + id));

        // Update the user details
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        // ...

        final UserEntity updatedUser = userEntityRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id)
            throws Exception {
        UserEntity user = userEntityRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found for this id :: " + id));

        userEntityRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
//roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        // Perform necessary checks and validations before creating the role
        // ...
        return roleRepository.save(role);
    }

//    public Role updateRole(Role role) {
//        // Perform necessary checks and validations before updating the role
//        // ...
//        return roleRepository.save(role);
//    }

    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") Long id,
                                                 @RequestBody Role userDetails) throws Exception {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new Exception("Role not found for this id :: " + id));

        // Update the role details
        role.setName(userDetails.getName());

        final Role updatedRole = roleRepository.save(role);
        return ResponseEntity.ok(updatedRole);
    }

//    public void deleteRole(Long roleId) {
//        // Perform necessary checks and validations before deleting the role
//        // ...
//        roleRepository.deleteById(roleId);
//    }

    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") Long id)
            throws Exception {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new Exception("Role not found for this id :: " + id));

        roleRepository.delete(role);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    // Other methods for managing user accounts and roles, user access and authority control, manage account limits/threshold, etc..
}

