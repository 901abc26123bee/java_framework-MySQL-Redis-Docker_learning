[TCP/UDP 常用端口列表](https://wsgzao.github.io/post/service-names-port-numbers/)

## 服务器常用端口

| 端口        | 服务                                   | 说明                                                         |
| :---------- | :------------------------------------- | :----------------------------------------------------------- |
| 21          | FTP                                    | FTP 服务器所开放的端口，用于上传、下载                       |
| 22          | SSH                                    | 22 端口就是 ssh 端口，用于通过命令行模式远程连接 Linux 系统服务器 |
| 25          | SMTP                                   | SMTP 服务器所开放的端口，用于发送邮件                        |
| 80          | HTTP                                   | 用于网站服务例如 IIS、Apache、Nginx 等提供对外访问           |
| 110         | POP3                                   | 110 端口是为 POP3（邮件协议 3）服务开放的                    |
| 137/138/139 | NETBIOS                                | 其中 137、138 是 UDP 端口，当通过网上邻居传输文件时用这个端口。而 139 端口：通过这个端口进入的连接试图获得 NetBIOS/SMB 服务。这个协议被用于 windows 文件和打印机共享和 SAMBA |
| 143         | IMAP                                   | 143 端口主要是用于“Internet Message AccessProtocol”v2（Internet 消息访问协议，简称 IMAP），和 POP3 一样，是用于电子邮件的接收的协议 |
| 443         | HTTPS                                  | 网页浏览端口，能提供加密和通过安全端口传输的另一种 HTTP      |
| 1433        | SQL Server                             | 1433 端口，是 SQL Server 默认的端口，SQL Server 服务使用两个端口：TCP-1433、UDP-1434。其中 1433 用于供 SQL Server 对外提供服务，1434 用于向请求者返回 SQL Server 使用了哪个 TCP/IP 端口 |
| 3306        | MySQL                                  | 3306 端口，是 MySQL 数据库的默认端口，用于 MySQL 对外提供服务 |
| 3389        | Windows Server Remote Desktop Services | 3389 端口是 Windows 远程桌面的服务端口，可以通过这个端口，用 “远程桌面” 等连接工具来连接到远程的服务器 |
| 8080        | 代理端口                               | 8080 端口同 80 端口，是被用于 WWW 代理服务的，可以实现网页浏览，经常在访问某个网站或使用代理服务器的时候，会加上 “:8080” 端口号。另外 Apache Tomcat web server 安装后，默认的服务端口就是 8080 |
| 6379 | Redis||
