# WebSocket Pong 
Pong Game using Java WebSockets

Static content is served with Apache Tomcat HTTP Server. Any client on the network can access the static content (JavaScript, HTML, CSS) and play the game by sending key-presses to the Socket Server in order to move the paddles. Server sends key-press response to all clients which allows players to join the fun from multiple machines on the network!

We can access the game on mobile. I'm currently working on adding UI to move paddles from a mobile device on the same. Right now we can open the game window on a mobile device's web browser and send key-presses from a computer, we'll see live updates of the paddle's position on the mobile device. 


![WebSocket Pong Game](https://github.com/idkburkes/WebSocket-Pong/blob/master/resources/WebsocketPong.gif)