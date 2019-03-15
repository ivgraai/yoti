package hu.ivgraai.yoti.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Size;

/**
 * @author Gergo Ivan
 */
public class Input implements Serializable {

    @Size(min = 2, max = 2) private Location roomSize;
    @Size(min = 2, max = 2) private Location coords;
    private List<@Size(min = 2, max = 2) Location> patches;
    private String instructions;

    public Input() {
        // empty method
    }

    public Input(Location roomSize, Location coords, List<Location> patches, String instructions) {
        this.roomSize = roomSize;
        this.coords = coords;
        this.patches = patches;
        this.instructions = instructions;
    }

    public Location getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Location roomSize) {
        this.roomSize = roomSize;
    }

    public Location getCoords() {
        return coords;
    }

    public void setCoords(Location coords) {
        this.coords = coords;
    }

    public List<Location> getPatches() {
        return patches;
    }

    public void setPatches(List<Location> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.roomSize);
        hash = 59 * hash + Objects.hashCode(this.coords);
        hash = 59 * hash + Objects.hashCode(this.patches);
        hash = 59 * hash + Objects.hashCode(this.instructions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Input other = (Input) obj;
        return (
                Objects.equals(this.instructions, other.instructions) &&
                Objects.equals(this.roomSize, other.roomSize) &&
                Objects.equals(this.coords, other.coords) &&
                Objects.equals(this.patches, other.patches)
            );
    }

    @Override
    public String toString() {
        return "Input{" + "roomSize=" + roomSize + ", coords=" + coords + ", patches=" + patches + ", instructions=" + instructions + '}';
    }

}
