class: center, middle

# Oracle Code One 2018<br>報告会 FB
## 第二回 定期勉強会
###### 2019-03-29

---

# Agenda

1. Oracle Code One 概説
2. 報告会の概要
3. 新しいJava
---
class: center, middle
# Oracle Code One 概要
---
## Oracle Code One 概要

<img src="https://www.oracle.com/a/evt/img/u20-oco19-logo.png">  
旧Java One。  
Java One : 1996年にSun Microsystemsが開始したJavaのイベント。

2018年からOracle Code One となり、Java以外の最新技術についても取り扱うようになった。
---
class: center, middle
# 報告会の概要
---
## 報告会の概要

### 蟹One楽しかった<br>報告会
※<a href="https://connpass.com/event/103226/" target="_blank">蟹の食べ放題イベント</a>
---
## 報告会の概要

### 新しいJavaの話
---
class: center, middle
# 新しいJava
---
class: center, middle
## JDKの新しいリリースモデル
---
## 今までのJDK
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

大きな新機能の完成に合わせたスケジュール  
　→不定期なアップデート  
　→すでに完成している機能のリリースが遅れる
---
## Java9からのJDK

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
<strong>新機能のリリースが早くなる</strong>
---
## そのほかの変更

- ライセンス変更
- 有償機能の無償化
  * Application Class Data Sharing（AppCDS）  
    複数アプリ利用時に、個々のアプリの起動時間を短縮する。
  * Z Garbage Collector（ZGC）  
    巨大なヒープ・メモリに最適化されたGC。
  * Java Flight Recorder  
    Javaアプリケーションの詳細な実行ログの取得機能。
  * Java Mission Control  
    Java Flight Recorderで取得したログの可視化／分析ツール。
- 提供を停止した機能
  * JavaFX
  * 32ビット版バイナリ
  * Java Web Start/Java Plug-in
---
class: center, middle
# 開発中のJava
---
class: center, middle
## プロジェクト Panama
---
## プロジェクト Panama
JVM上のプログラムから、Cなどのネイティブプログラムを利用しやすくするAPIの開発プロジェクト

<a href="http://smys0515.hatenablog.com/entry/2015/05/27/075421" target="_blank">JNIの問題点</a>
- 必要な手順が多い
- C/C++のコードを書かなければならない
---
class: center, middle
## プロジェクト Valhara
---
## プロジェクト Valhara
<blockquote cite="https://gihyo.jp/news/report/01/oco2018/0003">
  JVMおよびJava言語の型に関する定義や実装を拡張するプロジェクト
</blockquote>

#### Value Types
プリミティブ型と同じような挙動をする任意の型を定義できるように拡張  
これにより、参照のオーバーヘッドを削減する
---
## 従来のオブジェクトのメモリ配置
<blockquote>
  <figure>
    <img src="https://image.gihyo.co.jp/assets/images/news/report/01/oco2018/0003/thumb/TH400_001.jpg" alt="">
    <figcaption>
      出典：
      <a href="https://gihyo.jp/news/report/01/oco2018/0003" target="_blank">
        新たな歴史の1ページ～Oracle Code One 2018現地レポート
      </a>
    </figcaption>
  </figure>
</blockquote>
---
## Value Typesによるメモリ配置
<blockquote>
  <figure>
    <img src="https://image.gihyo.co.jp/assets/images/news/report/01/oco2018/0003/thumb/TH400_002.jpg" alt="">
    <figcaption>
      出典：
      <a href="https://gihyo.jp/news/report/01/oco2018/0003" target="_blank">
        新たな歴史の1ページ～Oracle Code One 2018現地レポート
      </a>
    </figcaption>
  </figure>
</blockquote>
---
class: center, middle
## ガベージコレクション系のプロジェクト
---
class: center, middle
ZGCか何か、巨大なヒープメモリを扱うのに最適化した<br>ガベージコレクションについて  
ほとんど記憶にないため割愛

<a href="https://blog.cybozu.io/entry/2018/05/29/080000" target="_blank">
  ざっくりわかった気になるモダンGC入門
</a>
---
class: center, middle
## Java10
---
## 286: Local-Variable Type Inference
<strong>ローカル変数の型推論</strong>  
ローカル変数も、ジェネリクス的に記述できる。
```
  var str = "123";
  var list = List.of("123");
```
※Java11からラムダ式でも利用可能に  
<small>323: Local-Variable Syntax for Lambda Parameters</small>
---
class: center, middle
## Java11
---
## 330: Launch Single-File Source-Code Programs
<strong>javac無しに実行可能</strong>

例）
```
  $ java HelloWorld.java
  Hello World!
```
---
class: center, middle
## Java12
---
## JEP 325: Switch Expressions (Preview)
<strong>Switch文の拡張</strong>  
<small>※Preview機能なのでまだ正式採用ではないが、近いリリースから正式化の見通し</small>
- caseに複数の値を指定可能
- アロー構文が利用可能
- 式として利用可能

例）
```
  String today = switch(weekday) {
    case SUNDAY -> "日曜日";
    case SATURDAY:
      break "土曜日";
    case MONDAY,TUESDAY -> "平日の前半";
    default -> "こなれてきた平日";
  }
```
---
class: center, middle
最新動向はこちら  
<a href="http://openjdk.java.net/" target="_blank">
  http://openjdk.java.net/
</a>  
<a href="http://hg.openjdk.java.net/" target="_blank">
  http://hg.openjdk.java.net/
</a>
---
#### 制作
<a href="https://getbootstrap.com/" target="_blank" style="margin-right:2rem;">
  <img height="100rem" src="https://v4-alpha.getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="bootstrap">bootstrap
</a>  
<a href="https://github.com/remarkjs" target="_blank">
  <img height="100rem" src="https://raw.githubusercontent.com/remarkjs/remark/4f6b3d7/logo.svg?sanitize=true" alt="remark.js">remark.js
</a>
