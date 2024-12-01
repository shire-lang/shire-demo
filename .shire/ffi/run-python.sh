#!/bin/bash

# 检查是否安装了Python
if ! command -v python3 &> /dev/null
then
    echo "Python is not installed. Please install Python before running this script."
    exit
fi

# 运行hello.py脚本
python3 issue-146.py
