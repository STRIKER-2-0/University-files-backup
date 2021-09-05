using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            pin2Visible(false);
        }

        
        private void fullRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            pin2Visible(true);
        }

        private void optionRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            pin2Visible(false);
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (optionRadioButton.Checked)
            {
                pin2Visible(checkBox1.Checked ? true : false);
            }
        }

        private void pin2Visible(bool status)
        {
            pin2Label.Visible = status;
            pin2TextBox.Visible = status;
        }

        private void registrationButton_Click(object sender, EventArgs e)
        {
            if(nameTextBox.Text.Equals("") ||
               pin1TextBox.Text.Equals("") || 
               pin2TextBox.Visible ? pin2TextBox.Text.Equals("") : false)
            {
                MessageBox.Show("Поля не заполнены!");
            }
        }
    }
}
