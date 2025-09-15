import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies,
                         String[] medicalHistory, LocalDate birthDate, String bloodType) {
        if (recordId == null || patientDNA == null || birthDate == null || bloodType == null) {
            throw new IllegalArgumentException("Required medical data missing");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies == null ? new String[0] : allergies.clone();
        this.medicalHistory = medicalHistory == null ? new String[0] : medicalHistory.clone();
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String a : allergies) if (a.equalsIgnoreCase(substance)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + recordId + ", bloodType=" + bloodType + "}";
    }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;

    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    Patient(String patientId, MedicalRecord medicalRecord, String currentName, String emergencyContact,
            String insuranceInfo, int roomNumber, String attendingPhysician) {
        if (patientId == null || medicalRecord == null) throw new IllegalArgumentException("Missing");
        this.patientId = patientId;
        this.medicalRecord = medicalRecord;
        this.currentName = currentName;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = attendingPhysician;
    }

    // emergency admission constructor (temporary id)
    public Patient(String currentName) {
        this("TMP-" + UUID.randomUUID().toString().substring(0,6),
             new MedicalRecord("MR-" + UUID.randomUUID().toString().substring(0,6), "N/A",
                     null, null, LocalDate.now().minusYears(30), "O+"),
             currentName, null, null, -1, null);
    }

    public String getPatientId() { return patientId; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }

    // package-private basic info for staff (same package)
    String getBasicInfo() {
        return patientId + "|" + currentName + "|room:" + roomNumber;
    }

    public String getPublicInfo() {
        return "Name: " + currentName + " | Room: " + (roomNumber >= 0 ? roomNumber : "TBD");
    }

    public String getCurrentName() { return currentName; }
    public void setCurrentName(String currentName) { this.currentName = currentName; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getInsuranceInfo() { return insuranceInfo; }
    public void setInsuranceInfo(String insuranceInfo) { this.insuranceInfo = insuranceInfo; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public String getAttendingPhysician() { return attendingPhysician; }
    public void setAttendingPhysician(String attendingPhysician) { this.attendingPhysician = attendingPhysician; }

    @Override
    public String toString() {
        return "Patient{" + patientId + ", name=" + currentName + "}";
    }
}

class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certifications) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = certifications == null ? Collections.emptySet() : new HashSet<>(certifications);
    }

    public String getLicenseNumber() { return licenseNumber; }
    public String getSpecialty() { return specialty; }
    public boolean canAccessSensitive() { return true; } // doctors have extended access
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = qualifications == null ? Collections.emptyList() : new ArrayList<>(qualifications);
    }

    public boolean canAccessSensitive() { return false; } // limited access
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String adminId, List<String> accessPermissions) {
        this.adminId = adminId;
        this.accessPermissions = accessPermissions == null ? Collections.emptyList() : new ArrayList<>(accessPermissions);
    }

    public boolean hasPermission(String perm) {
        return accessPermissions.contains(perm);
    }
}

public class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();
    private static final String HIPAA_POLICY = "HIPAA-STRICT";

    public boolean admitPatient(Object patientObj, Object staff) {
        if (!(patientObj instanceof Patient)) return false;
        Patient patient = (Patient) patientObj;
        if (!validateStaffAccess(staff, patient)) return false;
        patientRegistry.put(patient.getPatientId(), patient);
        return true;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        if (staff instanceof Doctor) return true;
        if (staff instanceof Nurse) return true; // can be refined per operation
        if (staff instanceof Administrator) {
            Administrator a = (Administrator) staff;
            return a.hasPermission("ADMIT");
        }
        return false;
    }

    Map<String, Object> getInternalRegistry() { return new HashMap<>(patientRegistry); }

    public static void main(String[] args) {
        HospitalSystem hs = new HospitalSystem();

        MedicalRecord mr = new MedicalRecord("MR100", "DNA-SEQ-123",
                new String[]{"Peanut"}, new String[]{"Asthma"}, LocalDate.of(1985,1,1), "A+");

        Patient p = new Patient("PT100", mr, "John Doe", "Jane-555", "INS-123", 101, "Dr. Smith");
        Doctor doc = new Doctor("LIC-789", "Cardiology", Set.of("ACLS"));
        Nurse nurse = new Nurse("N-01", "Day", List.of("RN"));

        System.out.println("Admit by doctor: " + hs.admitPatient(p, doc));
        System.out.println("Admit by admin without permission: " + hs.admitPatient(p, new Administrator("ADM", List.of())));

        System.out.println("Patient public info: " + p.getPublicInfo());
        System.out.println("Patient basic info (staff): " + p.getBasicInfo());
        System.out.println("Is allergic to Peanut? " + mr.isAllergicTo("Peanut"));
    }
}
