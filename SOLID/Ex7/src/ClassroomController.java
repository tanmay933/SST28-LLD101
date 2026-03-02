public class ClassroomController {

    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {

        PowerControllable pjPower = reg.getFirst(PowerControllable.class);
        InputConnectable pjInput = reg.getFirst(InputConnectable.class);

        pjPower.powerOn();
        pjInput.connectInput("HDMI-1");

        BrightnessControllable lights = reg.getFirst(BrightnessControllable.class);
        lights.setBrightness(60);

        TemperatureControllable ac = reg.getFirst(TemperatureControllable.class);
        ac.setTemperatureC(24);

        AttendanceScannable scanner = reg.getFirst(AttendanceScannable.class);
        System.out.println("Attendance scanned: present=" + scanner.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");

        reg.getFirst(PowerControllable.class).powerOff(); // Projector
        reg.getFirst(BrightnessControllable.class); // ensures lights exist
        reg.getFirst(TemperatureControllable.class); // ensures AC exists

        reg.getFirst(Projector.class).powerOff();
        reg.getFirst(LightsPanel.class).powerOff();
        reg.getFirst(AirConditioner.class).powerOff();
    }
}