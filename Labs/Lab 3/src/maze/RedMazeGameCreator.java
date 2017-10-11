package maze;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RedMazeGameCreator extends MazeGameCreator
{
    public Wall makeWall()
    {
        return new RedWall();
    }
    public Room makeRoom(int id)
    {
        return new RedRoom(id);
    }

}