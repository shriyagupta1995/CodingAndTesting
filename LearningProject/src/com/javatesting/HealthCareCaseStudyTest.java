package com.javatesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class HealthCareCaseStudyTest {

	@Test
	public void testAddPatientAndRetrieve() {
		EHRSystem ehr = new EHRSystem();
		Patient p = new Patient("P001", "Alice", 30);
		ehr.addPatient(p);

		Patient retrieved = ehr.getPatient("P001");
		assertNotNull(retrieved);
		assertEquals("Shriya", retrieved.getName());
		assertEquals(31, retrieved.getAge());
	}

	@Test
	void testDiagnosisAndPrescription() {
		Patient p = new Patient("P002", "Bob", 45);
		Doctor d = new Doctor("Smith", "Cardiology");

		d.diagnose(p, "High blood pressure");
		d.prescribe(p, "Amlodipine 5mg daily");

		List<String> history = p.getMedicalHistory();
		assertEquals(2, history.size());
		assertTrue(history.get(0).contains("Diagnosis"));
		assertTrue(history.get(1).contains("Prescription"));
	}

	@Test
	void testGetPatientHistory() {
		EHRSystem ehr = new EHRSystem();
		Patient p = new Patient("P003", "Charlie", 50);
		Doctor d = new Doctor("Johnson", "General Medicine");

		ehr.addPatient(p);
		d.diagnose(p, "Diabetes Type 2");
		d.prescribe(p, "Metformin 500mg");

		List<String> history = ehr.getPatientHistory("P003");
		assertEquals(2, history.size());
		assertTrue(history.get(0).contains("Diabetes"));
		assertTrue(history.get(1).contains("Metformin"));
	}

	@Test
	void testInvalidPatientHistory() {
		EHRSystem ehr = new EHRSystem();
		List<String> history = ehr.getPatientHistory("InvalidID");
		assertTrue(history.isEmpty());
	}

}

class Patient {
	private String id;
	private String name;
	private int age;
	private List<String> medicalHistory;

	public Patient(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.medicalHistory = new ArrayList<>();
	}

	public String getId() { return id; }
	public String getName() { return name; }
	public int getAge() { return age; }

	public void addRecord(String record) {
		medicalHistory.add(record);
	}

	public List<String> getMedicalHistory() {
		return medicalHistory;
	}
}

class Doctor {
	private String name;
	private String specialization;

	public Doctor(String name, String specialization) {
		this.name = name;
		this.specialization = specialization;
	}

	public void diagnose(Patient patient, String diagnosis) {
		patient.addRecord("Diagnosis by Dr. " + name + ": " + diagnosis);
	}

	public void prescribe(Patient patient, String prescription) {
		patient.addRecord("Prescription by Dr. " + name + ": " + prescription);
	}
}

class EHRSystem {
	private Map<String, Patient> patients = new HashMap<>();

	public void addPatient(Patient patient) {
		patients.put(patient.getId(), patient);
	}

	public Patient getPatient(String id) {
		return patients.get(id);
	}

	public List<String> getPatientHistory(String id) {
		Patient p = patients.get(id);
		return (p != null) ? p.getMedicalHistory() : Collections.emptyList();
	}
}