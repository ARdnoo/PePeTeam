public class matrixHelper {
    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int colorCount = 0;

    public int getNormalisedValue() {
        if (colorCount == 0) return 0;
        if (this.colorCount != 9) System.out.println("ERROR FR");
        return 65536 * Math.round((float) this.r / colorCount) + 256 * Math.round((float) this.g / colorCount) + Math.round((float) this.b / colorCount);
    }

    public int getValue() {
        return 65536 * this.r + 256 * this.g + this.b;
    }

    public void addColor(int colorValue) {
        this.r += colorValue / 65536;
        this.g += (colorValue % 65536) / 256;
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
