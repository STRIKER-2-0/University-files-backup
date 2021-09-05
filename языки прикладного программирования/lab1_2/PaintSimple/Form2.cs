using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lab1_2
{
    public partial class Form2 : Form
    {
        private Pen parentPen;

        public Form2(Pen parent)
        {
            this.parentPen = parent;
            InitializeComponent();
            numericUpDown1.Value = (decimal)parentPen.Width;
            trackBar1.Value = (int) parentPen.Width;
            repaintLine();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            parentPen.Width = (float) numericUpDown1.Value;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            repaintLine();
            numericUpDown1.Value = trackBar1.Value;
        }
        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            trackBar1.Value = (int)numericUpDown1.Value;
            repaintLine();
        }

        private void numericUpDown1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                parentPen.Width = (float)numericUpDown1.Value;
                trackBar1.Value = (int)numericUpDown1.Value;
                repaintLine();
                this.Close();
            }
        }

        private void repaintLine()
        {
            panel1.BackColor = parentPen.Color;
            panel1.Height = (int) numericUpDown1.Value;
            panel1.Location = new Point(panel1.Location.X, 75 - panel1.Height/2);
        }    
    }
}
