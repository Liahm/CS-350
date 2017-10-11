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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import maze.ui.MazeViewer;

public static Maze createMaze(final String path) throws IOException
	{
		Maze maze = new Maze();
        if (!path.equals("default"))
        {
            maze = SimpleMazeGame.loadMaze(path);
        }
        else if(path.equals("default")) {
            Room room1 = new Room(0); //looks like this [
            Room room2 = new Room(1);// looks like this ]
            //Door leDoor = new Door(room1,room2);
            maze.addRoom(room1);
            maze.setCurrentRoom(room1);
            maze.addRoom(room2);

            room1.setSide(Direction.North, new Wall());
            room1.setSide(Direction.South, new Wall());
            room1.setSide(Direction.East, room2);
            room1.setSide(Direction.West, new Wall());

            room2.setSide(Direction.North, new Wall());
            room2.setSide(Direction.South, new Wall());
            room2.setSide(Direction.East, new Wall());
            room2.setSide(Direction.West, room1);

        }
        else if (maze.getNumberOfRooms() == 0)
        {
            System.out.println("Wow dude, trying to run a maze that doesn't exist?");
        }

		System.out.println("Displaying maze");
		return maze;
	}

public static Maze loadMaze(final String path) throws FileNotFoundException
	{
		Maze maze = new Maze();
		HashMap<Integer,String[]> roomMap = new HashMap<Integer,String[]>();
		HashMap<Integer,String[]> doorMap = new HashMap<Integer,String[]>();
		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Door> doorList = new ArrayList<Door>();
		
		// reads user file path
		Scanner in = new Scanner(new FileReader(path));
		int doorCount = 0;
		// parses each line and determines room and door count along with given params
		// adds the room/door and its specific params to a hashmap
		while(in.hasNextLine())
		{
			String line[] = in.nextLine().split(" ");
			if(line[0].equals("room"))
			{
				String sides[] = Arrays.copyOfRange(line, 2, 6);  
				roomMap.put(Integer.parseInt(line[1]), sides);
			}
			else if (line[0].equals("door"))
			{
				String rooms[] = Arrays.copyOfRange(line, 2, 4);  
				doorMap.put(doorCount, rooms);
				doorCount++;
			}
		}
		
		ArrayList<RoomSide> doorSpecList = new ArrayList<RoomSide>(); //list of door specs
		ArrayList<RoomSide> roomSpecList = new ArrayList<RoomSide>(); //list of non-wall room specs
		Direction dir[] = {Direction.North, Direction.South, Direction.East, Direction.West}; //array to hold directions
		// loop through room hashmap
		for(int i : roomMap.keySet())
		{
			//create new room
			Room newRoom = new Room(i);
			int dr = 0; //room side direction
			//get the specific room params
			for(String s : roomMap.get(i))
			{
				//if wall create new wall for that side
				if(s.equals("wall"))
				{
					newRoom.setSide(dir[dr], new Wall());
				}
				// if a door, get the door specs and add the door spec listing
				else if(s.contains("d"))
				{
					String doorNum[] = s.split("(?!^)");
					RoomSide roomD = new RoomSide(i,dir[dr], Integer.parseInt(doorNum[1]));
					doorSpecList.add(roomD);
				}
				// if not door or wall, must be another room, get room specs add to room spec listing
				else
				{
					int rm = Integer.parseInt(s);
					RoomSide roomR = new RoomSide(i, dir[dr], rm);
					roomSpecList.add(roomR);
				}
				
				dr++;
			}
			roomList.add(newRoom); //add each room to room list
		}
			
		// loop through doormap and enter rooms that have the door
		for(int i : doorMap.keySet())
		{
			int rm1 = Integer.parseInt(doorMap.get(i)[0]);
			int rm2 = Integer.parseInt(doorMap.get(i)[1]);
			Door newDoor = new Door(roomList.get(rm1), roomList.get(rm2));
			doorList.add(newDoor);			
		}
		
		// loop through door specs and add to rooms that contains the door
		for(RoomSide rs : doorSpecList)
		{
			roomList.get(rs.getRoom()).setSide(rs.getSide(), doorList.get(rs.getMapSite()));
		}
		//loop through room specs and add to rooms that have that room as a side
		for(RoomSide rs : roomSpecList)
		{
			roomList.get(rs.getRoom()).setSide(rs.getSide(), roomList.get(rs.getMapSite()));
		}
		
		// add each room to the maze
		for(Room r: roomList)
		{
			maze.addRoom(r);
		}
		// set the first room as the current room
		maze.setCurrentRoom(1);
		
		return maze;
	}
class RoomSide {
	private int room;
	private Direction side;
	private int mapsite;
	public RoomSide(int room, Direction side, int mapsite)
	{
		this.room = room;
		this.side = side;
		this.mapsite = mapsite;
	}
	
	public int getRoom() {return room;}
	public Direction getSide() {return side;}
	public int getMapSite() {return mapsite;}
}

public static void main(String[] args)
	{
        System.out.println("Add input file name");
        try
        {
            Scanner input = new Scanner(System.in);
            String path = input.nextLine();

            SimpleMazeGame myMazeGame = new SimpleMazeGame();
            Maze maze = myMazeGame.createMaze(path);
            MazeViewer viewer = new MazeViewer(maze);
            viewer.run();
        }catch(IOException e)
        {
            System.out.println("No file exists with that name, try default");
            main(args);
        }

    }