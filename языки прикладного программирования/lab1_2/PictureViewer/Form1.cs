using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Printing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PictureViewer
{
    public partial class Form1 : Form
    {
        private string path = "";
        private ToolStripMenuItem previous = null;
        public Form1()
        {
            InitializeComponent();
            pageSetupDialog1.Document = new PrintDocument();
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                if (openFileDialog1.ShowDialog(this) == DialogResult.OK)
                {
                    path = openFileDialog1.FileName;
                    pictureBox1.Image = Image.FromFile(path);
                    pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
                    toolStripStatusLabel1.Text = "Изображение: " + path;
                    toolStripStatusLabel2.Text = pictureBox1.Image.Width + "x" + pictureBox1.Image.Height;
                    fitSizeToolStripMenuItem.Enabled = true;
                    realSizeToolStripMenuItem.Enabled = true;
                    centerToolStripMenuItem.Enabled = true;
                    autoSizeToolStripMenuItem.Enabled = true;
                    fitSizeToolStripMenuItem.CheckState = CheckState.Checked;
                    if (previous != null)
                        previous.CheckState = CheckState.Unchecked;
                    previous = fitSizeToolStripMenuItem;
                }
            }
            catch
            {
                MessageBox.Show("Невозможно открыть изображение", "Ошибка",
                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }            
            
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                if (pictureBox1.Image == null)
                {
                    MessageBox.Show("Невозможно сохранить изображение", "Ошибка",
               MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return;
                }
                if (saveFileDialog1.ShowDialog(this) == DialogResult.OK)
                {
                    path = saveFileDialog1.FileName;
                    toolStripStatusLabel1.Text = "Изображение: " + path;
                    pictureBox1.Image.Save(saveFileDialog1.FileName, System.Drawing.Imaging.ImageFormat.Jpeg);
                }
            }
            catch
            {
                MessageBox.Show("Невозможно сохранить изображение", "Ошибка",
                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
        }

        private void pageSetupToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (pageSetupDialog1.ShowDialog(this) == DialogResult.OK)
            {}
        }

        private void printPreviewToolStripMenuItem_Click(object sender, EventArgs e)
        {
            printPreviewDialog1.Document = printDocument1;
            if(pictureBox1.Image != null)
            {
                printPreviewDialog1.Document.PrintPage += PrintPage;
            }
            printPreviewDialog1.ShowDialog(this);
        }

        private void PrintPage(object o, PrintPageEventArgs e)
        {                 
            Bitmap bmp = new Bitmap(pictureBox1.Image,
                                    pictureBox1.Image.Width * 2,
                                    pictureBox1.Image.Height * 2);
            e.Graphics.DrawImage((Image) bmp, new Point(10 ,10));
            e.Graphics.DrawString("Размер изображения: " + bmp.Size.ToString() + "\nПуть: " + path,
                                new Font(this.Font.Name, this.Font.Size * 3, this.Font.Style),
                                Brushes.Black,
                                new Point(20, bmp.Height+30));
        }

        private void printToolStripMenuItem_Click(object sender, EventArgs e)
        {
            printDialog1.ShowDialog(this);
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void fitSizeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            switchCheckState(fitSizeToolStripMenuItem);            
        }

        private void realSizeToolStripMenuItem_Click(object sender, EventArgs e)
        {            
            pictureBox1.SizeMode = PictureBoxSizeMode.Normal;
            switchCheckState(realSizeToolStripMenuItem);
        }

        private void centerToolStripMenuItem_Click(object sender, EventArgs e)
        {            
            pictureBox1.SizeMode = PictureBoxSizeMode.CenterImage;
            switchCheckState(centerToolStripMenuItem);
        }

        private void autoSizeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.AutoSize;
            switchCheckState(autoSizeToolStripMenuItem);
        }

        private void switchCheckState(ToolStripMenuItem next)
        {
            previous.CheckState = CheckState.Unchecked;
            next.CheckState = CheckState.Checked;
            previous = next;
        } 
    }
}
