
namespace Lab1
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
            this.registrationButton = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.pin2TextBox = new System.Windows.Forms.TextBox();
            this.pin1TextBox = new System.Windows.Forms.TextBox();
            this.nameTextBox = new System.Windows.Forms.TextBox();
            this.pin2Label = new System.Windows.Forms.Label();
            this.pin1Label = new System.Windows.Forms.Label();
            this.nameLabel = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.fullRadioButton = new System.Windows.Forms.RadioButton();
            this.optionRadioButton = new System.Windows.Forms.RadioButton();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // registrationButton
            // 
            this.registrationButton.Location = new System.Drawing.Point(102, 246);
            this.registrationButton.Name = "registrationButton";
            this.registrationButton.Size = new System.Drawing.Size(131, 23);
            this.registrationButton.TabIndex = 1;
            this.registrationButton.Text = "Регистрация";
            this.registrationButton.UseVisualStyleBackColor = true;
            this.registrationButton.Click += new System.EventHandler(this.registrationButton_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.pin2TextBox);
            this.groupBox1.Controls.Add(this.pin1TextBox);
            this.groupBox1.Controls.Add(this.nameTextBox);
            this.groupBox1.Controls.Add(this.pin2Label);
            this.groupBox1.Controls.Add(this.pin1Label);
            this.groupBox1.Controls.Add(this.nameLabel);
            this.groupBox1.Location = new System.Drawing.Point(12, 90);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(319, 150);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Введите регистрационные данные";
            // 
            // pin2TextBox
            // 
            this.pin2TextBox.Location = new System.Drawing.Point(90, 79);
            this.pin2TextBox.Name = "pin2TextBox";
            this.pin2TextBox.PasswordChar = '⚫';
            this.pin2TextBox.Size = new System.Drawing.Size(181, 20);
            this.pin2TextBox.TabIndex = 5;
            // 
            // pin1TextBox
            // 
            this.pin1TextBox.Location = new System.Drawing.Point(90, 53);
            this.pin1TextBox.Name = "pin1TextBox";
            this.pin1TextBox.PasswordChar = '⚫';
            this.pin1TextBox.Size = new System.Drawing.Size(181, 20);
            this.pin1TextBox.TabIndex = 4;
            // 
            // nameTextBox
            // 
            this.nameTextBox.Location = new System.Drawing.Point(90, 27);
            this.nameTextBox.Name = "nameTextBox";
            this.nameTextBox.Size = new System.Drawing.Size(181, 20);
            this.nameTextBox.TabIndex = 3;
            // 
            // pin2Label
            // 
            this.pin2Label.AutoSize = true;
            this.pin2Label.Location = new System.Drawing.Point(16, 82);
            this.pin2Label.Name = "pin2Label";
            this.pin2Label.Size = new System.Drawing.Size(31, 13);
            this.pin2Label.TabIndex = 2;
            this.pin2Label.Text = "PIN2";
            // 
            // pin1Label
            // 
            this.pin1Label.AutoSize = true;
            this.pin1Label.Location = new System.Drawing.Point(16, 56);
            this.pin1Label.Name = "pin1Label";
            this.pin1Label.Size = new System.Drawing.Size(25, 13);
            this.pin1Label.TabIndex = 1;
            this.pin1Label.Text = "PIN";
            // 
            // nameLabel
            // 
            this.nameLabel.AutoSize = true;
            this.nameLabel.Location = new System.Drawing.Point(16, 30);
            this.nameLabel.Name = "nameLabel";
            this.nameLabel.Size = new System.Drawing.Size(35, 13);
            this.nameLabel.TabIndex = 0;
            this.nameLabel.Text = "Name";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(18, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(144, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Выберите тип регистрации";
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.Location = new System.Drawing.Point(21, 44);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(169, 17);
            this.checkBox1.TabIndex = 4;
            this.checkBox1.Text = "Расширенные возможности";
            this.checkBox1.UseVisualStyleBackColor = true;
            this.checkBox1.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // fullRadioButton
            // 
            this.fullRadioButton.AutoSize = true;
            this.fullRadioButton.Location = new System.Drawing.Point(228, 21);
            this.fullRadioButton.Name = "fullRadioButton";
            this.fullRadioButton.Size = new System.Drawing.Size(63, 17);
            this.fullRadioButton.TabIndex = 5;
            this.fullRadioButton.TabStop = true;
            this.fullRadioButton.Text = "Полная";
            this.fullRadioButton.UseVisualStyleBackColor = true;
            this.fullRadioButton.CheckedChanged += new System.EventHandler(this.fullRadioButton_CheckedChanged);
            // 
            // optionRadioButton
            // 
            this.optionRadioButton.AutoSize = true;
            this.optionRadioButton.Checked = true;
            this.optionRadioButton.Location = new System.Drawing.Point(228, 56);
            this.optionRadioButton.Name = "optionRadioButton";
            this.optionRadioButton.Size = new System.Drawing.Size(103, 17);
            this.optionRadioButton.TabIndex = 6;
            this.optionRadioButton.TabStop = true;
            this.optionRadioButton.Text = "Огранниченная";
            this.optionRadioButton.UseVisualStyleBackColor = true;
            this.optionRadioButton.CheckedChanged += new System.EventHandler(this.optionRadioButton_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(343, 281);
            this.Controls.Add(this.optionRadioButton);
            this.Controls.Add(this.fullRadioButton);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.registrationButton);
            this.Name = "Form1";
            this.Text = "Регистрация программы";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button registrationButton;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label pin2Label;
        private System.Windows.Forms.Label pin1Label;
        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.TextBox pin2TextBox;
        private System.Windows.Forms.TextBox pin1TextBox;
        private System.Windows.Forms.TextBox nameTextBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.RadioButton fullRadioButton;
        private System.Windows.Forms.RadioButton optionRadioButton;
    }
}

