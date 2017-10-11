package maze;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlueMazeGameCreator extends MazeGameCreator {

	public Wall makeWall() {
		return new BlueWall();
	}

	public Door makeDoor(Room r1, Room r2) {
		return new BrownDoor(r1, r2);
	}

	public Room makeRoom(int id) {
		return new GreenRoom(id);
	}
}