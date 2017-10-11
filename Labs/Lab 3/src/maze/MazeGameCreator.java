/*
 * SimpleMazeGame.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package maze;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.prism.impl.Disposer;
import maze.ui.MazeViewer;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public class MazeGameCreator
{
	/**
	 * Creates a small maze.
	 */
    private static Map<Room, String[]> roomSides = new HashMap<Room, String[]>();
    private static Map<String, Door> doors = new HashMap<String, Door>();
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static MazeGameCreator myMazeGame2 = new MazeGameCreator();
    //Addition from Lab 3

	public static Maze createMaze(final String path) throws IOException
	{
		Maze maze = myMazeGame2.makeMaze();
        if (!path.equals("default"))
        {
            maze = myMazeGame2.loadMaze(path);
        }
        else if(path.equals("default")) {
            Room room1 = myMazeGame2.makeRoom(0); //looks like this [
            Room room2 = myMazeGame2.makeRoom(1);// looks like this ]
            //Door leDoor = new Door(room1,room2);
            maze.addRoom(room1);
            maze.setCurrentRoom(room1);
            maze.addRoom(room2);

            room1.setSide(Direction.North, myMazeGame2.makeWall());
            room1.setSide(Direction.South, myMazeGame2.makeWall());
            room1.setSide(Direction.East, room2);
            room1.setSide(Direction.West, myMazeGame2.makeWall());

            room2.setSide(Direction.North, myMazeGame2.makeWall());
            room2.setSide(Direction.South, myMazeGame2.makeWall());
            room2.setSide(Direction.East, myMazeGame2.makeWall());
            room2.setSide(Direction.West, room1);

        }
        else if (maze.getNumberOfRooms() == 0)
        {
            System.out.println("Wow dude, trying to run a maze that doesn't exist?");
        }

		System.out.println("Displaying maze");
		return maze;
	}

    public Maze makeMaze()
    {
        return new Maze();
    }
    public Wall makeWall()
    {
        return new Wall();
    }
    public Door makeDoor(Room r1, Room r2)
    {
        return new Door(r1, r2);
    }
    public Room makeRoom(int id)
    {
        return new Room(id);
    }

	public static Maze loadMaze(final String path) throws IOException
	{
        Maze maze = myMazeGame2.makeMaze();
        File file = new File(path);
        Scanner input = new Scanner(file);

        Direction[] dirs = Direction.values();

        while (input.hasNext()) //if the file given actually has something
        {
            String first = input.next();
            if (first.equals("room")) //check first word
            {
                Room newRoom = myMazeGame2.makeRoom(input.nextInt());
                maze.setCurrentRoom(newRoom); //set position to the last room
                rooms.add(newRoom); //add room into the arraylist


                String[] sides = new String[dirs.length]; //4 sides
                for (int i=0; i < dirs.length; i ++)
                {
                    sides[i] = input.next(); //add values to the sides
                }

                roomSides.put(newRoom, sides); //create a room
            }

            else if (first.equals("door")) //check for doors
            {
                String doorSpot = input.next();
                int firstRoom = input.nextInt();
                int secondRoom = input.nextInt();
                Door newDoor = myMazeGame2.makeDoor(rooms.get(firstRoom), rooms.get(secondRoom));

                newDoor.setOpen(input.next().equals("open"));
                doors.put(doorSpot, newDoor);//create the door
            }
        }

        for (Room aRoom: rooms) //check for rooms that walk to other rooms
        {
            String[] sides = roomSides.get(aRoom);

            for (Direction dir: dirs) //for each direction
            {
                MapSite side = addStuff(sides[dir.ordinal()]); //var for either wall/door/room walk
                aRoom.setSide(dir, side); //add the direction and object
            }

            maze.addRoom(aRoom); //add the room
        }

        System.out.println("Loading maze from file: " + path);
        return maze;
    }

    //==================New Method================================
    private static MapSite addStuff(String side) //Method chooses what the current "Facing" object is.
    {
        MapSite mapSite = null;

        if (side.equals("wall"))
        {
            // Create a new Wall
            mapSite = myMazeGame2.makeWall();
        }

        // Check if the value starts with a d
        else if (side.startsWith("d"))
        {
            // map the door position
            mapSite = doors.get(side);
        }

        else //If nothing, then it has to be a room-room
        {
            mapSite = rooms.get(Integer.parseInt(side));
        }

        return mapSite;
    }
    //==================New Method================================

	public static void main(String[] args)
	{
        try
        {
            System.out.println("Select color maze");
            Scanner scan = new Scanner(System.in);
            String colorMaze = scan.nextLine();

            System.out.println("Add input file name");
            Scanner input = new Scanner(System.in);
            String path = input.nextLine();

            if(colorMaze.equals("red")) {
                myMazeGame2 = new RedMazeGameCreator();
            }
            else if(colorMaze.equals("blue")) {
                myMazeGame2 = new BlueMazeGameCreator();
            }
            else {
                myMazeGame2 = new MazeGameCreator();
            }
            Maze maze = myMazeGame2.createMaze(path);
            MazeViewer viewer = new MazeViewer(maze);
            viewer.run();
        }catch(IOException e)
        {
            System.out.println("No file exists with that name, try default");
            main(args);
        }

    }

}
