# Client-Server Project with Spotify API

This is my Java client-server project that interacts with the Spotify API.

## Description

This project includes a client that connects to the Spotify API to perform various operations and a server that handles client requests. The project is structured as follows:

- `src/main/java/es/ulpgc/client`: Contains the main client logic, including classes for interoperability with Spotify, utilities, and serialization.
- `src/main/java/es/ulpgc/client/server`: Contains the server logic.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── es/
│   │       └── ulpgc/
│   │           └── client/
│   │               ├── cqrs/
│   │               ├── interoperability/
│   │               ├── serialization/
│   │               ├── server/
│   │               ├── util/
│   │               └── Main.java
│   └── resources/
└── test/
```

## Requirements

- Java 11 or later

## Setup

1. Clone the repository to your local machine:
    ```sh
    git clone https://github.com/your-username/your-repository.git
    ```
2. Navigate to the project directory:
    ```sh
    cd your-repository
    ```
3. Compile the project using Maven or Gradle (depending on your setup):
    ```sh
    mvn clean install
    ```
4. Configure your Spotify API credentials in the corresponding configuration file:
    ```properties
    # Configuration file (e.g., src/main/resources/application.properties)
    spotify.clientId=YOUR_CLIENT_ID
    spotify.clientSecret=YOUR_CLIENT_SECRET
    ```

## Usage

To run the client and server, use the following command:

```sh
java -cp target/your-project.jar es.ulpgc.client.Main
```

## Contribution

If you'd like to contribute to this project, follow these steps:

1. Fork the repository.  
2. Create a new branch:  
   ```sh
   git checkout -b feature/new-feature
   ```
3. Make your changes and commit them:  
   ```sh
   git commit -am 'Add new feature'
   ```
4. Push your changes:  
   ```sh
   git push origin feature/new-feature
   ```
5. Open a Pull Request.

## License

This project is licensed under the MIT License – see the LICENSE file for more details.

## Contact

If you have any questions or suggestions, feel free to contact me at **victormedina2157@gmail.com** or open an issue on GitHub.

Thanks for checking out my project!
