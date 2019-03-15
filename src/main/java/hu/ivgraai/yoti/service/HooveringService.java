package hu.ivgraai.yoti.service;

import hu.ivgraai.yoti.dto.Input;
import hu.ivgraai.yoti.dto.Location;
import hu.ivgraai.yoti.dto.Output;
import hu.ivgraai.yoti.logic.Model;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Gergo Ivan
 */
@Service
@Scope("prototype")
public class HooveringService {

    private static final char CARDINAL_DIRECTION_NORTH =    'N';
    private static final char CARDINAL_DIRECTION_SOUTH =    'S';
    private static final char CARDINAL_DIRECTION_WEST =     'W';
    private static final char CARDINAL_DIRECTION_EAST =     'E';

    public Output navigate(Input input) {
        Model m = new Model(input.getRoomSize().get(0), input.getRoomSize().get(1));
        input.getPatches()
                .stream()
                .forEach(patch -> m.setPatch(patch.get(0), patch.get(1)));
        m.initialize(input.getCoords().get(0), input.getCoords().get(1));
        for (int i = 0; i < input.getInstructions().length(); ++i) {
            char instruction = input.getInstructions().charAt(i);
            switch (instruction) {
                case CARDINAL_DIRECTION_NORTH:
                    m.moveNorth();
                    break;
                case CARDINAL_DIRECTION_SOUTH:
                    m.moveSouth();
                    break;
                case CARDINAL_DIRECTION_WEST:
                    m.moveWest();
                    break;
                case CARDINAL_DIRECTION_EAST:
                    m.moveEast();
                    break;
                default:
            }
        }
        Location result = new Location();
        result.add(m.getCurrentX());
        result.add(m.getCurrentY());
        return new Output(result, m.cleanedPatches());
    }

}
