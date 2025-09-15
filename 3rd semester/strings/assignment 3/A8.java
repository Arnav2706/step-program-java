class Patient {
    String patientId;
    String patientName;
    int age;
    String gender;
    String contactInfo;
    String[] medicalHistory = new String[10];
    String[] currentTreatments = new String[10];
    int mhIdx = 0;
    int ctIdx = 0;

    Patient(String id, String name, int ageVal, String gen, String contact) {
        patientId = id;
        patientName = name;
        age = ageVal;
        gender = gen;
        contactInfo = contact;
    }

    void addHistory(String h) { if (mhIdx < medicalHistory.length) medicalHistory[mhIdx++] = h; }
    void addTreatment(String t) { if (ctIdx < currentTreatments.length) currentTreatments[ctIdx++] = t; }
}

class Doctor {
    String doctorId;
    String doctorName;
    String specialization;
    String[] availableSlots = new String[10];
    int slotsIdx = 0;
    int patientsHandled;
    double consultationFee;

    Doctor(String id, String name, String spec, double fee) {
        doctorId = id;
        doctorName = name;
        specialization = spec;
        consultationFee = fee;
    }

    void addSlot(String s) { if (slotsIdx < availableSlots.length) availableSlots[slotsIdx++] = s; }
}

class Appointment {
    String appointmentId;
    Patient patient;
    Doctor doctor;
    String appointmentDate;
    String appointmentTime;
    String status;

    Appointment(String id, Patient p, Doctor d, String date, String time) {
        appointmentId = id;
        patient = p;
        doctor = d;
        appointmentDate = date;
        appointmentTime = time;
        status = "Scheduled";
    }
}

class Hospital {
    Patient[] patients;
    Doctor[] doctors;
    Appointment[] appointments;
    static int totalPatients = 0;
    static int totalAppointments = 0;
    static String hospitalName = "Care Hospital";
    static double totalRevenue = 0;

    Hospital(int pcap, int dcap, int acap) {
        patients = new Patient[pcap];
        doctors = new Doctor[dcap];
        appointments = new Appointment[acap];
    }

    void addPatient(Patient p) {
        for (int i = 0; i < patients.length; i++) if (patients[i] == null) { patients[i] = p; totalPatients++; break; }
    }

    void addDoctor(Doctor d) {
        for (int i = 0; i < doctors.length; i++) if (doctors[i] == null) { doctors[i] = d; break; }
    }

    Appointment scheduleAppointment(String pid, String did, String date, String time) {
        Patient p = null;
        Doctor d = null;
        for (Patient x : patients) if (x != null && x.patientId.equals(pid)) p = x;
        for (Doctor x : doctors) if (x != null && x.doctorId.equals(did)) d = x;
        if (p == null || d == null) return null;
        Appointment a = new Appointment("A" + System.nanoTime()%100000, p, d, date, time);
        for (int i = 0; i < appointments.length; i++) if (appointments[i] == null) { appointments[i] = a; totalAppointments++; totalRevenue += d.consultationFee; break; }
        return a;
    }

    boolean cancelAppointment(String appointmentId) {
        for (int i = 0; i < appointments.length; i++) if (appointments[i] != null && appointments[i].appointmentId.equals(appointmentId)) { totalRevenue -= appointments[i].doctor.consultationFee; appointments[i] = null; totalAppointments--; return true; }
        return false;
    }

    double generateBill(Appointment a, double treatmentCost) {
        double bill = a.doctor.consultationFee + treatmentCost;
        totalRevenue += treatmentCost;
        return bill;
    }

    static void generateHospitalReport(Hospital h) {
        System.out.println(hospitalName + " Patients:" + totalPatients + " Appointments:" + totalAppointments + " Revenue:" + totalRevenue);
    }

    static double getDoctorUtilization(Hospital h, String doctorId) {
        int total = 0;
        for (Appointment a : h.appointments) if (a != null && a.doctor.doctorId.equals(doctorId)) total++;
        return total;
    }
}

public class A8 {
    public static void main(String[] args) {
        Hospital hosp = new Hospital(10, 5, 20);
        Patient p1 = new Patient("P1", "Naina", 30, "F", "98765");
        Patient p2 = new Patient("P2", "Vikram", 45, "M", "87654");
        Doctor d1 = new Doctor("D1", "Dr. Sen", "Cardiology", 1500);
        Doctor d2 = new Doctor("D2", "Dr. Roy", "Orthopedics", 1200);
        hosp.addPatient(p1);
        hosp.addPatient(p2);
        hosp.addDoctor(d1);
        hosp.addDoctor(d2);
        Appointment a1 = hosp.scheduleAppointment("P1", "D1", "2025-09-10", "10:00");
        Appointment a2 = hosp.scheduleAppointment("P2", "D2", "2025-09-11", "11:00");
        double bill = hosp.generateBill(a1, 2000);
        System.out.println("Bill for " + a1.appointmentId + " = " + bill);
        Hospital.generateHospitalReport(hosp);
    }
}
