
# GitHub Proxy Tool

This is a simple Java-based proxy tool that allows you to access GitHub-hosted files through your own domain. By using this tool, you can bypass certain network restrictions and download GitHub files easily.

## Features

- Proxy access to GitHub-hosted files.
- Easily download files by providing a GitHub file URL through your website.
- Supports URLs like `http://your_server/https://github.com/test/aa.ini` to download `https://github.com/test/aa.ini`.

## How It Works

The tool allows you to proxy a file hosted on GitHub by rewriting the URL through your custom domain. When you provide a GitHub URL in the format below, the tool fetches the file and serves it via your website.

For example:
- Input: `https://mywebsite/https://github.com/test/aa.ini`
- Output: The content of the file `https://github.com/test/aa.ini` will be served by your website.

## Prerequisites

- Java Development Kit (JDK 8 or higher)
- A server to host your Java application

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo-name/your-project-name.git
   ```

2. Navigate to the project directory:
   ```bash
   cd your-project-name
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   java -jar target/your-project-name.jar
   ```

## Usage

Once the application is running, you can start using it by simply providing a URL in the following format:

```
https://mywebsite/https://github.com/{username}/{repository}/{file}
```

### Example:

To download `aa.ini` from a GitHub repository, use the following URL:

```
https://mywebsite/https://github.com/test/aa.ini
```

## Configuration

You can configure the server port, base URL, and other settings in the `application.properties` file. Update the properties according to your environment:

```properties
server.port=8080
proxy.github.url=https://github.com/
```

## Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue to discuss improvements, bug fixes, or new features.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
