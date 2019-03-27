class: center, middle

# Oracle Code One 2018 報告会 FB
## 定期勉強会 第二回
###### 2019-03-29

---

# Agenda

1. 報告会の総評
2. JDKについて
3. 報告会で聞いた開発中のプロジェクト
4. 面白そうな新機能

---
class: center, middle
# 報告会の総評
---
# 報告会の総評

<h2 style="font-weight: bold;font-size: 5rem;text-align: center;">蟹One楽しかった報告会</h2>
※蟹の食べ放題イベント
---
# 報告会の総評

<h2 style="font-weight: bold;text-align: center;">JDKの開発中のプロジェクトが<br>おもしろいっていう報告</h2>
---
class: center, middle
# JDKについて
---
# JDK #とは

<strong>J</strong>ava <strong>D</strong>evelopment <strong>K</strong>it<br>
（Java用ソフトウェア開発キット）の略


---
# 今までのJDK

<blockquote>
  <figure>
    <img src="https://www.oracle.com/webfolder/technetwork/jp/java/articles/ja-topics/jdk-release-model/image003.png" alt="">
    <figcaption>
      出典：
      <a href="https://www.oracle.com/technetwork/jp/articles/java/ja-topics/jdk-release-model-4487660-ja.html" target="_blank">
        JDKの新しいリリース・モデルおよび提供ライセンスについて
      </a>
    </figcaption>
  </figure>
</blockquote>
---
# 今までのJDK

大きな新機能の完成に合わせたスケジュール  
　→不定期なアップデート  
　→すでに完成している機能のリリースが遅れる
---
# Java9から

<blockquote>
  <figure>
    <img src="https://oracle.com/a/tech/img/jdk-02.png" alt="">
    <figcaption>
      出典：
      <a href="https://www.oracle.com/technetwork/jp/articles/java/ja-topics/jdk-release-model-4487660-ja.html" target="_blank">
        JDKの新しいリリース・モデルおよび提供ライセンスについて
      </a>
    </figcaption>
  </figure>
</blockquote>
---
# そのほかの変更

  - ライセンス変更  
    JREの再配布を容易にするため
---
# そのほかの変更

### 有償機能の無償化
  - Application Class Data Sharing（AppCDS）  
    複数アプリ利用時に、個々のアプリの起動時間を短縮する。
  - Z Garbage Collector（ZGC）  
    巨大なヒープ・メモリに最適化されたGC。
  - Java Flight Recorder  
    Javaアプリケーションの詳細な実行ログの取得機能。
  - Java Mission Control  
    Java Flight Recorderで取得したログの可視化／分析ツール。
---
# そのほかの変更

### 提供を停止した機能
  - JavaFX
  - 32ビット版バイナリ
  - Java Web Start/Java Plug-in
---
class: center, middle
# 報告会で聞いた開発中のプロジェクト
---
# Panama
---
# Valhara
---
class: center, middle
# 面白そうな新機能
