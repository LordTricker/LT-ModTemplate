package pl.lordtricker.modid.client.config;

public class ModSettings {

    public static boolean attackDelayTutorEnabled = false;
    public static boolean attackDelayTutorSoundEnabled = true;
    public static boolean attackDelayTutorTextEnabled = true;

    public static void save() {
        Config cfg = toConfig();
        ConfigLoader.saveConfig(cfg);
        System.out.println("[ModSettings] Saved -> modid-config.json");
    }

    public static void load() {
        Config cfg = ConfigLoader.loadConfig();
        applyFrom(cfg);
        System.out.println("[ModSettings] Loaded <- modid-config.json");
    }

    public static Config toConfig() {
        Config cfg = new Config();
        cfg.attackDelayTutorEnabled = attackDelayTutorEnabled;
        cfg.attackDelayTutorSoundEnabled = attackDelayTutorSoundEnabled;
        cfg.attackDelayTutorTextEnabled = attackDelayTutorTextEnabled;
        return cfg;
    }

    public static void applyFrom(Config cfg) {
        attackDelayTutorEnabled = cfg.attackDelayTutorEnabled;
        attackDelayTutorSoundEnabled = cfg.attackDelayTutorSoundEnabled;
        attackDelayTutorTextEnabled = cfg.attackDelayTutorTextEnabled;
    }
}
