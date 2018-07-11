# Unit Test基础

## 练习描述

实现猜数字的游戏。游戏有四个格子，每个格子有一个0到9的数字，任意两个格子的数字都不一样。你有6次猜测的机会，如果猜对则获胜，否则失败。每次猜测时需依序输入4个数字，程序会根据猜测的情况给出xAxB的反馈，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数。

例如：答案是1 2 3 4， 那么对于不同的输入，有如下的输出

 

**Example**：

> 答案是1 2 3 4， 那么对于不同的输入，有如下的输出
 

```
Input　　    Output             Instruction
1 5 6 7      1A0B                 1 correct
2 4 7 8      0A2B                 2 and 4 wrong position 
0 3 2 4      1A2B                 4 correct，2 and 3 wrong position
5 6 7 8      0A0B                 all wrong
4 3 2 1      0A4B                 4 numbers position wrong
1 2 3 4      4A0B                 win, all correct
1 1 2 3    Wrong Input，Input again
1 2        Wrong Input，Input again
```
 
答案在游戏开始时随机生成。输入只有6次机会，在每次猜测时，程序应给出当前猜测的结果，以及之前所有猜测的数字和结果以供玩家参考。输入界面为控制台（Console），以避免太多与问题无关的界面代码。
输入时，用空格分隔数字。

要求：
- 设计和编写测试用例
- 完成已有测试文件中的测试，并保证此测试文件所测类的测试覆盖率为100%
- 单元测试应涵盖所有核心业务逻辑
- 用小步骤进行单元测试重构
- 为单元测试和方法命名有意义的名称
- 代码通过小步骤提交并附上意义的评论

## 环境要求
- Java 8

## 如何开始

- 克隆模版库
- 在项目中`src/main`目录下的运行`Main.java`文件
  - 出现`Guess Number Game, You have 6 chances to guess!`，说明项目启动成功
- 在项目中`src/test`目录下完成对应的单元测试

## 如何测试
- 根目录下执行`./gradlew clean test`，查看测试结果

## 输出规范
- 完成需求的代码及测试
