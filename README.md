
# GitHub 代理工具

这是一个基于 Java 的简单代理工具，允许你通过自定义域名访问托管在 GitHub 上的文件。使用此工具，你可以绕过某些网络限制，轻松下载 GitHub 文件。

## 功能

- 代理访问托管在 GitHub 上的文件。
- 通过提供 GitHub 文件 URL，轻松通过你的网站下载文件。
- 支持类似 `https://你的ip/https://github.com/test/example.ini` 的 URL 来下载 `https://github.com/test/example.ini`。

## 工作原理

该工具允许你通过自定义域名代理 GitHub 上托管的文件。当你按照以下格式提供 GitHub URL 时，工具会获取该文件并通过你的网站提供。

例如：
- 输入：`https://你的ip/https://github.com/test/aa.ini`
- 输出：`https://github.com/test/aa.ini` 的内容。

## 前提条件

- Java 开发工具包（JDK 8 或更高版本）
- 一台用于托管 Java 应用的服务器



### 示例：

要从 GitHub 仓库下载 `aa.ini` 文件，可以使用以下 URL：

```
https://你的IP/https://github.com/test/aa.ini
```

## 配置

你可以在 `application.properties` 文件中配置服务器端口、基本 URL 及其他设置。根据你的环境更新以下属性：

```properties
server.port=80
# 可代理域名列表 逗号分隔
allow_domains: raw.githubusercontent.com,github.com
# 可代理文件后缀列表 逗号分隔
file_suffixes: .ini,.yaml,.txt,.java,.py,.html,.css,.js,.ts,.md,.list
```

## 贡献

欢迎贡献代码！如果你有改进建议、Bug 修复或新功能，可以随时提交 Pull Request 或打开 Issue 讨论。

## 许可证

本项目使用 MIT 许可证。详细信息请参阅 [LICENSE](LICENSE) 文件。
