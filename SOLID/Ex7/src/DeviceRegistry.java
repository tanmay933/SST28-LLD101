import java.util.*;

public class DeviceRegistry {

    private final List<Object> devices = new ArrayList<>();

    public void add(Object device) {
        devices.add(device);
    }

    public <T> T getFirst(Class<T> capability) {
        for (Object d : devices) {
            if (capability.isInstance(d)) {
                return capability.cast(d);
            }
        }
        throw new IllegalStateException("Missing device for: " + capability.getSimpleName());
    }
}