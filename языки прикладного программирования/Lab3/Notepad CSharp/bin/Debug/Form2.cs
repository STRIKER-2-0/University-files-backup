using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Notepad
{
    public partial class Form2 : Form
    {
        private ToolStripMenuItem item;
        public Form2()
        {
            InitializeComponent();
            toolStripStatusLabel1.Text = "Amount of symbols: 0";
            toolStripStatusLabel2.Text = DateTime.Now.ToString("HH:mm:ss");
            toolStripStatusLabel2.ToolTipText = DateTime.Now.ToString("dd MMMM yyyy");
        }
        public string TextR
        {
            get { return richTextBox1.Text; }
            set { richTextBox1.Text = value; }
        }

        public ToolStripMenuItem Item { get => item; set => item = value; }

        public void LoadF(String fileName)
        {
            richTextBox1.LoadFile(fileName);  
        }
        public void FontR(Font f)
        {
            richTextBox1.Font = f;
        }
        public void ColorR(Color f)
        {
            richTextBox1.ForeColor = f;
        }
        
        public void Save(String saveName)
        {
            richTextBox1.SaveFile(saveName);
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            toolStripStatusLabel1.Text = "Amount of symbols: " + richTextBox1.Text.Length.ToString();
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            Form1 f1 = this.MdiParent as Form1;
            f1.delItem(item);
        }
    }
}
