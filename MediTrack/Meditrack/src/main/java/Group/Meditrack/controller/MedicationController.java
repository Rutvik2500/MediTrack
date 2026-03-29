package Group.Meditrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Group.Meditrack.model.Medication;
import Group.Meditrack.model.User;
import Group.Meditrack.repository.MedicationRepository;
import Group.Meditrack.repository.UserRepository;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin(origins = "*")
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Medication>> getUserMedications(@PathVariable Long userId) {
        return ResponseEntity.ok(medicationRepository.findByPatientId(userId));
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addMedication(@PathVariable Long userId, @RequestBody Medication medication) {
        User patient = userRepository.findById(userId).orElse(null);
        if (patient == null) return ResponseEntity.badRequest().build();
        
        medication.setPatient(patient);
        return ResponseEntity.ok(medicationRepository.save(medication));
    }
}