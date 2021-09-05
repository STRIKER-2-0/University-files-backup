
namespace AnimatedWindow
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.appearButton = new System.Windows.Forms.Button();
            this.horizontalButton = new System.Windows.Forms.Button();
            this.centerButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // appearButton
            // 
            this.appearButton.Location = new System.Drawing.Point(34, 59);
            this.appearButton.Name = "appearButton";
            this.appearButton.Size = new System.Drawing.Size(238, 23);
            this.appearButton.TabIndex = 0;
            this.appearButton.Text = "Проявление";
            this.appearButton.UseVisualStyleBackColor = true;
            this.appearButton.Click += new System.EventHandler(this.appearButton_Click);
            // 
            // horizontalButton
            // 
            this.horizontalButton.Location = new System.Drawing.Point(34, 126);
            this.horizontalButton.Name = "horizontalButton";
            this.horizontalButton.Size = new System.Drawing.Size(238, 23);
            this.horizontalButton.TabIndex = 1;
            this.horizontalButton.Text = "Горизонтальное появление";
            this.horizontalButton.UseVisualStyleBackColor = true;
            this.horizontalButton.Click += new System.EventHandler(this.horizontalButton_Click);
            // 
            // centerButton
            // 
            this.centerButton.Location = new System.Drawing.Point(34, 187);
            this.centerButton.Name = "centerButton";
            this.centerButton.Size = new System.Drawing.Size(238, 23);
            this.centerButton.TabIndex = 2;
            this.centerButton.Text = "Появление из центра";
            this.centerButton.UseVisualStyleBackColor = true;
            this.centerButton.Click += new System.EventHandler(this.centerButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(307, 289);
            this.Controls.Add(this.centerButton);
            this.Controls.Add(this.horizontalButton);
            this.Controls.Add(this.appearButton);
            this.Name = "Form1";
            this.Text = "Анимация формы";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button appearButton;
        private System.Windows.Forms.Button horizontalButton;
        private System.Windows.Forms.Button centerButton;
    }
}

