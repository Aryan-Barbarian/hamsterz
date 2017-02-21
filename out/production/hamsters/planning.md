
# Planning

## Overview
This is a software package for visually and interactively exploring AI algorithms. At the very least, part of the software will be responsible for running a "game" like tick-tack-toe or Pacman. This will be shown to the user with a GUI or an HTML window. 

## Running the Game
An efficient backend will be responsible for asking the different players for their moves and correctly changing the world state according to those moves. 

### There are four stages:
1. Send the full game state to each agent (or just the part of the game board relevant to the agent.) This will also send a copy of the gamestate to the parts of the package responsible for displaying.
2. Receive the move from each agent. Note that this might happen simultaneously for all agents or they'll be forced to wait for their turn. Also, this interaction can be done in two ways:
    1. The agent code runs as another class in the backend. The backend simply calls a `getAction` method or something similar. This is the fastest version.
    2. A server/client relationship. The backend will be a server and the client will be an HTML webpage with a lot of JS code. The Javascript and Java will communicate with each other on some socket.
3. Change the game state according to what the agent(s) did.
4. Log the previous gamestate, action(s), and the resulting gamestate. 
    1. I'll need to come up with a good way of representing the game state and actions. We'll represent the game state as JSON and serialize the world state to/from this format. 
    2. Later, we can save space by storing an initial version of the gamestate and then only storing changes to it. 

#### Local Example
1. Local Pacman client calls `getAction(GameState gs)` on `pacmanAgent`. The `gs` tells the pacman, walls, and ghosts are. 
    * It also calls `getAction(gs)` on all the other agents, in this case the ghosts. 
2. The `pacmanAgent` reads whatever it needs from the `gs` and sends back its action. For example, it could send `moveForward`.
3. The local pacman client interprets all the moves. If the ghost said "goLeft" the ghost will be shifted left by one tile. If pacman and a ghost collide, pacman will lose (unless he had also just eaten a cherry.)
4. The local pacman client will log the current gamestate as a JSON file. If written with java, the `gs` needs to be JSONSerializable.
5. The local pacman client will also display the gamestate + any auxilary info (what everyone decided, point gain, etc.)

#### Remote Example
This is when the component that interprets moves and logs actions runs on a remote server, but one or more of the agents runs on a different server.