package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.domain.model.User;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<Iterable<User>> getall() {
        return ResponseEntity.ok(userService.getAll());
    }

    @Operation(summary = "Insert new user")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
