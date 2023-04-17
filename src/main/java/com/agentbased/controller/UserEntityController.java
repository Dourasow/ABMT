//package com.agentbased.controller;
//
//import com.agentbased.model.UserEntity;
//import com.agentbased.repositories.UserEntityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/users")
//public class UserEntityController {
//    @Autowired
//    private UserEntityRepository userEntityRepository;
//
//    @GetMapping("/getUsers")
//    public List<UserEntity> getUsers() {
//        return userEntityRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public UserEntity getUserById(@PathVariable Long id) throws Exception{
//        return userEntityRepository.findById(id).orElseThrow(() -> new Exception("User not found with id: " + id));
//    }
//
//    @PostMapping("/add")
//    public UserEntity createUser(@RequestBody UserEntity userEntity) {
//        return userEntityRepository.save(userEntity);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserEntity> updateUser(@PathVariable(value = "id") Long id,
//                                                 @RequestBody UserEntity userDetails) throws Exception, Exception {
//        UserEntity user = userEntityRepository.findById(id)
//                .orElseThrow(() -> new Exception("User not found for this id :: " + id));
//
//        // Update the user details
//        user.setUsername(userDetails.getUsername());
//        user.setEmail(userDetails.getEmail());
//        user.setPassword(userDetails.getPassword());
//        // ...
//
//        final UserEntity updatedUser = userEntityRepository.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @DeleteMapping("/{id}")
//    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id)
//            throws Exception {
//        UserEntity user = userEntityRepository.findById(id)
//                .orElseThrow(() -> new Exception("User not found for this id :: " + id));
//
//        userEntityRepository.delete(user);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
//
//
//}
//
