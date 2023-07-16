package mp4.bag;

import mp1.Methods;

import java.time.LocalDate;

public class Regimen implements Methods {
    private String protocolName;
    private Patient patient;

    private LocalDate startDate;
    private Hospital hospital;

    public Regimen(String protocolName, Patient patient, LocalDate startDate, Hospital hospital) throws Exception {
        checkString(protocolName);
        checkIfNotNull(patient);
        checkLocalDate(startDate);
        checkIfNotNull(hospital);


        this.protocolName = protocolName; //set
        this.startDate = startDate; // set


        this.patient = patient;
        patient.addRegiment(this);

        this.hospital = hospital;
        hospital.addRegimen(this);
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) throws Exception {
        checkString(protocolName);
        this.protocolName = protocolName;
    }

    public Patient getPatient() {
        return patient;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) throws Exception {
        checkLocalDate(startDate);
        this.startDate = startDate;
    }

    public Hospital getHospital() {
        return hospital;
    }

}
