package Group.Meditrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Group.Meditrack.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByPatientId(Long patientId);
}