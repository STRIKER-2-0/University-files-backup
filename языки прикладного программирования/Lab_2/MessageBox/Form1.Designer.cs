
namespace MessageBox
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
            this.interruptButton = new System.Windows.Forms.Button();
            this.yesNoCancelButton = new System.Windows.Forms.Button();
            this.OKButton = new System.Windows.Forms.Button();
            this.yesNoButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // interruptButton
            // 
            this.interruptButton.Location = new System.Drawing.Point(12, 0);
            this.interruptButton.Name = "interruptButton";
            this.interruptButton.Size = new System.Drawing.Size(206, 27);
            this.interruptButton.TabIndex = 0;
            this.interruptButton.Text = "Прервать Повторить Пропустить";
            this.interruptButton.UseVisualStyleBackColor = true;
            this.interruptButton.Click += new System.EventHandler(this.interruptButton_Click);
            // 
            // yesNoCancelButton
            // 
            this.yesNoCancelButton.Location = new System.Drawing.Point(12, 24);
            this.yesNoCancelButton.Name = "yesNoCancelButton";
            this.yesNoCancelButton.Size = new System.Drawing.Size(206, 27);
            this.yesNoCancelButton.TabIndex = 1;
            this.yesNoCancelButton.Text = "Да Нет Отмена";
            this.yesNoCancelButton.UseVisualStyleBackColor = true;
            this.yesNoCancelButton.Click += new System.EventHandler(this.yesNoCancelButton_Click);
            // 
            // OKButton
            // 
            this.OKButton.Location = new System.Drawing.Point(12, 47);
            this.OKButton.Name = "OKButton";
            this.OKButton.Size = new System.Drawing.Size(206, 27);
            this.OKButton.TabIndex = 2;
            this.OKButton.Text = "ОК";
            this.OKButton.UseVisualStyleBackColor = true;
            this.OKButton.Click += new System.EventHandler(this.OKButton_Click);
            // 
            // yesNoButton
            // 
            this.yesNoButton.Location = new System.Drawing.Point(12, 69);
            this.yesNoButton.Name = "yesNoButton";
            this.yesNoButton.Size = new System.Drawing.Size(206, 27);
            this.yesNoButton.TabIndex = 3;
            this.yesNoButton.Text = "Да Нет";
            this.yesNoButton.UseVisualStyleBackColor = true;
            this.yesNoButton.Click += new System.EventHandler(this.yesNoButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(230, 108);
            this.Controls.Add(this.yesNoButton);
            this.Controls.Add(this.OKButton);
            this.Controls.Add(this.yesNoCancelButton);
            this.Controls.Add(this.interruptButton);
            this.Name = "Form1";
            this.Text = "Message Box";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button interruptButton;
        private System.Windows.Forms.Button yesNoCancelButton;
        private System.Windows.Forms.Button OKButton;
        private System.Windows.Forms.Button yesNoButton;
    }
}

