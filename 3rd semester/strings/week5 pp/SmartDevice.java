import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    private String deviceName;
    private boolean isEnabled;

    private final LocalDateTime startupTime;
    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now().minusYears(1); 
        this.serialNumber = "SN-" + UUID.randomUUID().toString().substring(0, 8);
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.isEnabled = true;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public long getUptime() {
        return Duration.between(startupTime, LocalDateTime.now()).toSeconds();
    }

    public int getDeviceAge() {
        return LocalDateTime.now().getYear() - manufacturingDate.getYear();
    }

    public void setEncryptionKey(String key) {
        if (key.length() < 8) {
            throw new IllegalArgumentException("Encryption key must be at least 8 characters.");
        }
        this.hashedEncryptionKey = key.hashCode();
    }

    public void setAdminPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }
        this.hashedAdminPassword = password.hashCode();
    }

    public boolean validateEncryptionKey(String key) {
        return this.hashedEncryptionKey == key.hashCode();
    }

    public boolean validateAdminPassword(String password) {
        return this.hashedAdminPassword == password.hashCode();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String name) {
        this.deviceName = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public Map<String, String> getPropertyInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("deviceId", "Read-Only");
        info.put("manufacturingDate", "Read-Only");
        info.put("serialNumber", "Read-Only");
        info.put("uptime", "Computed Read-Only");
        info.put("deviceAge", "Computed Read-Only");
        info.put("encryptionKey", "Write-Only");
        info.put("adminPassword", "Write-Only");
        info.put("deviceName", "Read-Write");
        info.put("isEnabled", "Read-Write");
        return info;
    }

    public void resetDevice() {
        this.hashedEncryptionKey = 0;
        this.hashedAdminPassword = 0;
    }

    public static void main(String[] args) {
        SmartDevice device1 = new SmartDevice("Home Router");
        SmartDevice device2 = new SmartDevice("Office Camera");

        System.out.println("Device ID: " + device1.getDeviceId());
        System.out.println("Serial: " + device1.getSerialNumber());
        System.out.println("Manufacturing Date: " + device1.getManufacturingDate());
        System.out.println("Device Age: " + device1.getDeviceAge() + " years");
        System.out.println("Uptime: " + device1.getUptime() + " seconds");

        device1.setEncryptionKey("StrongKey123");
        device1.setAdminPassword("securePass");

        System.out.println("Encryption Key Valid: " + device1.validateEncryptionKey("StrongKey123"));
        System.out.println("Admin Password Valid: " + device1.validateAdminPassword("securePass"));

        System.out.println("Device Name: " + device1.getDeviceName());
        device1.setDeviceName("Updated Router");
        System.out.println("Updated Name: " + device1.getDeviceName());

        System.out.println("Enabled: " + device1.isEnabled());
        device1.setEnabled(false);
        System.out.println("Now Enabled: " + device1.isEnabled());

        System.out.println("\nProperty Info:");
        device1.getPropertyInfo().forEach((k, v) -> System.out.println(k + " -> " + v));

        device1.resetDevice();
        System.out.println("\nDevice reset complete.");
    }
}
