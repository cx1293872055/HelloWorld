vim target.file

# NORMAL

- h 向左
- j 向下
- k 向上
- l 向右
---
- i 当前插入 I 行首非空插入
- a 字符末插入 A 行末插入
---
- w 下一个单词首 W 下一个空格区分单词首
- e 下一个单词末 E 下一个空格区分单词末
- b 后退单词首 B 后退空格区分单词首
---
- H 首行 行首 
- L 末行 行首
---
- dd 删除行
- yy 复制一行
- p 粘贴
---
- x 删除字符

- u 撤销
- CTRL r 恢复撤销

- CTRL f 下一页
- CTRL b 上一页

- o 在下一行新起一行insert
- O 在上一行新起一行insert

- m* 标记当前行
- ‘* 跳到标记行

- q* 宏录制
  - 再次q 结束宏录制
- @* 使用宏

- CTRL-w h j k l 分屏移动光标
- CTRL-w H J K L 分屏移动当前分屏

# COMMAND

- /**** 向下查找
- ?**** 向上查找
- n 下一个目标
- N 上一个目标

- read filename 读取文件内容到当前行

- marks 查看标记list
- delmarks * 删除某个标记
- delmarks! 删除所有标记

- . , $ % s/***/---/g range 替换*** 变成--- g:替换全部 

- e filename 左右分屏打开文件
- new filename 左右分屏新建文件
- vs filename 左右分屏
- sp filename 上下分屏

delete
- dw 删除单词
- daw
- dW 删除空格分割的单词
change
- cw 删除单词 并进入insert
- cW 删除空格分割的单词，并进入insert
- ciw 
- caw
yank
- yw 复制单词
- yW 复制空格分割的单词


# VISUAL BLOCK

- CTRL v I 块模式 插入