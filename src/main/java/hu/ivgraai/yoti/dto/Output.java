package hu.ivgraai.yoti.dto;

import java.io.Serializable;

/**
 * @author Gergo Ivan
 */
public class Output implements Serializable {

    private Location coords;
    private int patches;

    public Output(Location coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public Location getCoords() {
        return coords;
    }

    public Output setCoords(Location coords) {
        this.coords = coords;
        return this;
    }

    public int getPatches() {
        return patches;
    }

    public Output setPatches(int patches) {
        this.patches = patches;
        return this;
    }

    @Override
    public String toString() {
        return "Output{" + "coords=" + coords + ", patches=" + patches + '}';
    }

}
