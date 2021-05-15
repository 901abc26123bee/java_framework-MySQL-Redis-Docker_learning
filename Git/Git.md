## 什麼是版本控制

版本控制（Revision control）是一種在開發的過程中用於管理我們對文件、目錄或工程等內容的修改歷史，方便查看更改歷史記錄，備份以便恢復以前的版本的軟件工程技術。

- 實現跨區域多人協同開發
- 追踪和記載一個或者多個文件的歷史記錄
- 組織和保護你的源代碼和文檔
- 統計工作量
- 並行開發、提高開發效率
- 跟踪記錄整個軟件的開發過程
- 減輕開發人員的負擔，節省時間，同時降低人為錯誤

<span style="color:coral">簡單說就是用於管理多人協同開發項目的技術。 </span>

沒有進行版本控製或者版本控製本身缺乏正確的流程管理，在軟件開發過程中將會引入很多問題，如軟件代碼的一致性、軟件內容的冗餘、軟件過程的事物性、軟件開發過程中的並發性、軟件源代碼的安全性，以及軟件的整合等問題。

## 常見的版本控制工具

主流的版本控制器有如下這些：

- **Git**
- **SVN**（Subversion）
- **CVS**（Concurrent Versions System）
- **VSS**（Micorosoft Visual SourceSafe）
- **TFS**（Team Foundation Server）
- Visual Studio Online

版本控制產品非常的多（Perforce、Rational ClearCase、RCS（GNU Revision Control System）、Serena Dimention、SVK、BitKeeper、Monotone、Bazaar、Mercurial、SourceGear Vault），現在影響力最大且使用最廣泛的是Git與SVN

## 版本控制分類

**1、本地版本控制**

記錄文件每次的更新，可以對每個版本做一個快照，或是記錄補丁文件，適合個人用，如RCS。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3S3N1OFVsSVR3TWxiWDNrTUd0WjlwMERnM2ZIcmJQcWJORU9NTzlHVGpGaFZhdWtNWld4NTRpY1M3ZVMyeDhBN0JFdTBWQjlpYndFaHpRLzY0MA?x-oss-process=image/format,png)

**2、集中版本控制 SVN**

所有的版本數據都保存在服務器上，協同開發者從服務器上同步更新或上傳自己的修改

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3S3N1OFVsSVR3TWxiWDNrTUd0WjlwMDBWNHVMYWlieHRaSTlSTHBxN3RrU2RsV2lhRjkyQVZlWjBpYjlEaWNxQmtTMnBvbzV1OHNFVTJtQ1EvNjQw?x-oss-process=image/format,png)

<span style="color:coral">所有的版本數據都存在服務器上，用戶的本地只有自己以前所同步的版本，如果不連網的話，用戶就看不到歷史版本，也無法切換版本驗證問題，或在不同分支工作</span>。而且，所有數據都保存在單一的服務器上，有很大的風險這個服務器會損壞，這樣就會丟失所有的數據，當然可以定期備份。代表產品：SVN、CVS、VSS

**3、分佈式版本控制 Git**

<span style="color:coral">每個人都擁有全部的代碼！安全隱患！ </span>

<span style="color:coral">所有版本信息倉庫全部同步到本地的每個用戶，這樣就可以在本地查看所有版本歷史，可以離線在本地提交，只需在連網時push到相應的服務器或其他用戶那裡</span>。由於每個用戶那裡保存的都是所有的版本數據，只要有一個用戶的設備沒有問題就可以恢復所有的數據，但這增加了本地存儲空間的佔用。

不會因為服務器損壞或者網絡問題，造成不能工作的情況！

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3S3N1OFVsSVR3TWxiWDNrTUd0WjlwMGV2OFE3cVhqc1RmZVN3RmV4ZEE0dEdqRkFpYVZFS1F6QUhkR2NJTlhJTEtmbEkyY2ZrOUJpYXdRLzY0MA?x-oss-process=image/format,png)



## Git與SVN的主要區別

SVN是集中式版本控制系統，版本庫是集中放在中央服務器的，而工作的時候，用的都是自己的電腦，所以首先要從中央服務器得到最新的版本，然後工作，完成工作後，需要把自己做完的活推送到中央服務器。集中式版本控制系統是必須聯網才能工作，對網絡帶寬要求較高

Git是分佈式版本控制系統，沒有中央服務器，每個人的電腦就是一個完整的版本庫，工作的時候不需要聯網了，因為版本都在自己電腦上。協同的方法是這樣的：比如說自己在電腦上改了文件A，其他人也在電腦上改了文件A，這時，你們兩之間只需把各自的修改推送給對方，就可以互相看到對方的修改了。 Git可以直接看到更新了哪些代碼和文件！

> 聊聊Git的歷史

同生活中的許多偉大事物一樣，Git 誕生於一個極富紛爭大舉創新的年代。

Linux 內核開源項目有著為數眾廣的參與者。絕大多數的 Linux 內核維護工作都花在了提交補丁和保存歸檔的繁瑣事務上(1991－2002年間)。到 2002 年，整個項目組開始啟用一個專有的分佈式版本控制系統 BitKeeper 來管理和維護代碼。

Linux社區中存在很多的大佬！破解研究 BitKeeper ！

到了 2005 年，開發 BitKeeper 的商業公司同 Linux 內核開源社區的合作關係結束，他們收回了 Linux 內核社區免費使用 BitKeeper 的權力。這就迫使 Linux 開源社區(特別是 Linux 的締造者 Linus Torvalds)基於使用 BitKeeper 時的經驗教訓，開發出自己的版本系統。 （2週左右！） 也就是後來的 Git！

> **Git是目前世界上最先進的分佈式版本控制系統。 **

Git是免費、開源的，最初Git是為輔助 Linux 內核開發的，來替代 BitKeeper！

**Git Bash：**Unix與Linux風格的命令行，使用最多，推薦最多

**Git CMD：**Windows風格的命令行

**Git GUI**：圖形界面的Git，不建議初學者使用，盡量先熟悉常用命令

## 常用的Linux命令

平時一定要多使用這些基礎的命令！

1）cd : 改變目錄。

2）cd . . 回退到上一個目錄，直接cd進入默認目錄

3）pwd : 顯示當前所在的目錄路徑。

<span style="color:coral">4）ls(ll): 都是列出當前目錄中的所有文件，只不過ll(兩個ll)列出的內容更為詳細。 </span>

<span style="color:coral">5）touch : 新建一個文件 如 touch index.js 就會在當前目錄下新建一個index.js文件。 </span>

6）rm: 刪除一個文件, rm index.js 就會把index.js文件刪除。

7）mkdir: 新建一個目錄,就是新建一個文件夾。

8、rm -r : 刪除一個文件夾, rm -r src 刪除src目錄

```php
rm -rf / 切勿在Linux中嘗試！刪除電腦中全部文件！
```

<span style="color:coral">9）mv 移動文件, mv index.html src -----> index.html 是我們要移動的文件, src 是目標文件夾</span>,<mark>當然, 這樣寫, 必須保證文件和目標文件夾在同一目錄下</mark>。

<span style="color:coral">10）reset 重新初始化終端/清屏。 </span>

11）clear 清屏。

12）history 查看命令歷史。

13）help 幫助。 14）、exit 退出。

15）#表示註釋

## Git配置

<mark>所有的配置文件，其實都保存在本地！ </mark>

<mark>  查看配置 git config -l  </mark>

<mark>配置環境變量 -----> 只是為了在全局使用</mark>

查看不同級別的配置文件：

```php
#查看系統config
git config --system --list
  
#查看當前用戶（global）配置
git config --global --list
```

**Git相關的配置文件：**

1）、Git\etc\gitconfig ：Git 安裝目錄下的 gitconfig --system 系統級

2）、C:\Users\Administrator\ .gitconfig 只適用於當前登錄用戶的配置 --global 全局

<span style="color:coral">這裡可以直接編輯配置文件，通過命令設置後會響應到這裡。 </span>

## 設置用戶名與郵箱（用戶標識，必要）

<mark>當你安裝Git後首先要做的事情是設置你的用戶名稱和e-mail地址。這是非常重要的，因為每次Git提交都會使用該信息。它被永遠的嵌入到了你的提交中：</mark>

```cs
git config --global user.name "kuangshen" #名稱
git config --global user.email 24736743@qq.com #郵箱
```

只需要做一次這個設置，如果你傳遞了--global 選項，因為Git將總是會使用該信息來處理你在系統中所做的一切操作。 <span style="color:coral">如果你希望在一個特定的項目中使用不同的名稱或e-mail地址，你可以在該項目中運行該命令而不要--global選項</span>。總之--global為全局配置，不加為某個項目的特定配置。

## 三個區域

<mark>Git基本理論 ---->  三個區域（重要）</mark>

Git本地有三個工作區域：工作目錄（Working Directory）、暫存區(Stage/Index)、資源庫(Repository或Git Directory)。如果在加上遠程的git倉庫(Remote Directory)就可以分為四個工作區域。文件在這四個區域之間的轉換關係如下：

<img src="./image/螢幕快照 2020-09-22 下午10.47.15.png">

- Workspace：工作區，就是你平時存放項目代碼的地方
- Index / Stage：暫存區，用於臨時存放你的改動，<span style="color:coral">事實上它只是一個文件，保存即將提交到文件列表信息</span>
- Repository：倉庫區（或本地倉庫），就是安全存放數據的位置，這裡面有你提交到所有版本的數據。其中HEAD指向最新放入倉庫的版本
- Remote：遠程倉庫，託管代碼的服務器，可以簡單的認為是你項目組中的一台電腦用於遠程數據交換

本地的三個區域確切的說應該是git倉庫中HEAD指向的版本：

<img src="./image/螢幕快照 2020-09-22 下午10.47.55.png"  />

- Directory：使用Git管理的一個目錄，也就是一個倉庫，包含我們的工作空間和Git的管理空間。
- WorkSpace：需要通過Git進行版本控制的目錄和文件，這些目錄和文件組成了工作空間。
- .git：存放Git管理信息的目錄，初始化倉庫的時候自動創建。
- Index/Stage：暫存區，或者叫待提交更新區，在提交進入repo之前，我們可以把所有的更新放在暫存區。
- Local Repo：本地倉庫，一個存放在本地的版本庫；HEAD會只是當前的開發分支（branch）。
- Stash：隱藏，是一個工作狀態保存棧，用於保存/恢復WorkSpace中的臨時狀態。

## 工作流程

<mark>工作流程</mark>

git的工作流程一般是這樣的：

１、在工作目錄中添加、修改文件；

２、將需要進行版本管理的文件放入暫存區域；

３、將暫存區域的文件提交到git倉庫。

因此，git管理的文件有三種狀態：已修改（modified）,已暫存（staged）,已提交(committed)

<img src="./image/螢幕快照 2020-09-22 下午10.47.55.png" alt="螢幕快照 2020-09-22 下午10.47.55" style="zoom:33%;" />

Git項目搭建

## 創建工作目錄與常用指令

<mark>創建工作目錄與常用指令</mark>

工作目錄（WorkSpace)一般就是你希望Git幫助你管理的文件夾，可以是你項目的目錄，也可以是一個空目錄，建議不要有中文。

日常使用只要記住下圖6個命令：

<img src="./image/螢幕快照 2020-09-22 下午10.51.18.png" />

## 本地倉庫搭建

<mark>本地倉庫搭建</mark>

創建本地倉庫的方法有兩種：一種是創建全新的倉庫，另一種是克隆遠程倉庫。

1、創建全新的倉庫，需要用GIT管理的項目的根目錄執行：

```shell
# 在當前目錄新建一個Git代碼庫
$ git init
```

2、執行後可以看到，僅僅在項目目錄多出了一個.git目錄，關於版本等的所有信息都在這個目錄裡面。

## 克隆遠程倉庫

<mark>克隆遠程倉庫</mark>

1、另一種方式是克隆遠程目錄，由於是將遠程服務器上的倉庫完全鏡像一份至本地！

```shell
# 克隆一個項目和它的整個代碼歷史(版本信息)
$ git clone [url] # https://gitee.com/kuangstudy/openclass.git
```

2、去 gitee 或者 github 上克隆一個測試！

Git文件操作

## 文件的四種狀態

<mark>文件的四種狀態</mark>

版本控制就是對文件的版本控制，要對文件進行修改、提交等操作，首先要知道文件當前在什麼狀態，不然可能會提交了現在還不想提交的文件，或者要提交的文件沒提交上。

- Untracked: 未跟踪, 此文件在文件夾中, 但並沒有加入到git庫, 不參與版本控制. 通過git add 狀態變為Staged.
- Unmodify: 文件已經入庫, 未修改, 即版本庫中的文件快照內容與文件夾中完全一致. 這種類型的文件有兩種去處, 如果它被修改, 而變為Modified. 如果使用git rm移出版本庫, 則成為Untracked文件
- Modified: 文件已修改, 僅僅是修改, 並沒有進行其他的操作. 這個文件也有兩個去處, 通過git add可進入暫存staged狀態, 使用git checkout 則丟棄修改過, 返回到unmodify狀態, 這個git checkout即從庫中取出文件, 覆蓋當前修改 !
- Staged: 暫存狀態. 執行git commit則將修改同步到庫中, 這時庫中的文件和本地文件又變為一致, 文件為Unmodify狀態. 執行git reset HEAD filename取消暫存, 文件狀態為Modified

## 查看文件狀態

上面說文件有4種狀態，通過如下命令可以查看到文件的狀態：

```properties
#查看指定文件狀態
git status [filename]
#查看所有文件狀態
git status
# git add . 添加所有文件到暫存區
# git commit -m "消息內容" 提交暫存區中的內容到本地倉庫 -m 提交信息
```

## 忽略文件

有些時候我們不想把某些文件納入版本控制中，比如數據庫文件，臨時文件，設計文件等

在主目錄下建立".gitignore"文件，此文件有如下規則：

1. 忽略文件中的空行或以井號（#）開始的行將會被忽略。
2. 可以使用Linux通配符。例如：星號（*）代表任意多個字符，問號（？）代表一個字符，方括號（[abc]）代表可選字符範圍，大括號（{string1,string2,...}）代表可選的字符串等。
3. 如果名稱的最前面有一個感嘆號（!），表示例外規則，將不被忽略。
4. 如果名稱的最前面是一個路徑分隔符（/），表示要忽略的文件在此目錄下，而子目錄中的文件不忽略。
5. 如果名稱的最後面是一個路徑分隔符（/），表示要忽略的是此目錄下該名稱的子目錄，而非文件（默認文件或目錄都忽略）。

```bash
#為註釋
*.txt #忽略所有 .txt結尾的文件,這樣的話上傳就不會被選中！
!lib.txt #但lib.txt除外
/temp #僅忽略項目根目錄下的TODO文件,不包括其它目錄temp
build/ #忽略build/目錄下的所有文件
doc/*.txt #會忽略 doc/notes.txt 但不包括 doc/server/arch.txt
```

## 說明：GIT分支

分支在GIT中相對較難，分支就是科幻電影裡面的平行宇宙，如果兩個平行宇宙互不干擾，那對現在的你也沒啥影響。不過，在某個時間點，兩個平行宇宙合併了，我們就需要處理一些問題了！

<img src="./image/螢幕快照 2020-09-22 下午11.46.05.png"  />

<img src="./image/螢幕快照 2020-09-22 下午11.46.12.png" />

git分支中常用指令：

```shell
# 列出所有本地分支
git branch

# 列出所有遠程分支
git branch -r

# 新建一個分支，但依然停留在當前分支
git branch [branch-name]

# 新建一個分支，並切換到該分支
git checkout -b [branch]

# 合併指定分支到當前分支
$ git merge [branch]

# 刪除分支
$ git branch -d [branch-name]

# 刪除遠程分支
$ git push origin --delete [branch-name]
$ git branch -dr [remote/branch]
```

<span style="color:coral">如果同一個文件在合併分支時都被修改了則會引起衝突：解決的辦法是我們可以修改衝突文件後重新提交！選擇要保留他的代碼還是你的代碼！ </span>

<mark>master主分支應該非常穩定，用來發布新版本，一般情況下不允許在上面工作，工作一般情況下在新建的dev分支上工作，工作完後，比如上要發布，或者說dev分支代碼穩定後可以合併到主分支master上來。 </mark>

作業練習：找一個小伙伴，一起搭建一個遠程倉庫，來練習Git！

1、不要把Git想的很難，工作中多練習使用就自然而然的會了！

2、Git的學習也十分多，看完我的Git教程之後，可以多去思考，總結到自己博客！