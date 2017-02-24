
# Planning

## Overview
This is a software package for visually and interactively exploring AI algorithms. At the very least, part of the software will be responsible for running a "game" like tick-tack-toe or Pacman. This will be shown to the user with a GUI or an HTML window. 

## Running the Game
An efficient backend will be responsible for asking the different players for their moves and correctly changing the world state according to those moves.

1. The agents are prompted for an action. This is done by sending each agent a gamestate and list of legal actions. The agent has to return one of these actions or one will be randomly selected.
2. The choices are carried out (the gamestate is changed according to what they decided.)
3. The gamestate and all the choices are logged.

## Actors Planning
There are a few tasks related to the entities themselves:
1. When an entity takes a certain action, the consequences need to be carried out. For example, if a hamster walks into lava, it should die.
2. The actor needs to calculate a full list of allowed moves.
3. When prompted for an action, the full gamestate needs to be converted to some minimal 
4. The actor needs to be told of the outcome of its own action so that it can learn from it.

### Actor Design
The overall containing will be the entity class. These are subclasses of `Entity` and, like `World`, will always be running server-side. The `Entity` classes, along with `World`, are responsible for carrying out changes from actions. For example, if a hamster decides to move forward, the `Entity` class is responsible for communicating with the `World` and `Grid` objects to actually move the hamster. The `Hamster` class might be responsible for making the hamster slightly hungrier each turn. These classes are also responsible for making legal moves.

The `Entity` subclasses will have an instance variable of type `Brain`, which is responsible for choosing their actions.

This distinction between `Entity` and `Brain` helps us separate concerns about the game model (the particular rules of this game, how hamsters work, etc.) from the decision making algorithms which might be more general. This also lets us have a literal physical separation between running the game and deciding actions. For example, the code to make hamsters slightly hungrier every turn and to grow grass every 5 turns can run on the server. 

We can have one of the `Hamster` objects' `brain` decide its action by communicating with another server. In the same vein, we could control an entity by swapping its `brain` with one that gets its instructions from the user.  
This distinction also makes it harder for an agent to cheat, since the code that they have control over (`Brain`) can be separated from the code that enforces rules (`World` and `Entity`).

* `Entity`
    * `Brain`
        * Given list of actions and game state representation, chooses an action.
    * `Sensor` : Generates a state representation for `Brain` using the `World` instance. 
    * `Predictor` : Handles predictions about future states given current actions.
# Visualization Planning
Need to map gamestate => sprite representations.

### Stored values
* `type` : what class of objects does this belong to? Is it a tree? is it a person? This is used to identify its sprite.
* `uid` : unique `String` (or maybe just make it easy and use `int`) to identify each sprite. This should stay constant between render calls for an object in order to skip some re-renderings and track for animation. For example, if we know that `cat1` is 
* `renderLevel` : Ground is 0 (first to be rendered) while clouds would be 3 (third to be rendered.)
* `location` : The `x`, `y` position of the object. It's probably going to be tile-based so these will be integer based.
* `movementIndex` : This will be a looping number used for animations. It won't be implemented until later. 

### Display Turn
1. We will start with the "facts" : the gamestate. For the Java client, this will just be access to a Game or World object. For HTML versions later on, it'll be based on some JSON representation of the gamestate with updates sent by the server every turn.
2. From the gamestate, we will get a list of entities that need drawing from the gamestate. This will include a `uid` and all the other important information listed above (except `movementIndex`, which the frontend client can store all by itself.) The animation stuff will be taken care of at this stage too.
3. We will convert this list of information into objects to draw. In the case of the Java client, we will turn them into sprites with the correct positions.
4. We will partition/sort these based on `renderLevel`.
5. We will then draw the actual textures. For the Java client, this means making the correct texture / spritebatch.

### Gamestate / Frontend Conversion
The conversion of the gamestate to sprites and ultimately a drawn image is completely dependent on the particular implementations of the `World` / `Gamestate` object and how it represents state. For example, assume we are making a maze game or pacman. How do we store the walls in our game state? The easiest way is probably to store each wall tile separately as its own entity, each with a clear location and type. But we might try to be more effecient. Say we have a 100x100 maze game with 50% of the board being walls. This means 5000 entities. Assuming each entity is 2 bytes (`x` and `y`) this means about 10kB memory.

Maybe we can be smarter and go up one level of abstraction and store it as one entity, `WallMesh`, which stores the wall information more effeciently. Assume in this `WallMesh`, we store the wall info as a boolean vector for each tile that is `true` iff that tile is a wall. This takes (100x100) bits = 1.25kB which is more effecient. If this were instead a 200x200 maze, the difference would be 40kB and 5kB. The difference is interesting, but probably not enough to go through the trouble of encoding this boolean vector into some king of byte buffer. 

### Drawing Delegation
As noted, on the frontend, each entity received from the backend will be converted to an entity on the frontend. In the Java client, it'll be something like `TreeVisual` if the backend entity is called `Tree`. When it comes time to actually create / draw the sprites, these objects (`xxxVisual`) will be responsible for taking the information they have (`location`, `movementIndex`, `health`) and creating an actual `Sprite` or whatever is needed to be drawn.