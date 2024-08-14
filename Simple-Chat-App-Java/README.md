# 🗨️ Java Chat Application

Welcome to the Java Chat Application! This project is a simple chat application using Java Enterprise, allowing multiple clients to connect and chat with each other in real-time. Each client will have their name displayed alongside their messages.

## ✨ Features

- 👥 Multiple clients can join the chat.
- 📝 Clients' names are displayed when they join, chat, and leave the chat.

## 📋 Requirements

- <img src="https://skillicons.dev/icons?i=java" width="20" height="20" /> Java Development Kit (JDK) 20 or higher
- :octocat: Git

## 🛠️ Setup Instructions

Follow these steps to set up and run the chat application.

### 1. Clone the Repository

```sh
git clone https://github.com/GiridharanS1729/Chat-App-Java
cd Chat-App-Java
```

### 2. Compile the Code

- Compile the Server
   Open a terminal, navigate to the project directory, and compile the server code:
```sh
cd server
javac ChatServer.java
```

- Compile the Client
   Open a new terminal, navigate to the project directory, and compile the client code:

```sh
cd client
javac ChatClient.java
```

### 3. Run the Application
- Run the Server
In the terminal where you compiled the server, run the following command to start the server:

```sh
java ChatServer
```
You should see the message: Chat server started...

- Run the Clients
Open new terminals for each client, navigate to the client directory, and run the following command to start each client:

```sh
java ChatClient
```
You will be prompted to enter your name:

```sh
Enter your name: Your_Name
```
Repeat this step for multiple clients with different names.

### 4. Chatting
Once clients are connected, they can start chatting with each other. Messages from each client will be displayed with their respective names.

### 5. Exit the Chat
To exit the chat, type exit in the client terminal and press Enter ***or*** press ctrl/cmd+C .

## 📁 Project Structure
<pre>
Chat-App-Java/
├── server/
│   ├── ChatServer.java
├── client/
│   ├── ChatClient.java
├── LICENCE
└── README.md
</pre>
## 📜 License
This project is licensed under the MIT License. See the LICENSE file for more details.

## 📞 Contact
For any questions or suggestions, please contact:

Name: Giridharan S<br/>
Email: giridharans@gmail.com<br/>
GitHub: GiridharanS1729

🎉 Enjoy Chatting!
Feel free to explore and enhance the application. Happy chatting! 🚀
