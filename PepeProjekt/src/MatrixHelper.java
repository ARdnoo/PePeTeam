public class MatrixHelper {
    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int colorCount = 0;

    public int getNormalisedValue() {
        if (colorCount == 0) return 0;

        int r = Math.round((float) this.r / colorCount);
        int g = Math.round((float) this.g / colorCount);
        int b = Math.round((float) this.b / colorCount);

        if (r < -255) r = -255;
        if (g < -255) g = -255;
        if (b < -255) b = -255;
        if (r > 0) r = 0;
        if (g > 0) g = 0;
        if (b > 0) b = 0;

        return (r << 16) + (g << 8) + b;
    }

    public int getValue() {
        return 65536 * this.r + 256 * this.g + this.b;
    }

    public void addColor(int colorValue) {
        this.r += (colorValue / 65536) % 256;
        this.g += (colorValue / 256) % 256;
        this.b += colorValue % 256;
        colorCount += 1;
    }

    public void addColor(int colorValue, int weight) {
        this.r += colorValue / 65536 * weight;
        this.g += (colorValue % 65536) / 256 * weight;
        this.b += (colorValue % 256) * weight;
        colorCount += weight;
    }
}
