/*
 * Created by Rasoul Miri on 2/3/17 9:04 PM.
 */

package io.rmiri.gpuoverdraw;


public class Watch {
    private String brand;
    private String color;
    private int thumbnail;

    public Watch() {
    }

    public Watch(String brand, String color, int thumbnail) {
        this.brand = brand;
        this.color = color;
        this.thumbnail = thumbnail;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
