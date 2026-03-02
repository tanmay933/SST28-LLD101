public class LightsPanel implements PowerControllable, BrightnessControllable {

    @Override
    public void powerOn() {
        // isliye always on
    }

    @Override
    public void powerOff() {
        System.out.println("Lights OFF");
    }

    @Override
    public void setBrightness(int pct) {
        System.out.println("Lights set to " + pct + "%");
    }
}