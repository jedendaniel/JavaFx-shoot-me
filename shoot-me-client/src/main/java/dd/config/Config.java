package dd.config;

public class Config {
    private static Config instance = new Config();

    private int screenWidth = 1024;
    private int screenHeight = 760;
    private int frameSpeedRate = 150 * 100000;
    private int highSpeedRate = 100000;

    private Config() {}

    public static Config getInstance() {
        return instance;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getFrameSpeedRate() {
        return frameSpeedRate;
    }

    public void setFrameSpeedRate(int frameSpeedRate) {
        this.frameSpeedRate = frameSpeedRate;
    }

    public int getHighSpeedRate() {
        return highSpeedRate;
    }

    public void setHighSpeedRate(int highSpeedRate) {
        this.highSpeedRate = highSpeedRate;
    }
}
