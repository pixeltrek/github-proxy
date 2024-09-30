
# GitHub 代理工具

这是一个基于 Java 的简单代理工具，允许你通过自定义域名访问托管在 GitHub 上的文件。使用此工具，你可以绕过某些网络限制，轻松下载 GitHub 文件。

## 功能

- 代理访问托管在 GitHub 上的文件。
- 通过提供 GitHub 文件 URL，轻松通过你的网站下载文件。
- 支持类似 `https://你的ip/https://github.com/test/example.ini` 的 URL 来下载 `https://github.com/test/example.ini`。

## 工作原理

该工具允许你通过自定义域名代理 GitHub 上托管的文件。当你按照以下格式提供 GitHub URL 时，工具会获取该文件并通过你的网站提供。

例如：
- 输入：`https://mywebsite/https://github.com/test/aa.ini`
- 输出：`https://github.com/test/aa.ini` 的内容。

## 前提条件

- Java 开发工具包（JDK 8 或更高版本）
- 一台用于托管 Java 应用的服务器

## 安装

1. 克隆仓库：
   ```bash
   git clone https://github.com/your-repo-name/your-project-name.git
   ```

2. 进入项目目录：
   ```bash
   cd your-project-name
   ```

3. 构建项目：
   ```bash
   mvn clean install
   ```

4. 运行应用程序：
   ```bash
   java -jar target/your-project-name.jar
   ```

## 使用方法

应用程序启动后，你可以通过提供以下格式的 URL 开始使用：

```
https://mywebsite/https://github.com/{username}/{repository}/{file}
```

### 示例：

要从 GitHub 仓库下载 `aa.ini` 文件，可以使用以下 URL：

```
https://mywebsite/https://github.com/test/aa.ini
```

## 配置

你可以在 `application.properties` 文件中配置服务器端口、基本 URL 及其他设置。根据你的环境更新以下属性：

```properties
server.port=8080
proxy.github.url=https://github.com/
```

## 贡献

欢迎贡献代码！如果你有改进建议、Bug 修复或新功能，可以随时提交 Pull Request 或打开 Issue 讨论。

## 许可证

本项目使用 MIT 许可证。详细信息请参阅 [LICENSE](LICENSE) 文件。
