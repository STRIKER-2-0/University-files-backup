using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;

namespace lab1_2
{
    public partial class Form1 : Form
    {
        public Pen Pen { get; set; }
        bool draft;
        ArrayList points = new ArrayList();

        public Form1()
        {
            InitializeComponent();
            this.Cursor = new Cursor("PENCIL.cur");
            Pen = new Pen(Color.Red);
            this.BackColor = Color.Black;
        }

        private void Form1_MouseUp(object sender, MouseEventArgs e)
        {
            draft = false;
        }

        private void Form1_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                draft = true;
                points.Clear();
            }
        }

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            if(draft)
            {
                Point pt = new Point(e.X, e.Y);
                points.Add(pt);
                if(points.Count <= 1)
                {
                    return;
                }
                Point[] ptArr = new Point[points.Count];
                points.CopyTo(ptArr, 0);
                Graphics gr = this.CreateGraphics();
                gr.DrawCurve(Pen, ptArr);
            }
        }

        private void sizeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f = new Form2(this.Pen);
            f.ShowDialog(this);
        }

        private void colorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            colorDialog1.ShowDialog(this);
            Pen.Color = colorDialog1.Color;
        }
    }
}
