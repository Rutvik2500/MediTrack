package Group.Meditrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Group.Meditrack.model.User;
import Group.Meditrack.repository.UserRepository;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/patients")
    public ResponseEntity<List<User>> getAllPatients() {
        // This asks the database for everyone with the PATIENT role
        List<User> patients = userRepository.findByRole("PATIENT");
        return ResponseEntity.ok(patients);
    }
}