# AI 辅助软件工程：CLI 命令生成

## 为什么需要 AI 来辅助 CLI？

## 什么是 CLI 命令生成

## 行业示例

### AutoDev 示例

如下是 AutoDev，Shire 的 prompt 示例：

```shire
---
name: "Terminal"
description: "Generate Cli"
interaction: AppendCursor
actionLocation: TerminalMenu
---

Return only the command to be executed as a raw string, no string delimiters
wrapping it, no yapping, no markdown, no fenced code blocks, what you return
will be passed to subprocess.check_output() directly.

- Today is: $today, user system is: $os,
- User current directory is: $cwd, user use is: $shellPath, according the tool to create the command.

For example, if the user asks: undo last git commit

You return only line command: git reset --soft HEAD~1

User asks: $input
```

### Codeium Termium

https://codeium.com/blog/termium-codeium-in-terminal-launch