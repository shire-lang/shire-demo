import tkinter as tk
from tkinter import ttk
from tkinter.scrolledtext import ScrolledText

def show_input_dialog():
    # 创建主窗口
    root = tk.Tk()
    root.title("Input Dialog")  # 使用英文标题，保持与IDE一致

    # 设置窗口大小和位置
    window_width = 500
    window_height = 320
    screen_width = root.winfo_screenwidth()
    screen_height = root.winfo_screenheight()
    center_x = int(screen_width/2 - window_width/2)
    center_y = int(screen_height/2 - window_height/2)
    root.geometry(f'{window_width}x{window_height}+{center_x}+{center_y}')

    # 设置现代深色主题
    root.configure(bg='#2b2b2b')  # IntelliJ暗色主题背景色

    # 配置ttk样式
    style = ttk.Style()
    style.theme_use('clam')  # 使用clam主题作为基础

    # 自定义样式
    style.configure('Custom.TFrame', background='#2b2b2b')
    style.configure('Custom.TLabel',
                    background='#2b2b2b',
                    foreground='#bababa',  # IntelliJ文字颜色
                    font=('Segoe UI', 12)
                    )

    # 扁平化主按钮样式
    style.configure('Primary.TButton',
                    background='#4B6EAF',
                    foreground='#ffffff',
                    padding=(16, 4),  # 减小垂直内边距
                    font=('Segoe UI', 11),
                    relief='flat',  # 扁平化效果
                    borderwidth=0   # 移除边框
                    )
    style.map('Primary.TButton',
              background=[('active', '#5881d8')],
              foreground=[('active', '#ffffff')],
              relief=[('pressed', 'flat')]  # 按下时保持扁平
              )

    # 扁平化次要按钮样式
    style.configure('Secondary.TButton',
                    background='#3C3F41',
                    foreground='#bababa',
                    padding=(16, 4),  # 减小垂直内边距
                    font=('Segoe UI', 11),
                    relief='flat',  # 扁平化效果
                    borderwidth=0   # 移除边框
                    )
    style.map('Secondary.TButton',
              background=[('active', '#494b4d')],
              foreground=[('active', '#ffffff')],
              relief=[('pressed', 'flat')]  # 按下时保持扁平
              )

    # 创建主容器
    main_frame = ttk.Frame(root, style='Custom.TFrame')
    main_frame.pack(fill=tk.BOTH, expand=True, padx=20, pady=15)

    # 创建标签
    label = ttk.Label(
        main_frame,
        text="Enter your content:",
        style='Custom.TLabel'
    )
    label.pack(anchor='w', pady=(0, 10))

    # 创建文本框
    text_widget = ScrolledText(
        main_frame,
        width=40,
        height=10,
        font=('JetBrains Mono', 12),  # 使用JetBrains字体
        wrap=tk.WORD,
        bg='#313335',  # 编辑器背景色
        fg='#bababa',  # 文字颜色
        insertbackground='#bababa',  # 光标颜色
        selectbackground='#214283',  # 选中文本背景色
        selectforeground='#ffffff',  # 选中文本前景色
        relief='flat',
        borderwidth=1
    )
    text_widget.pack(fill=tk.BOTH, expand=True, pady=(0, 8))

    # 添加默认提示文本
    placeholder = "Type your content here...\n\nSupports multiple lines"
    text_widget.insert('1.0', placeholder)
    text_widget.configure(fg='#666666')  # 提示文本颜色

    # 用于存储结果的变量
    result = {'text': None}

    # 按钮回调函数
    def on_confirm():
        result['text'] = text_widget.get('1.0', tk.END).strip()
        root.destroy()

    def on_cancel():
        result['text'] = None
        root.destroy()

    # 清除提示文本的函数
    def clear_placeholder(event):
        if text_widget.get('1.0', tk.END).strip() == placeholder.strip():
            text_widget.delete('1.0', tk.END)
            text_widget.configure(fg='#bababa')

    # 恢复提示文本的函数
    def restore_placeholder(event):
        if not text_widget.get('1.0', tk.END).strip():
            text_widget.insert('1.0', placeholder)
            text_widget.configure(fg='#666666')

    # 绑定事件
    text_widget.bind('<FocusIn>', clear_placeholder)
    text_widget.bind('<FocusOut>', restore_placeholder)

    # 创建按钮框架
    button_frame = ttk.Frame(main_frame, style='Custom.TFrame')
    button_frame.pack(fill=tk.X, pady=(0, 2))

    # 创建按钮
    cancel_btn = ttk.Button(
        button_frame,
        text="Cancel",
        style='Secondary.TButton',
        command=on_cancel
    )
    cancel_btn.pack(side=tk.RIGHT, padx=(4, 0))

    confirm_btn = ttk.Button(
        button_frame,
        text="Commit",
        style='Primary.TButton',
        command=on_confirm
    )
    confirm_btn.pack(side=tk.RIGHT)

    # 设置窗口为模态
    root.transient()
    root.grab_set()

    # 绑定ESC键为取消
    root.bind('<Escape>', lambda e: on_cancel())
    # 绑定回车键为确认
    root.bind('<Return>', lambda e: on_confirm())

    root.mainloop()

    return result['text']

if __name__ == "__main__":
    result = show_input_dialog()
    if result:
        print(f"User input:\n{result}")
    else:
        print("User cancelled the input")