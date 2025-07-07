package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.UserRole;
import io.gabo.schoolbridgeapi.repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public List<UserRole> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getRoleById(@PathVariable Long id) {
        return roleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-dbname/{dbName}")
    public ResponseEntity<UserRole> getRoleByDbName(@PathVariable String dbName) {
        return roleRepository.findByDbNameIgnoreCase(dbName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserRole createRole(@RequestBody UserRole role) {
        return roleRepository.save(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateRole(@PathVariable Long id, @RequestBody UserRole updatedRole) {
        return roleRepository.findById(id).map(role -> {
            role.setDescription(updatedRole.getDescription());
            role.setDbName(updatedRole.getDbName());
            UserRole saved = roleRepository.save(role);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

